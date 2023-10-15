package bo.ucb.edu.internship.entity;

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

    public UsuarioEntity() {
    }

    public UsuarioEntity(Integer userId, String password, String name, String lastName, String email, String phone, String address, String carnet) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
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

    public String getEmail(){
        return email;
    }

    public String getPassword(){
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

    public void setName(String name){
        this.name = name;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setEmail(String email){
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
        return "UsuarioEntity{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", carnet='" + carnet + '\'' +
                '}';
    }
}
