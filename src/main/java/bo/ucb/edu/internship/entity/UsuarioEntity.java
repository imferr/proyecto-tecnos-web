package bo.ucb.edu.internship.entity;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")

public class UsuarioEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuarioid")
    private Integer userId;

    @Column(name = "contrasenia", length = 20, nullable = false)
    private String password;

    @Column(name = "nombre", length = 50, nullable = false)
    private String name;

    @Column(name = "apellido", length = 50, nullable = false)
    private String lastName;

    @Column(name = "correo", length = 50, nullable = false)
    private String email;

    @Column(name = "telefono", length = 20, nullable = false)
    private String phone;

    @Column(name = "direccion", length = 50, nullable = false)
    private String address;

    @Column(name = "carnet", length = 30, nullable = false)
    private String carnet;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date birth;

    @Column(name = "genero", length = 20, nullable = false)
    private String gender;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Integer userId, String password, String name, String lastName, String email, String phone,
            String address, String carnet, Date birth, String gender) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.carnet = carnet;
        this.birth = birth;
        this.gender = gender;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "UsuarioEntity [userId=" + userId + ", password=" + password + ", name=" + name + ", lastName="
                + lastName + ", email=" + email + ", phone=" + phone + ", address=" + address + ", carnet=" + carnet
                + ", birth=" + birth + ", gender=" + gender + "]";
    }

    
}
