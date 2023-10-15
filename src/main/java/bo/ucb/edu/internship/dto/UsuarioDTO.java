package bo.ucb.edu.internship.dto;

public class UsuarioDTO {
    private int userId;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String carnet;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer userId, String name, String lastName, String email, String password, String phone, String address, String carnet) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.carnet = carnet;
    }

    // getters

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }  

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone(){
        return phone;
    }

    public String getAddress(){
        return address;
    }

    public String getCarnet(){
        return carnet;
    }

    // setters

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setCarnet(String carnet){
        this.carnet = carnet;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", carnet='" + carnet + '\'' +
                '}';
    }
}
