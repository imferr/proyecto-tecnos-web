package bo.ucb.edu.internship.api;

import bo.ucb.edu.internship.bl.DocumentoElectronicoBL;
import bo.ucb.edu.internship.entity.DocumentoElectronicoEntity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/documento-electronico")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DocumentoElectronicoAPI {

    private final DocumentoElectronicoBL documentoElectronicoBL;
    private static final Logger LOGGER = Logger.getLogger(DocumentoElectronicoAPI.class.getName());

    public DocumentoElectronicoAPI(DocumentoElectronicoBL documentoElectronicoBL) {
        this.documentoElectronicoBL = documentoElectronicoBL;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createDocumentoElectronico(@RequestBody Map<String, Object> request) {
        String tipoDocumento = (String) request.get("tipoDocumento");
        String nombreDocumento = (String) request.get("nombreDocumento");
        String URLDocumento = (String) request.get("URLDocumento");
        Integer formularioSolicitudID = (Integer) request.get("formularioSolicitudID");

        LOGGER.log(Level.INFO, "Inicio del método creando documento electrónico");
        try {
            documentoElectronicoBL.createDocumentoElectronico(tipoDocumento, nombreDocumento, URLDocumento, formularioSolicitudID);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El documento electrónico se ha creado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al crear documento electrónico", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El documento electrónico no se ha creado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método creando documento electrónico");
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllDocumentosElectronicos() {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo documentos electrónicos");
        try {
            List<DocumentoElectronicoEntity> documentosElectronicos = documentoElectronicoBL.getAllDocumentosElectronicos();
            Map<String, Object> response = new HashMap<>();
            response.put("documentosElectronicos", documentosElectronicos);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener documentos electrónicos", e);
            Map<String, Object> response = new HashMap<>();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo documentos electrónicos");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findDocumentoElectronicoById(@PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo documento electrónico por ID");
        try {
            DocumentoElectronicoEntity documentoElectronico = documentoElectronicoBL.findDocumentoElectronicoById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("documentoElectronico", documentoElectronico);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener documento electrónico por ID", e);
            Map<String, Object> response = new HashMap<>();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo documento electrónico por ID");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateDocumentoElectronico(@PathVariable("id") Integer id, @RequestBody Map<String, Object> request) {
        String tipoDocumento = (String) request.get("tipoDocumento");
        String nombreDocumento = (String) request.get("nombreDocumento");
        String URLDocumento = (String) request.get("URLDocumento");
        Integer formularioSolicitudID = (Integer) request.get("formularioSolicitudID");

        LOGGER.log(Level.INFO, "Inicio del método actualizando documento electrónico");
        try {
            DocumentoElectronicoEntity documentoElectronico = documentoElectronicoBL.updateDocumentoElectronico(id, tipoDocumento, nombreDocumento, URLDocumento, formularioSolicitudID);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El documento electrónico se ha actualizado exitosamente");
            response.put("documentoElectronico", documentoElectronico);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al actualizar documento electrónico", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El documento electrónico no se ha actualizado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método actualizando documento electrónico");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteDocumentoElectronico(@PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO, "Inicio del método eliminando documento electrónico");
        try {
            documentoElectronicoBL.deleteDocumentoElectronico(id);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El documento electrónico se ha eliminado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al eliminar documento electrónico", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El documento electrónico no se ha eliminado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método eliminando documento electrónico");
        }
    }


}

