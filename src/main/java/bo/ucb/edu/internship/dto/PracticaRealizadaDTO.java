package bo.ucb.edu.internship.dto;

import java.sql.Date;

public class PracticaRealizadaDTO {
    
    private int practicaRealizadaId;
    private Date datePracticaRealizadaBegin;
    private Date datePracticaRealizadaEnd;
    private Boolean statePracticaRealizada;

    public PracticaRealizadaDTO() {
    }

    public PracticaRealizadaDTO(int practicaRealizadaId, Date datePracticaRealizadaBegin, Date datePracticaRealizadaEnd, Boolean statePracticaRealizada) {
        this.practicaRealizadaId = practicaRealizadaId;
        this.datePracticaRealizadaBegin = datePracticaRealizadaBegin;
        this.datePracticaRealizadaEnd = datePracticaRealizadaEnd;
        this.statePracticaRealizada = statePracticaRealizada;
    }

    // getters

    public int getPracticaRealizadaId() {
        return practicaRealizadaId;
    }

    public Date getDatePracticaRealizadaBegin() {
        return datePracticaRealizadaBegin;
    }

    public Date getDatePracticaRealizadaEnd() {
        return datePracticaRealizadaEnd;
    }

    public Boolean getStatePracticaRealizada() {
        return statePracticaRealizada;
    }

    // setters

    public void setPracticaRealizadaId(int practicaRealizadaId) {
        this.practicaRealizadaId = practicaRealizadaId;
    }

    public void setDatePracticaRealizadaBegin(Date datePracticaRealizadaBegin) {
        this.datePracticaRealizadaBegin = datePracticaRealizadaBegin;
    }

    public void setDatePracticaRealizadaEnd(Date datePracticaRealizadaEnd) {
        this.datePracticaRealizadaEnd = datePracticaRealizadaEnd;
    }

    public void setStatePracticaRealizada(Boolean statePracticaRealizada) {
        this.statePracticaRealizada = statePracticaRealizada;
    }

    @Override
    public String toString() {
        return "PracticaRealizadaDTO{" +
                "practicaRealizadaId=" + practicaRealizadaId +
                ", datePracticaRealizadaBegin=" + datePracticaRealizadaBegin +
                ", datePracticaRealizadaEnd=" + datePracticaRealizadaEnd +
                ", statePracticaRealizada=" + statePracticaRealizada +
                '}';
    }
}
