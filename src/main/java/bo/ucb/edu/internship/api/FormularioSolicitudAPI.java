package bo.ucb.edu.internship.api;

import bo.ucb.edu.internship.entity.FormularioSolicitudEntity;
import bo.ucb.edu.internship.bl.FormularioSolicitudBL;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/formulario-solicitud")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FormularioSolicitudAPI {

    private final FormularioSolicitudBL formularioSolicitudBL;
    private static final Logger LOGGER = Logger.getLogger(FormularioSolicitudAPI.class.getName());


    public FormularioSolicitudAPI(FormularioSolicitudBL formularioSolicitudBL) {
        this.formularioSolicitudBL = formularioSolicitudBL;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createFormularioSolicitud(@RequestBody  Map<String, Object> request) {

        String requestDateString = (String) request.get("requestDate");
        Date requestDate = Date.valueOf(requestDateString);
        Boolean requestStatus = (Boolean) request.get("requestStatus");
        String attachedDocument = (String) request.get("attachedDocument");
        Integer studentId = (Integer) request.get("studentId");

        LOGGER.log(Level.INFO, "Inicio del método registrando formulario de solicitud");
        try {
            formularioSolicitudBL.createFormularioSolicitud(requestDate, requestStatus, attachedDocument, studentId);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El formulario de solicitud se ha registrado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al registrar formulario de solicitud", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El formulario de solicitud no se ha registrado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método registrando formulario de solicitud");
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllFormulariosSolicitud() {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo formularios de solicitud");
        try {
            List<FormularioSolicitudEntity> formulariosSolicitud = formularioSolicitudBL.getAllFormulariosSolicitud();
            Map<String, Object> response = new HashMap<>();
            response.put("formulariosSolicitud", formulariosSolicitud);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener formularios de solicitud", e);
            Map<String, Object> response = new HashMap<>();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo formularios de solicitud");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findFormularioSolicitudById(@PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo formulario de solicitud por ID");
        try {
            FormularioSolicitudEntity formularioSolicitud = formularioSolicitudBL.findFormularioSolicitudById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("formularioSolicitud", formularioSolicitud);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener formulario de solicitud por ID", e);
            Map<String, Object> response = new HashMap<>();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo formulario de solicitud por ID");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateFormularioSolicitud(@PathVariable("id") Integer id, @RequestBody Map<String, Object> request) {
        String requestDateString = (String) request.get("requestDate");
        Date requestDate = Date.valueOf(requestDateString);
        Boolean requestStatus = (Boolean) request.get("requestStatus");
        String attachedDocument = (String) request.get("attachedDocument");
        Integer studentId = (Integer) request.get("studentId");

        LOGGER.log(Level.INFO, "Inicio del método actualizando formulario de solicitud");
        try {
            FormularioSolicitudEntity formularioSolicitud = formularioSolicitudBL.updateFormularioSolicitud(id, requestDate, requestStatus, attachedDocument, studentId);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El formulario de solicitud se ha actualizado exitosamente");
            response.put("formularioSolicitud", formularioSolicitud);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al actualizar formulario de solicitud", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El formulario de solicitud no se ha actualizado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método actualizando formulario de solicitud");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteFormularioSolicitud(@PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO, "Inicio del método eliminando formulario de solicitud");
        try {
            formularioSolicitudBL.deleteFormularioSolicitud(id);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El formulario de solicitud se ha eliminado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al eliminar formulario de solicitud", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El formulario de solicitud no se ha eliminado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método eliminando formulario de solicitud");
        }
    }
}

