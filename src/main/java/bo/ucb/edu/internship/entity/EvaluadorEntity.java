package bo.ucb.edu.internship.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "evaluador")

public class EvaluadorEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluadorid")
    private Integer evaluatorId;

    @OneToOne
    @JoinColumn(name = "usuario_usuarioid", referencedColumnName = "usuarioid", nullable = false)
    private UsuarioEntity userId;

    @ManyToOne
    @JoinColumn(name = "tipousuario_tipo_usuario", referencedColumnName = "tipo_usuario", nullable = false)
    private TipoUsuarioEntity typeUser;

    public EvaluadorEntity() {
    }

    public EvaluadorEntity(Integer evaluatorId, UsuarioEntity userId, TipoUsuarioEntity typeUser) {
        this.evaluatorId = evaluatorId;
        this.userId = userId;
        this.typeUser = typeUser;
    }

    public Integer getEvaluatorId() {
        return evaluatorId;
    }

    public void setEvaluatorId(Integer evaluatorId) {
        this.evaluatorId = evaluatorId;
    }

    public UsuarioEntity getUserId() {
        return userId;
    }

    public void setUserId(UsuarioEntity userId) {
        this.userId = userId;
    }

    public TipoUsuarioEntity getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(TipoUsuarioEntity typeUser) {
        this.typeUser = typeUser;
    }

    @Override
    public String toString() {
        return "EvaluadorEntity{" +
                "evaluatorId=" + evaluatorId +
                ", userId=" + userId +
                ", typeUser=" + typeUser +
                '}';
    }
}
