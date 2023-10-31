package bo.ucb.edu.internship.dto;

public class DocumentoElectronicoDTO {

    private Integer documentoId;
    private String tipoDocumento;
    private String nombreDocumento;
    private String contenidoDocumento;
    private FormularioSolicitudDTO formularioSolicitudId;

    public DocumentoElectronicoDTO() {
    }
    
    public DocumentoElectronicoDTO(Integer documentoId, String tipoDocumento, String nombreDocumento, String contenidoDocumento, FormularioSolicitudDTO formularioSolicitudId) {
        this.documentoId = documentoId;
        this.tipoDocumento = tipoDocumento;
        this.nombreDocumento = nombreDocumento;
        this.contenidoDocumento = contenidoDocumento;
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

    public String getContenidoDocumento() {
        return contenidoDocumento;
    }

    public void setContenidoDocumento(String contenidoDocumento) {
        this.contenidoDocumento = contenidoDocumento;
    }

    public FormularioSolicitudDTO getFormularioSolicitudId() {
        return formularioSolicitudId;
    }

    public void setFormularioSolicitudId(FormularioSolicitudDTO formularioSolicitudId) {
        this.formularioSolicitudId = formularioSolicitudId;
    }
}