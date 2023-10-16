package bo.ucb.edu.internship.api;

import bo.ucb.edu.internship.dto.AdministradorDTO;
import bo.ucb.edu.internship.entity.AdministradorEntity;
import bo.ucb.edu.internship.bl.AdministradorBL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/administradores")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdministradorAPI {
    
    private final AdministradorBL administradorBL;
    private static final Logger LOGGER = Logger.getLogger(AdministradorAPI.class.getName());

    @Autowired
    public AdministradorAPI(AdministradorBL administradorBL) {
        this.administradorBL = administradorBL;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createAdministrador(@RequestBody AdministradorEntity administradorEntity) {
        LOGGER.log(Level.INFO, "Inicio del metodo registrando administrador");
        try {
            administradorBL.createAdministrador(administradorEntity);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El administrador se ha registrado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al registrar administrador", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El administrador no se ha registrado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo registrando administrador");
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllAdministradores() {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo todos los administradores");
        try {
            Map<String, Object> response = new HashMap<>();
            LOGGER.log(Level.INFO, "Obteniendo todos los administradores");
            response.put("administradores", administradorBL.getAllAdministradores());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener todos los administradores", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "No se pudo obtener los administradores");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo todos los administradores");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findAdministradorById(@PathVariable Integer id) {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo administrador por id");
        try {
            Map<String, Object> response = new HashMap<>();
            LOGGER.log(Level.INFO, "Obteniendo administrador por id");
            response.put("administrador", administradorBL.findAdministradorById(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener administrador por id", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "No se pudo obtener el administrador");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo administrador por id");
        }
    }
}
