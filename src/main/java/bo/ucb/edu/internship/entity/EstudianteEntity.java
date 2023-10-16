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
    private UsuarioEntity user;

    @ManyToOne
    @JoinColumn(name = "tipousuario_tipo_usuario", referencedColumnName = "tipo_usuario", nullable = false)
    private TipoUsuarioEntity typeUser;
    
    


    public EstudianteEntity() {
    }

    public EstudianteEntity(Integer studentId, String semester, String carrier, UsuarioEntity user, TipoUsuarioEntity typeUser) {
        this.studentId = studentId;
        this.semester = semester;
        this.carrier = carrier;
        this.user = user;
        this.typeUser = typeUser;
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

    public UsuarioEntity getUser() {
        return user;
    }

    public TipoUsuarioEntity getTypeUser() {
        return typeUser;
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

    public void setUser(UsuarioEntity user) {
        this.user = user;
    }

    public void setTypeUser(TipoUsuarioEntity typeUser) {
        this.typeUser = typeUser;
    }

    @Override
    public String toString() {
        return "EstudianteEntity{" +
                "studentId=" + studentId +
                ", semester='" + semester + '\'' +
                ", carrier='" + carrier + '\'' +
                ", user=" + user +
                ", typeUser=" + typeUser +
                '}';
    }
}
