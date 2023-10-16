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
    @JoinColumn(name = "institucionempresa_empresaid", referencedColumnName = "empresaid", nullable = false)
    private EmpresaEntity companyId;

    @ManyToOne
    @JoinColumn(name = "usuario_usuarioid", referencedColumnName = "usuarioid", nullable = false)
    private UsuarioEntity userId;

    @ManyToOne
    @JoinColumn(name = "tipousuario_tipoid", referencedColumnName = "tipoid", nullable = false)
    private TipoUsuarioEntity typeUserId;

    public AdministradorEntity() {
    }

    public AdministradorEntity(Integer adminId, String position, EmpresaEntity companyId, UsuarioEntity userId, TipoUsuarioEntity typeUserId) {
        this.adminId = adminId;
        this.position = position;
        this.companyId = companyId;
        this.userId = userId;
        this.typeUserId = typeUserId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public String getPosition() {
        return position;
    }

    public EmpresaEntity getCompanyId() {
        return companyId;
    }

    public UsuarioEntity getUserId() {
        return userId;
    }

    public TipoUsuarioEntity getTypeUserId() {
        return typeUserId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setCompanyId(EmpresaEntity companyId) {
        this.companyId = companyId;
    }

    public void setUserId(UsuarioEntity userId) {
        this.userId = userId;
    }

    public void setTypeUserId(TipoUsuarioEntity typeUserId) {
        this.typeUserId = typeUserId;
    }

    @Override

    public String toString() {
        return "AdministradorEntity{" + "adminId=" + adminId + ", position='" + position + '\'' + ", companyId=" + companyId + ", userId=" + userId + ", typeUserId=" + typeUserId + '}';
    }

}

