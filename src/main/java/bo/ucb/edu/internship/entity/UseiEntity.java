package bo.ucb.edu.internship.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usei")

public class UseiEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "useiid")
    private Integer useiId;

    @OneToOne
    @JoinColumn(name = "usuario_usuarioid", referencedColumnName = "usuarioid", nullable = false)
    private UsuarioEntity userId;

    @ManyToOne
    @JoinColumn(name = "tipousuario_tipoid", referencedColumnName = "tipoid", nullable = false)
    private TipoUsuarioEntity typeUserId;

    public UseiEntity() {
    }

    public UseiEntity(Integer useiId, UsuarioEntity userId, TipoUsuarioEntity typeUserId) {
        this.useiId = useiId;
        this.userId = userId;
        this.typeUserId = typeUserId;
    }

    public Integer getUseiId() {
        return useiId;
    }

    public UsuarioEntity getUserId() {
        return userId;
    }

    public TipoUsuarioEntity getTypeUserId() {
        return typeUserId;
    }

    public void setUseiId(Integer useiId) {
        this.useiId = useiId;
    }

    public void setUserId(UsuarioEntity userId) {
        this.userId = userId;
    }

    public void setTypeUserId(TipoUsuarioEntity typeUserId) {
        this.typeUserId = typeUserId;
    }

    @Override
    public String toString() {
        return "UseiEntity{" + "useiId=" + useiId + ", userId=" + userId + ", typeUserId=" + typeUserId + '}';
    }
}
