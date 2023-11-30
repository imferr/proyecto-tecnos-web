package bo.ucb.edu.internship.dto;

import java.util.Date;

public class UsuarioDTO {
    private int userId;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String carnet;
    private Date birth;
    private String gender;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int userId, String name, String lastName, String email, String password, String phone,
            String address, String carnet, Date birth, String gender) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.carnet = carnet;
        this.birth = birth;
        this.gender = gender;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UsuarioDTO [userId=" + userId + ", name=" + name + ", lastName=" + lastName + ", email=" + email
                + ", password=" + password + ", phone=" + phone + ", address=" + address + ", carnet=" + carnet
                + ", birth=" + birth + ", gender=" + gender + "]";
    }

    


}
