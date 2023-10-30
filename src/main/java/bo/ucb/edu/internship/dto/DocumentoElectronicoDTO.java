package bo.ucb.edu.internship.dto;

public class DocumentoElectronicoDTO {

    private Integer documentoId;
    private String tipoDocumento;
    private String nombreDocumento;
    private byte[] contenidoDocumento;
    private FormularioSolicitudDTO formularioSolicitudId;

    public DocumentoElectronicoDTO() {
    }
    
    public DocumentoElectronicoDTO(Integer documentoId, String tipoDocumento, String nombreDocumento, byte[] contenidoDocumento, FormularioSolicitudDTO formularioSolicitudId) {
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

    public byte[] getContenidoDocumento() {
        return contenidoDocumento;
    }

    public void setContenidoDocumento(byte[] contenidoDocumento) {
        this.contenidoDocumento = contenidoDocumento;
    }

    public FormularioSolicitudDTO getFormularioSolicitudId() {
        return formularioSolicitudId;
    }

    public void setFormularioSolicitudId(FormularioSolicitudDTO formularioSolicitudId) {
        this.formularioSolicitudId = formularioSolicitudId;
    }
}