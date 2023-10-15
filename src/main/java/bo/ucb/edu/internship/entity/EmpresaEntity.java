package bo.ucb.edu.internship.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "institutionempresa")

public class EmpresaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empresaid")
    private Integer companyId;

    @Column(name = "nombre_empresa", length = 50, nullable = false)
    private String companyName;

    @Column(name = "tipo_convenio", length = 30, nullable = false)
    private String typeAgreement;

    @Column(name = "requisito_convenio", length = 50, nullable = false)
    private String requirements;

    @Column(name = "telefono", length = 20, nullable = false)
    private String phone;

    @Column(name = "correo", length = 50, nullable = false)
    private String email;

    public EmpresaEntity() {
    }

    public EmpresaEntity(Integer companyId, String companyName, String typeAgreement, String requirements, String phone, String email) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.typeAgreement = typeAgreement;
        this.requirements = requirements;
        this.phone = phone;
        this.email = email;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public String getcompanyName() {
        return companyName;
    }

    public String getTypeAgreement() {
        return typeAgreement;
    }

    public String getRequirements() {
        return requirements;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public void setcompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setTypeAgreement(String typeAgreement) {
        this.typeAgreement = typeAgreement;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmpresaEntity{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", typeAgreement='" + typeAgreement + '\'' +
                ", requirements='" + requirements + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
