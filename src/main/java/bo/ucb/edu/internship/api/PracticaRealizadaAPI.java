package bo.ucb.edu.internship.api;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
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

import bo.ucb.edu.internship.bl.PracticaRealizadaBL;

@RestController
@RequestMapping(value = "api/v1/practica")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PracticaRealizadaAPI {
    
    private final PracticaRealizadaBL practicaRealizadaBL;
    private static final Logger LOGGER = Logger.getLogger(PracticaRealizadaAPI.class.getName());
    
    @Autowired
    public PracticaRealizadaAPI(PracticaRealizadaBL practicaRealizadaBL) {
        this.practicaRealizadaBL = practicaRealizadaBL;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createPracticaRealizada(@RequestBody Map<String, Object> request) {
        
        //coreccion de la fecha en formato yyyy-MM-dd:
        String datePracticaRealizadaBeginString = (String) request.get("datePracticaRealizadaBegin");
        Date datePracticaRealizadaBegin = Date.valueOf(datePracticaRealizadaBeginString);
        String datePracticaRealizadaEndString = (String) request.get("datePracticaRealizadaEnd");
        Date datePracticaRealizadaEnd = Date.valueOf(datePracticaRealizadaEndString);
        Boolean statePracticaRealizada = (Boolean) request.get("statePracticaRealizada");

        LOGGER.log(Level.INFO, "Inicio del metodo registrando práctica realizada");
        try {
            practicaRealizadaBL.createPracticaRealizada(datePracticaRealizadaBegin, datePracticaRealizadaEnd, statePracticaRealizada);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La práctica realizada se ha registrado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al registrar práctica realizada", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La práctica realizada no se ha registrado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo registrando práctica realizada");
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllPracticasRealizadas() {
        LOGGER.log(Level.INFO, "Inicio del metodo obteniendo prácticas realizadas");
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("practicasRealizadas", practicaRealizadaBL.getAllPracticasRealizadas());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener prácticas realizadas", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "No se han podido obtener las prácticas realizadas");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo obteniendo prácticas realizadas");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getPracticaRealizadaById(@PathVariable Integer id) {
        LOGGER.log(Level.INFO, "Inicio del metodo obteniendo práctica realizada por ID");
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("practicaRealizada", practicaRealizadaBL.getPracticaRealizadaById(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener práctica realizada por ID", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "No se ha podido obtener la práctica realizada por ID");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo obteniendo práctica realizada por ID");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updatePracticaRealizadaById(@PathVariable Integer id, @RequestBody Map<String, Object> request) {
        
        //coreccion de la fecha en formato yyyy-MM-dd:
        String datePracticaRealizadaBeginString = (String) request.get("datePracticaRealizadaBegin");
        Date datePracticaRealizadaBegin = Date.valueOf(datePracticaRealizadaBeginString);
        String datePracticaRealizadaEndString = (String) request.get("datePracticaRealizadaEnd");
        Date datePracticaRealizadaEnd = Date.valueOf(datePracticaRealizadaEndString);
        Boolean statePracticaRealizada = (Boolean) request.get("statePracticaRealizada");

        LOGGER.log(Level.INFO, "Inicio del metodo actualizando práctica realizada por ID");
        try {
            practicaRealizadaBL.updatePracticaRealizadaById(id, datePracticaRealizadaBegin, datePracticaRealizadaEnd, statePracticaRealizada);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La práctica realizada se ha actualizado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al actualizar práctica realizada por ID", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La práctica realizada no se ha actualizado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo actualizando práctica realizada por ID");
        }
    }
}
