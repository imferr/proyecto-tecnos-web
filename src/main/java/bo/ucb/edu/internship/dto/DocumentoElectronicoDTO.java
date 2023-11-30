package bo.ucb.edu.internship.dto;

public class DocumentoElectronicoDTO {

    private Integer documentoId;
    private String tipoDocumento;
    private String nombreDocumento;
    private String URLDocumento;
    private FormularioSolicitudDTO formularioSolicitudId;

    public DocumentoElectronicoDTO() {
    }
    
    public DocumentoElectronicoDTO(Integer documentoId, String tipoDocumento, String nombreDocumento, String URLDocumento, FormularioSolicitudDTO formularioSolicitudId) {
        this.documentoId = documentoId;
        this.tipoDocumento = tipoDocumento;
        this.nombreDocumento = nombreDocumento;
        this.URLDocumento = URLDocumento;
        this.formularioSolicitudId = formularioSolicitudId;
    }

    public Integer getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(Integer documentoId) {
        this.documentoId = documentoId;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public String getURLDocumento() {
        return URLDocumento;
    }

    public void setURLDocumento(String URLDocumento) {
        this.URLDocumento = URLDocumento;
    }

    public FormularioSolicitudDTO getFormularioSolicitudId() {
        return formularioSolicitudId;
    }

    public void setFormularioSolicitudId(FormularioSolicitudDTO formularioSolicitudId) {
        this.formularioSolicitudId = formularioSolicitudId;
    }
}