package bo.ucb.edu.internship.api;

import bo.ucb.edu.internship.bl.ConvocatoriaPracticaBL;
import bo.ucb.edu.internship.entity.ConvocatoriaPracticaEntity;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/convocatoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ConvocatoriaPracticaAPI {

    private final ConvocatoriaPracticaBL convocatoriaPracticaBL;
    private static final Logger LOGGER = Logger.getLogger(ConvocatoriaPracticaAPI.class.getName());

    public ConvocatoriaPracticaAPI(ConvocatoriaPracticaBL convocatoriaPracticaBL) {
        this.convocatoriaPracticaBL = convocatoriaPracticaBL;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createConvocatoriaPractica(@RequestBody Map<String, Object> request) {
        
        String titleConvocatoria = (String) request.get("titleConvocatoria");
        String descriptionConvocatoria = (String) request.get("descriptionConvocatoria");

        //coreccion de la fecha en formato yyyy-MM-dd:
        String dateConvocatoriaString = (String) request.get("dateConvocatoria");
        Date dateConvocatoria = Date.valueOf(dateConvocatoriaString);
        Boolean stateConvocatoria = (Boolean) request.get("stateConvocatoria");
        Integer companyId = (Integer) request.get("companyId");
        Integer useiId = (Integer) request.get("useiId");

        LOGGER.log(Level.INFO, "Inicio del metodo registrando convocatoria");
        try {
            convocatoriaPracticaBL.createConvocatoriaPractica(titleConvocatoria, descriptionConvocatoria, dateConvocatoria, stateConvocatoria, companyId, useiId);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La convocatoria se ha registrado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al registrar convocatoria", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La convocatoria no se ha registrado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo registrando convocatoria");
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllConvocatoriaPractica() {
        LOGGER.log(Level.INFO, "Inicio del metodo obteniendo convocatorias");
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("convocatorias", convocatoriaPracticaBL.getAllConvocatoriaPractica());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener convocatorias", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "No se pudo obtener las convocatorias");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo obteniendo convocatorias");
        }
    }

    @GetMapping("/id")
    public ResponseEntity<Map<String, Object>> findConvocatoriaPracticaById(@PathVariable Integer id) {
        LOGGER.log(Level.INFO, "Inicio del metodo obteniendo convocatoria por ID");
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("convocatoria", convocatoriaPracticaBL.findConvocatoriaPracticaById(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener convocatoria por ID", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "No se pudo obtener la convocatoria");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo obteniendo convocatoria por ID");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateConvocatoriaPracticaById (@RequestBody Map<String, Object> request, @PathVariable Integer id) {
        
        String titleConvocatoria = (String) request.get("titleConvocatoria");
        String descriptionConvocatoria = (String) request.get("descriptionConvocatoria");
        Date dateConvocatoria = (Date) request.get("dateConvocatoria");
        Boolean stateConvocatoria = (Boolean) request.get("stateConvocatoria");
        Integer companyId = (Integer) request.get("companyId");
        Integer useiId = (Integer) request.get("useiId");

        LOGGER.log(Level.INFO, "Inicio del metodo actualizando convocatoria");
        try {
            convocatoriaPracticaBL.updateConvocatoriaPracticaById(id, titleConvocatoria, descriptionConvocatoria, dateConvocatoria, stateConvocatoria, companyId, useiId);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La convocatoria se ha actualizado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al actualizar convocatoria", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La convocatoria no se ha actualizado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo actualizando convocatoria");
        }
    }
}