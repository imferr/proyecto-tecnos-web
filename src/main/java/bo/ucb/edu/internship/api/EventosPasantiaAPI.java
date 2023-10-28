package bo.ucb.edu.internship.api;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

import bo.ucb.edu.internship.bl.EventosPasantiaBL;

@RestController
@RequestMapping(value = "api/v1/evento")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventosPasantiaAPI {

    private final EventosPasantiaBL eventosPasantiaBL;
    private static final Logger LOGGER = Logger.getLogger(EventosPasantiaAPI.class.getName());
    
    @Autowired
    public EventosPasantiaAPI(EventosPasantiaBL eventosPasantiaBL) {
        this.eventosPasantiaBL = eventosPasantiaBL;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createEventosPasantia(@RequestBody Map<String, Object> request) {
        
        String tipoEvento = (String) request.get("tipoEvento");
        //corrigiendo el timestamp para que se guarde en la base de datos, formato: yyyy-mm-dd hh:mm:ss:
        String dateEventoString = (String) request.get("dateEvento");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(dateEventoString, formatter);
        Timestamp dateEvento = Timestamp.valueOf(localDateTime);
    
        String descriptionEvento = (String) request.get("descriptionEvento");
        Integer practicaRealizadaId = (Integer) request.get("practicaRealizadaId");
        Integer convocatoriaPracticaId = (Integer) request.get("convocatoriaPracticaId");

        LOGGER.log(Level.INFO, "Inicio del metodo registrando evento de pasantia");
        try {
            eventosPasantiaBL.createEventosPasantia(tipoEvento, dateEvento, descriptionEvento, practicaRealizadaId, convocatoriaPracticaId);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El evento de pasantia se ha registrado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al registrar evento de pasantia", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El evento de pasantia no se ha registrado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo registrando evento de pasantia");
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllEventosPasantia() {
        LOGGER.log(Level.INFO, "Inicio del metodo obteniendo todos los eventos de pasantia");
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("eventosPasantia", eventosPasantiaBL.getAllEventosPasantia());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener todos los eventos de pasantia", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "No se pudo obtener todos los eventos de pasantia");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo obteniendo todos los eventos de pasantia");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getEventosPasantiaById(Integer id) {
        LOGGER.log(Level.INFO, "Inicio del metodo obteniendo evento de pasantia por su id");
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("eventosPasantia", eventosPasantiaBL.getEventosPasantiaById(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener evento de pasantia por su id", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "No se pudo obtener el evento de pasantia por su id");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo obteniendo evento de pasantia por su id");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateEventosPasantia(@RequestBody Map<String, Object> request, @PathVariable Integer id) {
        
        String tipoEvento = (String) request.get("tipoEvento");
        //corrigiendo el timestamp para que se guarde en la base de datos, formato: yyyy-mm-dd hh:mm:ss:
        String dateEventoString = (String) request.get("dateEvento");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(dateEventoString, formatter);
        Timestamp dateEvento = Timestamp.valueOf(localDateTime);

        String descriptionEvento = (String) request.get("descriptionEvento");
        Integer practicaRealizadaId = (Integer) request.get("practicaRealizadaId");
        Integer convocatoriaPracticaId = (Integer) request.get("convocatoriaPracticaId");

        LOGGER.log(Level.INFO, "Inicio del metodo actualizando evento de pasantia");
        try {
            eventosPasantiaBL.updateEventosPasantia(id, tipoEvento, dateEvento, descriptionEvento, practicaRealizadaId, convocatoriaPracticaId);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El evento de pasantia se ha actualizado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al actualizar evento de pasantia", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El evento de pasantia no se ha actualizado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo actualizando evento de pasantia");
        }
    }
}

