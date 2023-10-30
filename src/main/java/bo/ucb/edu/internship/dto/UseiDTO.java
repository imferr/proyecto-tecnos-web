package bo.ucb.edu.internship.dto;

public class UseiDTO {

    private int useiId;
    private UsuarioDTO user;
    private TipoUsuarioDTO typeUser;

    public UseiDTO() {
    }

    public UseiDTO(int useiId, UsuarioDTO user, TipoUsuarioDTO typeUser) {
        this.useiId = useiId;
        this.user = user;
        this.typeUser = typeUser;
    }

    // getters

    public int getUseiId() {
        return useiId;
    }

    public UsuarioDTO getUser() {
        return user;
    }

    public TipoUsuarioDTO getTypeUser() {
        return typeUser;
    }

    // setters

    public void setUseiId(int useiId) {
        this.useiId = useiId;
    }

    public void setUser(UsuarioDTO user) {
        this.user = user;
    }

    public void setTypeUser(TipoUsuarioDTO typeUser) {
        this.typeUser = typeUser;
    }

    @Override
    public String toString() {
        return "UseiDTO{" +
                "useiId=" + useiId +
                ", user=" + user +
                ", typeUser=" + typeUser +
                '}';
    }
}
