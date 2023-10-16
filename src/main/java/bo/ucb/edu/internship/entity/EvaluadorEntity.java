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
    @JoinColumn(name = "tipousuario_tipoid", referencedColumnName = "tipoid", nullable = false)
    private TipoUsuarioEntity typeUserId;

    public EvaluadorEntity() {
    }

    public EvaluadorEntity(Integer evaluatorId, UsuarioEntity userId, TipoUsuarioEntity typeUserId) {
        this.evaluatorId = evaluatorId;
        this.userId = userId;
        this.typeUserId = typeUserId;
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

    public TipoUsuarioEntity getTypeUserId() {
        return typeUserId;
    }

    public void setTypeUserId(TipoUsuarioEntity typeUserId) {
        this.typeUserId = typeUserId;
    }

    @Override
    public String toString() {
        return "EvaluadorEntity [evaluatorId=" + evaluatorId + ", typeUserId=" + typeUserId + ", userId=" + userId
                + "]";
    }
}