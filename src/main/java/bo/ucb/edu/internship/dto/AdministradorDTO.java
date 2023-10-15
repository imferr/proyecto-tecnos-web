package bo.ucb.edu.internship.dto;

public class AdministradorDTO {

    private int adminId;
    private String position;
    private EmpresaDTO company;
    private UsuarioDTO user;
    private TipoUsuarioDTO typeUser;

    public AdministradorDTO() {
    }

    public AdministradorDTO(int adminId, String position, EmpresaDTO company, UsuarioDTO user, TipoUsuarioDTO typeUser) {
        this.adminId = adminId;
        this.position = position;
        this.company = company;
        this.user = user;
        this.typeUser = typeUser;
    }

    // getters

    public int getAdminId() {
        return adminId;
    }

    public String getposition() {
        return position;
    }

    public EmpresaDTO getCompany() {
        return company;
    }

    public UsuarioDTO getUser() {
        return user;
    }

    public TipoUsuarioDTO getTypeUser() {
        return typeUser;
    }

    // setters

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public void setposition(String position) {
        this.position = position;
    }

    public void setCompany(EmpresaDTO company) {
        this.company = company;
    }

    public void setUser(UsuarioDTO user) {
        this.user = user;
    }

    public void setTypeUser(TipoUsuarioDTO typeUser) {
        this.typeUser = typeUser;
    }

    @Override

    public String toString() {
        return "AdministratorDTO{" +
                "adminId=" + adminId +
                ", position='" + position + '\'' +
                ", company=" + company +
                ", user=" + user +
                ", typeUser=" + typeUser +
                '}';
    }
}
