package bo.ucb.edu.internship.api;

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

import bo.ucb.edu.internship.bl.EvaluacionPasantiaBL;

@RestController
@RequestMapping(value = "api/v1/evaluacion")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EvaluacionPasantiaAPI {

    private final EvaluacionPasantiaBL evaluacionPasantiaBL;
    private static final Logger LOGGER = Logger.getLogger(EvaluacionPasantiaAPI.class.getName());
    
    @Autowired
    public EvaluacionPasantiaAPI(EvaluacionPasantiaBL evaluacionPasantiaBL) {
        this.evaluacionPasantiaBL = evaluacionPasantiaBL;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createEvaluacionPasantia(@RequestBody Map<String, Object> request) {
        
        Double evaluacionDesempenio = Double.valueOf(request.get("evaluacionDesempenio").toString());
        String comentarioEvaluacion = (String) request.get("comentarioEvaluacion");
        Integer practicaRealizadaId = (Integer) request.get("practicaRealizadaId");
        Integer evaluadorId = (Integer) request.get("evaluadorId");

        LOGGER.log(Level.INFO, "Inicio del metodo registrando evaluación de pasantía");
        try {
            evaluacionPasantiaBL.createEvaluacionPasantia(evaluacionDesempenio, comentarioEvaluacion, practicaRealizadaId, evaluadorId);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La evaluación de pasantía se ha registrado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al registrar evaluación de pasantía", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La evaluación de pasantía no se ha registrado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo registrando evaluación de pasantía");
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllEvaluacionesPasantia() {
        LOGGER.log(Level.INFO, "Inicio del metodo obteniendo evaluaciones de pasantía");
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("evaluacionesPasantia", evaluacionPasantiaBL.getAllEvaluacionesPasantia());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener evaluaciones de pasantía", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "No se han podido obtener las evaluaciones de pasantía");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo obteniendo evaluaciones de pasantía");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getEvaluacionPasantiaById(@PathVariable() Integer id) {
        LOGGER.log(Level.INFO, "Inicio del metodo obteniendo evaluación de pasantía por ID");
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("evaluacionPasantia", evaluacionPasantiaBL.getEvaluacionPasantiaById(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener evaluación de pasantía por ID", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "No se ha podido obtener la evaluación de pasantía");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo obteniendo evaluación de pasantía por ID");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateEvaluacionPasantiaById(@RequestBody Map<String, Object> request, @PathVariable Integer id) {
        
        Double evaluacionDesempenio = Double.valueOf(request.get("evaluacionDesempenio").toString());
        String comentarioEvaluacion = (String) request.get("comentarioEvaluacion");
        Integer practicaRealizadaId = (Integer) request.get("practicaRealizadaId");
        Integer evaluadorId = (Integer) request.get("evaluadorId");

        LOGGER.log(Level.INFO, "Inicio del metodo actualizando evaluación de pasantía por ID");
        try {
            evaluacionPasantiaBL.updateEvaluacionPasantiaById(id, evaluacionDesempenio, comentarioEvaluacion, practicaRealizadaId, evaluadorId);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La evaluación de pasantía se ha actualizado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al actualizar evaluación de pasantía por ID", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La evaluación de pasantía no se ha actualizado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo actualizando evaluación de pasantía por ID");
        }
    }
}
