package bo.ucb.edu.internship.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "formulariosolicitud")
public class FormularioSolicitudEntity {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SolicitudID")
    private Integer requestId;

    @Column(name = "Fecha_solicitud", nullable = false)
    private java.util.Date requestDate;

    @Column(name = "Estado_solicitud", nullable = false)
    private Boolean requestStatus;

    @Column(name = "Documento_adjunto", length = 255, nullable = false)
    private String attachedDocument;

    @ManyToOne
    @JoinColumn(name = "Estudiante_EstudianteID", referencedColumnName = "EstudianteID", nullable = false)
    private EstudianteEntity studentId;



    public FormularioSolicitudEntity() {
    }

    public FormularioSolicitudEntity(Integer requestId, java.util.Date requestDate, Boolean requestStatus, String attachedDocument, EstudianteEntity studentId) {
        this.requestId = requestId;
        this.requestDate = requestDate;
        this.requestStatus = requestStatus;
        this.attachedDocument = attachedDocument;
        this.studentId = studentId;
    }

    // Other getters and setters

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public java.util.Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(java.util.Date requestDate) {
        this.requestDate = requestDate;
    }

    public Boolean getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(Boolean requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getAttachedDocument() {
        return attachedDocument;
    }

    public void setAttachedDocument(String attachedDocument) {
        this.attachedDocument = attachedDocument;
    }

    public EstudianteEntity getStudentId() {
        return studentId;
    }

    public void setStudentId(EstudianteEntity studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "FormularioSolicitudEntity [requestId=" + requestId + ", requestDate=" + requestDate + ", requestStatus=" + requestStatus + ", attachedDocument=" + attachedDocument + "]";
    }
}
