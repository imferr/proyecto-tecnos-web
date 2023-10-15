package bo.ucb.edu.internship.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipousuario")

public class TipoUsuarioEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipoid")
    private Integer typeUserId;

    @Column(name = "tipo_usuario", length = 20, nullable = false)
    private String typeUser;

    public TipoUsuarioEntity() {
    }

    public TipoUsuarioEntity(Integer typeUserId, String typeUser) {
        this.typeUserId = typeUserId;
        this.typeUser = typeUser;
    }

    public Integer getTypeUserId() {
        return typeUserId;
    }

    public void setTypeUserId(Integer typeUserId) {
        this.typeUserId = typeUserId;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    @Override
    public String toString() {
        return "TypeUserEntity{" +
                "typeUserId=" + typeUserId +
                ", typeUser='" + typeUser + '\'' +
                '}';
    }
}
