package bo.ucb.edu.internship.dto;

public class EvaluacionPasantiaDTO {
    
    private int evaluacionId;
    private Double notaEvaluacion;
    private String comentsEvaluacion;
    private PracticaRealizadaDTO practicaRealizada;
    private EvaluadorDTO evaluador;

    public EvaluacionPasantiaDTO() {
    }

    public EvaluacionPasantiaDTO(int evaluacionId, Double notaEvaluacion, String comentsEvaluacion, PracticaRealizadaDTO practicaRealizada, EvaluadorDTO evaluador) {
        this.evaluacionId = evaluacionId;
        this.notaEvaluacion = notaEvaluacion;
        this.comentsEvaluacion = comentsEvaluacion;
        this.practicaRealizada = practicaRealizada;
        this.evaluador = evaluador;
    }

    // getters

    public int getEvaluacionId() {
        return evaluacionId;
    }

    public Double getNotaEvaluacion() {
        return notaEvaluacion;
    }

    public String getComentsEvaluacion() {
        return comentsEvaluacion;
    }

    public PracticaRealizadaDTO getPracticaRealizada() {
        return practicaRealizada;
    }

    public EvaluadorDTO getEvaluador() {
        return evaluador;
    }

    // setters

    public void setEvaluacionId(int evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    public void setNotaEvaluacion(Double notaEvaluacion) {
        this.notaEvaluacion = notaEvaluacion;
    }

    public void setComentsEvaluacion(String comentsEvaluacion) {
        this.comentsEvaluacion = comentsEvaluacion;
    }

    public void setPracticaRealizada(PracticaRealizadaDTO practicaRealizada) {
        this.practicaRealizada = practicaRealizada;
    }

    public void setEvaluador(EvaluadorDTO evaluador) {
        this.evaluador = evaluador;
    }

    @Override
    public String toString() {
        return "EvaluacionPasantiaDTO{" + "evaluacionId=" + evaluacionId + ", notaEvaluacion=" + notaEvaluacion + ", comentsEvaluacion=" + comentsEvaluacion + ", practicaRealizada=" + practicaRealizada + ", evaluador=" + evaluador + '}';
    }
}
