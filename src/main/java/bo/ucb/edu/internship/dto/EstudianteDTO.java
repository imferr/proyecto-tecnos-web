package bo.ucb.edu.internship.dto;

public class EstudianteDTO {

    private int studentId;
    private String semester;
    private String carrier;
    private UsuarioDTO user;
    private TipoUsuarioDTO typeUser;

    public EstudianteDTO() {
    }

    public EstudianteDTO(int studentId, String semester, String carrier, UsuarioDTO user, TipoUsuarioDTO typeUser) {
        this.studentId = studentId;
        this.semester = semester;
        this.carrier = carrier;
        this.user = user;
        this.typeUser = typeUser;
    }

    // getters

    public int getStudentId() {
        return studentId;
    }

    public String getSemester() {
        return semester;
    }

    public String getCarrier() {
        return carrier;
    }

    public UsuarioDTO getUser() {
        return user;
    }

    public TipoUsuarioDTO getTypeUser() {
        return typeUser;
    }
    
    // setters

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public void setUser(UsuarioDTO user) {
        this.user = user;
    }

    public void setTypeUser(TipoUsuarioDTO typeUser) {
        this.typeUser = typeUser;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentId=" + studentId +
                ", semester='" + semester + '\'' +
                ", carrier='" + carrier + '\'' +
                ", user=" + user +
                ", typeUser=" + typeUser +
                '}';
    }
}
