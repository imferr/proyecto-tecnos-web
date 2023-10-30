package bo.ucb.edu.internship.entity;

import java.text.DecimalFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "evaluacionpasantia")

public class EvaluacionPasantiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluacionid")
    private Integer evaluacionId;

    @Column(name = "evaluacion_desempenio", nullable = false)
    private DecimalFormat notaEvaluacion;

    @Column(name = "comentario_evaluacion", length = 70, nullable = false)
    private String comentsEvaluacion;

    @ManyToOne
    @JoinColumn(name = "practicarealizada_practicaid", referencedColumnName = "practicaid" , nullable = false)
    private PracticaRealizadaEntity practicaRealizada;

    @ManyToOne
    @JoinColumn(name = "evaluador_evaluadorid", referencedColumnName = "evaluadorid" , nullable = false)
    private EvaluadorEntity evaluador;

    public EvaluacionPasantiaEntity() {
    }

    public EvaluacionPasantiaEntity(Integer evaluacionId, DecimalFormat notaEvaluacion, String comentsEvaluacion, PracticaRealizadaEntity practicaRealizada, EvaluadorEntity evaluador) {
        this.evaluacionId = evaluacionId;
        this.notaEvaluacion = notaEvaluacion;
        this.comentsEvaluacion = comentsEvaluacion;
        this.practicaRealizada = practicaRealizada;
        this.evaluador = evaluador;
    }

    public Integer getEvaluacionId() {
        return evaluacionId;
    }

    public DecimalFormat getNotaEvaluacion() {
        return notaEvaluacion;
    }

    public String getComentsEvaluacion() {
        return comentsEvaluacion;
    }

    public PracticaRealizadaEntity getPracticaRealizada() {
        return practicaRealizada;
    }

    public EvaluadorEntity getEvaluador() {
        return evaluador;
    }

    public void setEvaluacionId(Integer evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    public void setNotaEvaluacion(DecimalFormat notaEvaluacion) {
        this.notaEvaluacion = notaEvaluacion;
    }

    public void setComentsEvaluacion(String comentsEvaluacion) {
        this.comentsEvaluacion = comentsEvaluacion;
    }

    public void setPracticaRealizadaId(PracticaRealizadaEntity practicaRealizada) {
        this.practicaRealizada = practicaRealizada;
    }

    public void setEvaluadorId(EvaluadorEntity evaluador) {
        this.evaluador = evaluador;
    }

    @Override
    public String toString() {
        return "EvaluacionPasantiaEntity{" +
                "evaluacionId=" + evaluacionId +
                ", notaEvaluacion=" + notaEvaluacion +
                ", comentsEvaluacion='" + comentsEvaluacion + '\'' +
                ", practicaRealizada=" + practicaRealizada +
                ", evaluador=" + evaluador +
                '}';
    }
}
