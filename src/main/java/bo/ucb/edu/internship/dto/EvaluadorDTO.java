package bo.ucb.edu.internship.dto;

public class EvaluadorDTO {

    private int assessorId;
    private UsuarioDTO user;
    private TipoUsuarioDTO typeUser;

    public EvaluadorDTO() {
    }

    public EvaluadorDTO(int assessorId, UsuarioDTO user, TipoUsuarioDTO typeUser) {
        this.assessorId = assessorId;
        this.user = user;
        this.typeUser = typeUser;
    }

    // getters

    public int getAssessorId() {
        return assessorId;
    }

    public UsuarioDTO getUser() {
        return user;
    }

    public TipoUsuarioDTO getTypeUser() {
        return typeUser;
    }

    // setters

    public void setAssessorId(int assessorId) {
        this.assessorId = assessorId;
    }

    public void setUser(UsuarioDTO user) {
        this.user = user;
    }

    public void setTypeUser(TipoUsuarioDTO typeUser) {
        this.typeUser = typeUser;
    }

    @Override
    public String toString(){
        return "AssessorDTO{" +
                "assessorId=" + assessorId +
                ", user=" + user +
                ", typeUser=" + typeUser +
                '}';
    }
}
