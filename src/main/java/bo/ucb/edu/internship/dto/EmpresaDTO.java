package bo.ucb.edu.internship.dto;

public class EmpresaDTO {

    private int companyId;
    private String companyName;
    private String typeAgreement;
    private String requirements;
    private String phone;
    private String email;
    
    public EmpresaDTO() {
    }

    public EmpresaDTO(int companyId, String companyName, String typeAgreement, String requirements, String phone, String email) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.typeAgreement = typeAgreement;
        this.requirements = requirements;
        this.phone = phone;
        this.email = email;
    }

    // getters

    public int getCompanyId() {
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

    // setters:
    
    public void setCompanyId(int companyId) {
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
    public String toString(){
        return "CompanyDTO{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", typeAgreement='" + typeAgreement + '\'' +
                ", requirements='" + requirements + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
