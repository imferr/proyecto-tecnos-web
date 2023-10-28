package bo.ucb.edu.internship.dto;

import java.sql.Timestamp;

public class EventosPasantiaDTO {

    private int eventoId;
    private String tipoEvento;
    private Timestamp dateEvento;
    private String descriptionEvento;
    private PracticaRealizadaDTO practicaRealizada;
    private ConvocatoriaPracticaDTO convocatoriaPractica;

    public EventosPasantiaDTO() {
    }

    public EventosPasantiaDTO(int eventoId, String tipoEvento, Timestamp dateEvento, String descriptionEvento, PracticaRealizadaDTO practicaRealizada, ConvocatoriaPracticaDTO convocatoriaPractica) {
        this.eventoId = eventoId;
        this.tipoEvento = tipoEvento;
        this.dateEvento = dateEvento;
        this.descriptionEvento = descriptionEvento;
        this.practicaRealizada = practicaRealizada;
        this.convocatoriaPractica = convocatoriaPractica;
    }

    // getters

    public int getEventoId() {
        return eventoId;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public Timestamp getDateEvento() {
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

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public void setDateEvento(Timestamp dateEvento) {
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
                ", tipoEvento='" + tipoEvento + '\'' +
                ", dateEvento=" + dateEvento +
                ", descriptionEvento='" + descriptionEvento + '\'' +
                ", practicaRealizada=" + practicaRealizada +
                ", convocatoriaPractica=" + convocatoriaPractica +
                '}';
    }
}
