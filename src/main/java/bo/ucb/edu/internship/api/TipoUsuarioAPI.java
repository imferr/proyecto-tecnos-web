package bo.ucb.edu.internship.api;

import bo.ucb.edu.internship.entity.TipoUsuarioEntity;
import bo.ucb.edu.internship.bl.TipoUsuarioBL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/tipousuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TipoUsuarioAPI {

    private final TipoUsuarioBL tipoUsuarioBL;
    private static final Logger LOGGER = Logger.getLogger(TipoUsuarioAPI.class.getName());

    @Autowired
    public TipoUsuarioAPI(TipoUsuarioBL tipoUsuarioBL) {
        this.tipoUsuarioBL = tipoUsuarioBL;
    }

    @PostMapping("/register")
    public ResponseEntity<TipoUsuarioEntity> createTipoUsuario(@RequestBody TipoUsuarioEntity tipoUsuario) {
        LOGGER.log(Level.INFO, "Inicio del método creando TipoUsuario");
        try {
            TipoUsuarioEntity tipoUsuarioResult = tipoUsuarioBL.createTipoUsuario(tipoUsuario);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El TipoUsuario se ha registrado");
            return new ResponseEntity<>(tipoUsuarioResult, HttpStatus.CREATED);
        }  catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al crear TipoUsuario", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El TipoUsuario no se ha registrado");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método creando TipoUsuario");
        }
    }

    @GetMapping()
    public ResponseEntity<List<TipoUsuarioEntity>> getAllTipoUsuarios() {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo todos los tipos de usuario");
        try {
            List<TipoUsuarioEntity> tipoUsuarios = tipoUsuarioBL.getAllTipoUsuarios();
            return new ResponseEntity<>(tipoUsuarios, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener todos los tipos de usuario", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener todos los tipos de usuario");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo todos los tipos de usuario");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuarioEntity> findTipoUsuarioById(@PathVariable Integer id) {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo tipo de usuario por ID");
        try {
            TipoUsuarioEntity tipoUsuario = tipoUsuarioBL.findTipoUsuarioById(id);
            return new ResponseEntity<>(tipoUsuario, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener tipo de usuario por ID", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener tipo de usuario por ID");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo tipo de usuario por ID");
        }
    }
}
