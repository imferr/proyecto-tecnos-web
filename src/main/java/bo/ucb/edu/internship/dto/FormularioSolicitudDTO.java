package bo.ucb.edu.internship.dto;

import java.util.Date;

public class FormularioSolicitudDTO {

    private Integer requestId;
    private Date requestDate;
    private Boolean requestStatus;
    private String attachedDocument;
    private EstudianteDTO studentId;

    public FormularioSolicitudDTO() {
    }

    public FormularioSolicitudDTO(Integer requestId, Date requestDate, Boolean requestStatus, String attachedDocument, EstudianteDTO studentId) {
        this.requestId = requestId;
        this.requestDate = requestDate;
        this.requestStatus = requestStatus;
        this.attachedDocument = attachedDocument;
        this.studentId = studentId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
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

    public EstudianteDTO getStudentId() {
        return studentId;
    }

    public void setStudentId(EstudianteDTO studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "FormularioSolicitudDTO [requestId=" + requestId + ", requestDate=" + requestDate + ", requestStatus=" + requestStatus + ", attachedDocument=" + attachedDocument + "]";
    }
}
