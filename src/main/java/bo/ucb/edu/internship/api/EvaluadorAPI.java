package bo.ucb.edu.internship.api;

import bo.ucb.edu.internship.entity.EvaluadorEntity;
import bo.ucb.edu.internship.bl.EvaluadorBL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/v1/evaluador")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EvaluadorAPI {

    private final EvaluadorBL evaluadorBL;
    private static final Logger LOGGER = Logger.getLogger(EmpresaAPI.class.getName());

    @Autowired
    public EvaluadorAPI(EvaluadorBL evaluadorBL) {
        this.evaluadorBL = evaluadorBL;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createEvaluador(@RequestBody Map<String, Object> request) {
        Integer userId = (Integer) request.get("userId");
        Integer typeUserId = (Integer) request.get("typeUserId");
    
        LOGGER.log(Level.INFO, "Iniciando el método registrando evaluador");
        try {
            evaluadorBL.createEvaluador(userId, typeUserId);
    
            Map<String, Object> response = new HashMap<>();
            LOGGER.log(Level.INFO, "Registrando evaluador");
            response.put("message", "El evaluador se ha registrado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al registrar evaluador", e);
            Map<String, Object> response = new HashMap<>();
            LOGGER.log(Level.INFO, "El evaluador no se ha registrado");
            response.put("message", "El evaluador no se ha registrado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método registrando evaluador");
        }
    }    

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllEvaluadores() {
        LOGGER.log(Level.INFO, "Inicio del metodo obteniendo todos los evaluadores");
        try {
            Map<String, Object> response = new HashMap<>();
            LOGGER.log(Level.INFO, "Obteniendo todos los evaluadores");
            response.put("evaluadores", evaluadorBL.getAllEvaluadores());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener todos los evaluadores", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "No se pudo obtener los evaluadores");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo obteniendo todos los evaluadores");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findEvaluadorById(@PathVariable Integer id) {
        LOGGER.log(Level.INFO, "Inicio del metodo obteniendo evaluador por id");
        try {
            Map<String, Object> response = new HashMap<>();
            LOGGER.log(Level.INFO, "Obteniendo evaluador por id");
            response.put("evaluador", evaluadorBL.findEvaluadorById(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener evaluador por id", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "No se pudo obtener el evaluador");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo obteniendo evaluador por id");
        }
    }
}
