package bo.ucb.edu.internship.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "administrador")

public class AdministradorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "administradorid")
    private Integer adminId;

    @Column(name = "cargo", length = 30, nullable = false)
    private String position;

    @ManyToOne
    @JoinColumn(name = "usuario_usuarioid", referencedColumnName = "usuarioid", nullable = false)
    private UsuarioEntity userId;

    @ManyToOne
    @JoinColumn(name = "tipousuario_tipo_usuario", referencedColumnName = "tipo_usuario", nullable = false)
    private TipoUsuarioEntity typeUser;

    @ManyToMany
    @JoinColumn(name = "institucionempresa_empresaid", referencedColumnName = "empresaid", nullable = false)
    private EmpresaEntity companyId;

    public AdministradorEntity() {
    }

    public Integer getAdminId() {
        return adminId;
    }

    public String getPosition() {
        return position;
    }

    public UsuarioEntity getUserId() {
        return userId;
    }

    public TipoUsuarioEntity getTypeUser() {
        return typeUser;
    }

    public EmpresaEntity getCompanyId() {
        return companyId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setUserId(UsuarioEntity userId) {
        this.userId = userId;
    }

    public void setTypeUser(TipoUsuarioEntity typeUser) {
        this.typeUser = typeUser;
    }

    public void setCompanyId(EmpresaEntity companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "AdministradorEntity{" +
                "adminId=" + adminId +
                ", position='" + position + '\'' +
                ", userId=" + userId +
                ", typeUser=" + typeUser +
                ", companyId=" + companyId +
                '}';
    }
}
