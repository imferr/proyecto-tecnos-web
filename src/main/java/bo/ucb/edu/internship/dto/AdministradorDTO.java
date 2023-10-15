package bo.ucb.edu.internship.dto;

public class AdministradorDTO {

    private int adminId;
    private String workPosition;
    private EmpresaDTO company;
    private UsuarioDTO user;
    private TipoUsuarioDTO typeUser;

    public AdministradorDTO() {
    }

    public AdministradorDTO(int adminId, String workPosition, EmpresaDTO company, UsuarioDTO user, TipoUsuarioDTO typeUser) {
        this.adminId = adminId;
        this.workPosition = workPosition;
        this.company = company;
        this.user = user;
        this.typeUser = typeUser;
    }

    // getters

    public int getAdminId() {
        return adminId;
    }

    public String getWorkPosition() {
        return workPosition;
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

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
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
                ", workPosition='" + workPosition + '\'' +
                ", company=" + company +
                ", user=" + user +
                ", typeUser=" + typeUser +
                '}';
    }
}
