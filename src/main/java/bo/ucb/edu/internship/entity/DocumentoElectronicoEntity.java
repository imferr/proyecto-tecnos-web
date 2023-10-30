package bo.ucb.edu.internship.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "documentoelectronico")
public class DocumentoElectronicoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DocumentoID")
    private Integer documentoId;

    @Column(name = "Tipo_documento", nullable = false, length = 30)
    private String tipoDocumento;

    @Column(name = "Nombre_documento", nullable = false, length = 50)
    private String nombreDocumento;

    @Column(name = "Contenido_documento", nullable = false)
    private byte[] contenidoDocumento;

    @ManyToOne
    @JoinColumn(name = "FormularioSolicitud_SolicitudID", referencedColumnName = "SolicitudID", nullable = false)
    private FormularioSolicitudEntity formularioSolicitudID;


    public DocumentoElectronicoEntity() {
    }

    public DocumentoElectronicoEntity(Integer documentoId, String tipoDocumento, String nombreDocumento, byte[] contenidoDocumento, FormularioSolicitudEntity formularioSolicitudID) {
        this.documentoId = documentoId;
        this.tipoDocumento = tipoDocumento;
        this.nombreDocumento = nombreDocumento;
        this.contenidoDocumento = contenidoDocumento;
        this.formularioSolicitudID = formularioSolicitudID;
    }

    // Getters and setters for other fields

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

    public FormularioSolicitudEntity getFormularioSolicitudId() {
        return formularioSolicitudID;
    }

    public void setFormularioSolicitudId(FormularioSolicitudEntity formularioSolicitudID) {
        this.formularioSolicitudID = formularioSolicitudID;
    }

    @Override
    public String toString() {
        return "DocumentoElectronicoEntity [documentoId=" + documentoId + ", tipoDocumento=" + tipoDocumento + ", nombreDocumento=" + nombreDocumento + "]";
    }
}
