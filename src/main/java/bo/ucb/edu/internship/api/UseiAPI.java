package bo.ucb.edu.internship.api;

import java.util.HashMap;
import java.util.List;
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

import bo.ucb.edu.internship.bl.UseiBL;
import bo.ucb.edu.internship.entity.UseiEntity;

@RestController
@RequestMapping(value = "/api/v1/usei")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UseiAPI {
    
    private final UseiBL useiBL;
    private static final Logger LOGGER = Logger.getLogger(UseiAPI.class.getName());

    @Autowired
    public UseiAPI(UseiBL useiBL) {
        this.useiBL = useiBL;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createUsei(@RequestBody Map<String, Object> request) {
        Integer userId = (Integer) request.get("userId");
        Integer typeUserId = (Integer) request.get("typeUserId");
        
        LOGGER.log(Level.INFO, "Inicio del metodo registrando usei");
        try {
            useiBL.createUsei(userId, typeUserId);
            Map<String, Object> response = new HashMap<>();
            LOGGER.log(Level.INFO, "Registrando usei");
            response.put("message", "El usei se ha registrado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al registrar usei", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El usei no se ha registrado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo registrando usei");
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllUseis() {
        try {
            LOGGER.log(Level.INFO, "Iniciando el metodo obteniendo useis");
            List<UseiEntity> usei = useiBL.getAllUseis();
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Se han encontrado " + usei.size() + " useis");
            response.put("useis", usei);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener useis", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener useis");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo obteniendo useis");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findUseiById(@PathVariable Integer id) {
        try {
            LOGGER.log(Level.INFO, "Iniciando el metodo obteniendo usei por id");
            UseiEntity usei = useiBL.findUseiById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Se ha encontrado al usei con el id " + id);
            response.put("usei", usei);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener usei por id", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener usei por id");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo obteniendo usei por id");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateUsei(@PathVariable Integer id, @RequestBody Map<String, Object> request) {
        Integer userId = (Integer) request.get("userId");
        Integer typeUserId = (Integer) request.get("typeUserId");
        LOGGER.log(Level.INFO, "Inicio del metodo actualizando usei");
        try {
            useiBL.updateUseiById(id, userId, typeUserId);
            Map<String, Object> response = new HashMap<>();
            LOGGER.log(Level.INFO, "Actualizando usei");
            response.put("message", "El usei se ha actualizado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al actualizar usei", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El usei no se ha actualizado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo actualizando usei");
        }
    }
    
}
