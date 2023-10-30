package bo.ucb.edu.internship.entity;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "practicarealizada")

public class PracticaRealizadaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "practicaid")
    private Integer practicaId;

    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Column(name = "fecha_finalizacion", nullable = false)
    private Date fechaFinalizacion;

    @Column(name = "estado_practica", nullable = false)
    private Boolean estadoPractica;

    public PracticaRealizadaEntity() {
    }

    public PracticaRealizadaEntity(Integer practicaId, Date fechaInicio, Date fechaFinalizacion, Boolean estadoPractica) {
        this.practicaId = practicaId;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.estadoPractica = estadoPractica;
    }

    public Integer getPracticaRealizadaId() {
        return practicaId;
    }

    public Date getDatePracticaRealizadaBegin() {
        return fechaInicio;
    }

    public Date getDatePracticaRealizadaEnd() {
        return fechaFinalizacion;
    }

    public Boolean getStatePracticaRealizada() {
        return estadoPractica;
    }

    public void setPracticaRealizadaId(Integer practicaId) {
        this.practicaId = practicaId;
    }

    public void setDatePracticaRealizadaBegin(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setDatePracticaRealizadaEnd(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public void setStatePracticaRealizada(Boolean estadoPractica) {
        this.estadoPractica = estadoPractica;
    }

    @Override
    public String toString() {
        return "PracticaRealizadaEntity{" +
                "practicaRealizadaId=" + practicaId +
                ", datePracticaRealizadaBegin=" + fechaInicio +
                ", datePracticaRealizadaEnd=" + fechaFinalizacion +
                ", statePracticaRealizada=" + estadoPractica +
                '}';
    }

}
