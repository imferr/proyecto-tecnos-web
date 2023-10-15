package bo.ucb.edu.internship.dto;

public class TipoUsuarioDTO {
    
    private int typeUserId;
    private String typeUser;

    public TipoUsuarioDTO() {
    }

    public TipoUsuarioDTO(Integer typeUserId, String typeUser) {
        this.typeUserId = typeUserId;
        this.typeUser = typeUser;
    }

    public Integer getTypeUserId() {
        return typeUserId;
    }

    public void setTypeUserId(Integer typeUserId) {
        this.typeUserId = typeUserId;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    @Override
    public String toString() {
        return "TypeUserDTO{" +
                "typeUserId=" + typeUserId +
                ", typeUser='" + typeUser + '\'' +
                '}';
    }
}
