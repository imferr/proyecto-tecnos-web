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
import java.util.List;
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
    public ResponseEntity<Map<String, Object>> createAdministrador(@RequestBody Map<String, Object> request) {
        
        String cargo = (String) request.get("cargo");
        Integer empresaId = (Integer) request.get("companyId");
        Integer usuarioId = (Integer) request.get("userId");
        Integer tipoUsuarioId = (Integer) request.get("typeuserId");

        LOGGER.log(Level.INFO, "Inicio del metodo registrando administrador");
        try {
            administradorBL.createAdministrador(cargo, empresaId, usuarioId, tipoUsuarioId);
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

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllAdministradores() {
        LOGGER.log(Level.INFO, "Inicio del metodo obteniendo administradores");
        try {
            LOGGER.log(Level.INFO, "Obteniendo administradores");
            List<AdministradorEntity> administradores = administradorBL.getAllAdministradores();
            Map<String, Object> response = new HashMap<>();
            response.put("administradores", administradores);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener administradores", e);
            Map<String, Object> response = new HashMap<>();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo obteniendo administradores");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findAdministradorById(@PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO, "Inicio del metodo obteniendo administrador por ID");
        try {
            LOGGER.log(Level.INFO, "Obteniendo administrador por ID");
            AdministradorEntity administrador = administradorBL.findAdministradorById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("administrador", administrador);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener administrador por ID", e);
            Map<String, Object> response = new HashMap<>();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo obteniendo administrador por ID");
        }
    }
}
