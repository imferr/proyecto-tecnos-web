package bo.ucb.edu.internship.dto;

import java.sql.Date;

public class EventosPasantiaDTO {

    private int eventoId;
    private String titleEvento;
    private Date dateEvento;
    private String descriptionEvento;
    private PracticaRealizadaDTO practicaRealizada;
    private ConvocatoriaPracticaDTO convocatoriaPractica;

    public EventosPasantiaDTO() {
    }

    public EventosPasantiaDTO(int eventoId, String titleEvento, Date dateEvento, String descriptionEvento, PracticaRealizadaDTO practicaRealizada, ConvocatoriaPracticaDTO convocatoriaPractica) {
        this.eventoId = eventoId;
        this.titleEvento = titleEvento;
        this.dateEvento = dateEvento;
        this.descriptionEvento = descriptionEvento;
        this.practicaRealizada = practicaRealizada;
        this.convocatoriaPractica = convocatoriaPractica;
    }

    // getters

    public int getEventoId() {
        return eventoId;
    }

    public String getTitleEvento() {
        return titleEvento;
    }

    public Date getDateEvento() {
        return dateEvento;
    }

    public String getDescriptionEvento() {
        return descriptionEvento;
    }

    public PracticaRealizadaDTO getPracticaRealizada() {
        return practicaRealizada;
    }

    public ConvocatoriaPracticaDTO getConvocatoriaPractica() {
        return convocatoriaPractica;
    }

    // setters

    public void setEventoId(int eventoId) {
        this.eventoId = eventoId;
    }

    public void setTitleEvento(String titleEvento) {
        this.titleEvento = titleEvento;
    }

    public void setDateEvento(Date dateEvento) {
        this.dateEvento = dateEvento;
    }

    public void setDescriptionEvento(String descriptionEvento) {
        this.descriptionEvento = descriptionEvento;
    }

    public void setPracticaRealizada(PracticaRealizadaDTO practicaRealizada) {
        this.practicaRealizada = practicaRealizada;
    }

    public void setConvocatoriaPractica(ConvocatoriaPracticaDTO convocatoriaPractica) {
        this.convocatoriaPractica = convocatoriaPractica;
    }

    @Override
    public String toString() {
        return "EventosPasantiaDTO{" +
                "eventoId=" + eventoId +
                ", titleEvento='" + titleEvento + '\'' +
                ", dateEvento=" + dateEvento +
                ", descriptionEvento='" + descriptionEvento + '\'' +
                ", practicaRealizada=" + practicaRealizada +
                ", convocatoriaPractica=" + convocatoriaPractica +
                '}';
    }
}
