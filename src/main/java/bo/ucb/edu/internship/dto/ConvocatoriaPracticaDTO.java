package bo.ucb.edu.internship.dto;

import java.sql.Date;

public class ConvocatoriaPracticaDTO {

    private int convocatoriaPracticaId;
    private String titleConvocatoria;
    private String descriptionConvocatoria;
    private Date dateConvocatoria;
    private Boolean stateConvocatoria;
    private EmpresaDTO company;
    private UseiDTO usei;

    public ConvocatoriaPracticaDTO() {
    }

    public ConvocatoriaPracticaDTO(int convocatoriaPracticaId, String titleConvocatoria, String descriptionConvocatoria, Date dateConvocatoria, Boolean stateConvocatoria, EmpresaDTO company, UseiDTO usei) {
        this.convocatoriaPracticaId = convocatoriaPracticaId;
        this.titleConvocatoria = titleConvocatoria;
        this.descriptionConvocatoria = descriptionConvocatoria;
        this.dateConvocatoria = dateConvocatoria;
        this.stateConvocatoria = stateConvocatoria;
        this.company = company;
        this.usei = usei;
    }

    // getters

    public int getConvocatoriaPracticaId() {
        return convocatoriaPracticaId;
    }

    public String getTitleConvocatoria() {
        return titleConvocatoria;
    }

    public String getDescriptionConvocatoria() {
        return descriptionConvocatoria;
    }

    public Date getDateConvocatoria() {
        return dateConvocatoria;
    }

    public Boolean getStateConvocatoria() {
        return stateConvocatoria;
    }

    public EmpresaDTO getCompany() {
        return company;
    }

    public UseiDTO getUsei() {
        return usei;
    }

    // setters

    public void setConvocatoriaPracticaId(int convocatoriaPracticaId) {
        this.convocatoriaPracticaId = convocatoriaPracticaId;
    }

    public void setTitleConvocatoria(String titleConvocatoria) {
        this.titleConvocatoria = titleConvocatoria;
    }

    public void setDescriptionConvocatoria(String descriptionConvocatoria) {
        this.descriptionConvocatoria = descriptionConvocatoria;
    }

    public void setDateConvocatoria(Date dateConvocatoria) {
        this.dateConvocatoria = dateConvocatoria;
    }

    public void setStateConvocatoria(Boolean stateConvocatoria) {
        this.stateConvocatoria = stateConvocatoria;
    }

    public void setCompany(EmpresaDTO company) {
        this.company = company;
    }

    public void setUsei(UseiDTO usei) {
        this.usei = usei;
    }

    @Override
    public String toString() {
        return "ConvocatoriaPracticaDTO{" +
                "convocatoriaPracticaId=" + convocatoriaPracticaId +
                ", titleConvocatoria='" + titleConvocatoria + '\'' +
                ", descriptionConvocatoria='" + descriptionConvocatoria + '\'' +
                ", dateConvocatoria=" + dateConvocatoria +
                ", stateConvocatoria=" + stateConvocatoria +
                ", company=" + company +
                ", usei=" + usei +
                '}';
    }
    
}
