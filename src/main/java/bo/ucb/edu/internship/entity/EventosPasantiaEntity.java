package bo.ucb.edu.internship.entity;

import java.security.Timestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "eventospasantia")

public class EventosPasantiaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventoid")
    private Integer eventoId;

    @Column(name = "tipo_evento", length = 30, nullable = false)
    private String tipoEvento;

    @Column(name = "fecha_hora_evento", nullable = false)
    private Timestamp fechaHoraEvento;

    @Column(name = "descripcion_evento", length = 50, nullable = false)
    private String descripcionEvento;

    @ManyToOne
    @JoinColumn(name = "practicarealizada_practicaid", referencedColumnName = "practicaid" , nullable = false)
    private PracticaRealizadaEntity practicaRealizada;

    @ManyToOne
    @JoinColumn(name = "convocatoriapractica_convocatoriaid", referencedColumnName = "convocatoriaid" , nullable = false)
    private ConvocatoriaPracticaEntity convocatoriaPractica;

    public EventosPasantiaEntity() {
    }

    public EventosPasantiaEntity(Integer eventoId, String tipoEvento, Timestamp fechaHoraEvento, String descripcionEvento, PracticaRealizadaEntity practicaRealizada, ConvocatoriaPracticaEntity convocatoriaPractica) {
        this.eventoId = eventoId;
        this.tipoEvento = tipoEvento;
        this.fechaHoraEvento = fechaHoraEvento;
        this.descripcionEvento = descripcionEvento;
        this.practicaRealizada = practicaRealizada;
        this.convocatoriaPractica = convocatoriaPractica;
    }

    public Integer getEventoId() {
        return eventoId;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public Timestamp getDateEvento() {
        return fechaHoraEvento;
    }

    public String getDescriptionEvento() {
        return descripcionEvento;
    }

    public PracticaRealizadaEntity getPracticaRealizada() {
        return practicaRealizada;
    }

    public ConvocatoriaPracticaEntity getConvocatoriaPractica() {
        return convocatoriaPractica;
    }

    public void setEventoId(Integer eventoId) {
        this.eventoId = eventoId;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public void setDateEvento(Timestamp dateEvento) {
        this.fechaHoraEvento = dateEvento;
    }

    public void setDescriptionEvento(String descriptionEvento) {
        this.descripcionEvento = descriptionEvento;
    }

    public void setPracticaRealizada(PracticaRealizadaEntity practicaRealizada) {
        this.practicaRealizada = practicaRealizada;
    }

    public void setConvocatoriaPractica(ConvocatoriaPracticaEntity convocatoriaPractica) {
        this.convocatoriaPractica = convocatoriaPractica;
    }

    @Override
    public String toString() {
        return "EventosPasantiaEntity{" +
                "eventoId=" + eventoId +
                ", tipoEvento='" + tipoEvento + '\'' +
                ", dateEvento=" + fechaHoraEvento +
                ", descriptionEvento='" + descripcionEvento + '\'' +
                ", practicaRealizada=" + practicaRealizada +
                ", convocatoriaPractica=" + convocatoriaPractica +
                '}';
    }

}
