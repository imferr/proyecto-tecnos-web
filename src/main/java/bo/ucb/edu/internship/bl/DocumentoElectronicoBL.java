package bo.ucb.edu.internship.bl;

import java.util.List;

import org.springframework.stereotype.Service;

import bo.ucb.edu.internship.dao.DocumentoElectronicoDAO;
import bo.ucb.edu.internship.dao.FormularioSolicitudDAO;
import bo.ucb.edu.internship.entity.DocumentoElectronicoEntity;
import bo.ucb.edu.internship.entity.FormularioSolicitudEntity;

@Service
public class DocumentoElectronicoBL {
    
    private final DocumentoElectronicoDAO documentoElectronicoDAO;
    private final FormularioSolicitudDAO formularioSolicitudDAO;

    public DocumentoElectronicoBL(DocumentoElectronicoDAO documentoElectronicoDAO, FormularioSolicitudDAO formularioSolicitudDAO) {
        this.documentoElectronicoDAO = documentoElectronicoDAO;
        this.formularioSolicitudDAO = formularioSolicitudDAO;
    }

    public DocumentoElectronicoEntity createDocumentoElectronico(String tipoDocumento, String nombreDocumento, String URLDocumento, Integer formularioSolicitudID) {
        if (tipoDocumento == null || tipoDocumento.isEmpty()) {
            throw new RuntimeException("El tipo de documento debe estar completo");
        } else if (nombreDocumento == null || nombreDocumento.isEmpty()) {
            throw new RuntimeException("El nombre del documento debe estar completo");
        } else if (URLDocumento == null || URLDocumento.isEmpty()) {
            throw new RuntimeException("El URL del documento debe estar completo");
        } else if (formularioSolicitudID == null) {
            throw new RuntimeException("El ID del formulario de solicitud debe estar completo");
        }

        FormularioSolicitudEntity formularioSolicitud = formularioSolicitudDAO.findById(formularioSolicitudID).orElseThrow(() -> new RuntimeException("No se encontró ningún formulario de solicitud con el ID proporcionado"));
        DocumentoElectronicoEntity documentoElectronico = new DocumentoElectronicoEntity();
        documentoElectronico.setTipoDocumento(tipoDocumento);
        documentoElectronico.setNombreDocumento(nombreDocumento);
        documentoElectronico.setURLDocumento(URLDocumento);
        documentoElectronico.setFormularioSolicitudId(formularioSolicitud);

        return documentoElectronicoDAO.save(documentoElectronico);
    }

    public List<DocumentoElectronicoEntity> getAllDocumentosElectronicos() {
        return documentoElectronicoDAO.findAll();
    }

    public DocumentoElectronicoEntity findDocumentoElectronicoById(Integer id) {
        return documentoElectronicoDAO.findById(id).orElseThrow(() -> new RuntimeException("No se encontró ningún documento electrónico con el ID proporcionado"));
    }

    public DocumentoElectronicoEntity updateDocumentoElectronico(Integer id, String tipoDocumento, String nombreDocumento, String URLDocumento, Integer formularioSolicitudID) {
        DocumentoElectronicoEntity documentoElectronico = documentoElectronicoDAO.findById(id).orElseThrow(() -> new RuntimeException("No se encontró ningún documento electrónico con el ID proporcionado"));
        if (tipoDocumento == null || tipoDocumento.isEmpty()) {
            throw new RuntimeException("El tipo de documento debe estar completo");
        } else if (nombreDocumento == null || nombreDocumento.isEmpty()) {
            throw new RuntimeException("El nombre del documento debe estar completo");
        } else if (URLDocumento == null || URLDocumento.isEmpty()) {
            throw new RuntimeException("El URL del documento debe estar completo");
        } else if (formularioSolicitudID == null) {
            throw new RuntimeException("El ID del formulario de solicitud debe estar completo");
        }

        FormularioSolicitudEntity formularioSolicitud = formularioSolicitudDAO.findById(formularioSolicitudID).orElseThrow(() -> new RuntimeException("No se encontró ningún formulario de solicitud con el ID proporcionado"));

        documentoElectronico.setTipoDocumento(tipoDocumento);
        documentoElectronico.setNombreDocumento(nombreDocumento);
        documentoElectronico.setURLDocumento(URLDocumento);
        documentoElectronico.setFormularioSolicitudId(formularioSolicitud);

        return documentoElectronicoDAO.save(documentoElectronico);
    }

    public void deleteDocumentoElectronico(Integer id) {
        DocumentoElectronicoEntity documentoElectronico = documentoElectronicoDAO.findById(id).orElseThrow(() -> new RuntimeException("No se encontró ningún documento electrónico con el ID proporcionado"));
        documentoElectronicoDAO.delete(documentoElectronico);
    }


}