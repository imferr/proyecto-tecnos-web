package bo.ucb.edu.internship.dto;

public class EvaluadorDTO {

    private int evaluatorId;
    private UsuarioDTO user;
    private TipoUsuarioDTO typeUser;

    public EvaluadorDTO() {
    }

    public EvaluadorDTO(int evaluatorId, UsuarioDTO user, TipoUsuarioDTO typeUser) {
        this.evaluatorId = evaluatorId;
        this.user = user;
        this.typeUser = typeUser;
    }

    // getters

    public int getevaluatorId() {
        return evaluatorId;
    }

    public UsuarioDTO getUser() {
        return user;
    }

    public TipoUsuarioDTO getTypeUser() {
        return typeUser;
    }

    // setters

    public void setevaluatorId(int evaluatorId) {
        this.evaluatorId = evaluatorId;
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
                "evaluatorId=" + evaluatorId +
                ", user=" + user +
                ", typeUser=" + typeUser +
                '}';
    }
}
