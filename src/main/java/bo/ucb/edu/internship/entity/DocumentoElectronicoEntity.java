package bo.ucb.edu.internship.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "documentoelectronico")
public class DocumentoElectronicoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DocumentoID")
    private Integer documentoId;

    @Column(name = "Tipo_documento", nullable = false, length = 30)
    private String tipoDocumento;

    @Column(name = "Nombre_documento", nullable = false, length = 250)
    private String nombreDocumento;

    @Column(name = "Url_documento", nullable = false, length = 1000)
    private String URLDocumento;

    @ManyToOne
    @JoinColumn(name = "formulariosolicitud_solicitudid", referencedColumnName = "solicitudID", nullable = false)
    private FormularioSolicitudEntity formularioSolicitudID;


    public DocumentoElectronicoEntity() {
    }

    public DocumentoElectronicoEntity(Integer documentoId, String tipoDocumento, String nombreDocumento, String URLDocumento, FormularioSolicitudEntity formularioSolicitudID) {
        this.documentoId = documentoId;
        this.tipoDocumento = tipoDocumento;
        this.nombreDocumento = nombreDocumento;
        this.URLDocumento = URLDocumento;
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

    public String getURLDocumento() {
        return URLDocumento;
    }

    public void setURLDocumento(String URLDocumento) {
        this.URLDocumento = URLDocumento;
    }

    public FormularioSolicitudEntity getFormularioSolicitudId() {
        return formularioSolicitudID;
    }

    public void setFormularioSolicitudId(FormularioSolicitudEntity formularioSolicitudID) {
        this.formularioSolicitudID = formularioSolicitudID;
    }

    @Override
    public String toString() {
        return "DocumentoElectronicoEntity{" +
                "documentoId=" + documentoId +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", nombreDocumento='" + nombreDocumento + '\'' +
                ", URLDocumento='" + URLDocumento + '\'' +
                ", formularioSolicitudID=" + formularioSolicitudID +
                '}';
    }
}
