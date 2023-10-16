package bo.ucb.edu.internship.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiante")
public class EstudianteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estudianteid")
    private Integer studentId;

    @Column(name = "semestre", length = 50, nullable = false)
    private String semester;

    @Column(name = "carrera", length = 50, nullable = false)
    private String carrier;

    @OneToOne
    @JoinColumn(name = "usuario_usuarioid", referencedColumnName = "usuarioid", nullable = false)
    private UsuarioEntity userId;

    @ManyToOne
    @JoinColumn(name = "tipousuario_tipoid", referencedColumnName = "tipoid", nullable = false)
    private TipoUsuarioEntity typeUserId;
    
    


    public EstudianteEntity() {
    }

    public EstudianteEntity( String semester, String carrier, UsuarioEntity userId, TipoUsuarioEntity typeUserId) {
        this.semester = semester;
        this.carrier = carrier;
        this.userId = userId;
        this.typeUserId = typeUserId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getSemester() {
        return semester;
    }

    public String getCarrier() {
        return carrier;
    }

    public UsuarioEntity getUserId() {
        return userId;
    }

    public TipoUsuarioEntity getTypeUserId() {
        return typeUserId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public void setUserId(UsuarioEntity userId) {
        this.userId = userId;
    }

    public void setTypeUserId(TipoUsuarioEntity typeUserId) {
        this.typeUserId = typeUserId;
    }

    @Override

    public String toString() {
        return "EstudianteEntity [carrier=" + carrier + ", semester=" + semester + ", studentId=" + studentId
                + ", typeUserId=" + typeUserId + ", userId=" + userId + "]";
    }
}