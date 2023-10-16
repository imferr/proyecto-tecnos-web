package bo.ucb.edu.internship.api;

import bo.ucb.edu.internship.dto.UsuarioDTO;
import bo.ucb.edu.internship.entity.UsuarioEntity;
import bo.ucb.edu.internship.bl.UsuarioBL;

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
@RequestMapping(value = "/api/v1/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioAPI {

    private final UsuarioBL usuarioBL;
    private static final Logger LOGGER = Logger.getLogger(UsuarioAPI.class.getName());

    @Autowired
    public UsuarioAPI(UsuarioBL usuarioBL) {
        this.usuarioBL = usuarioBL;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createUsuario(@RequestBody UsuarioEntity usuarioEntity) {
        LOGGER.log(Level.INFO, "Inicio del método registrando usuario");
        try {
            // Llama al método de la capa de lógica empresarial para crear un usuario
            usuarioBL.createUsuario(usuarioEntity);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El usuario se ha registrado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al registrar usuario", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El usuario no se ha registrado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método registrando usuario");
        }
    }

    @GetMapping()
    public ResponseEntity<List<UsuarioEntity>> getAllUsuarios() {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo todos los usuarios");
        try {
            List<UsuarioEntity> usuarios = usuarioBL.getAllUsuarios();
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener todos los usuarios", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "No se pudo obtener los usuarios");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo todos los usuarios");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> findUsuarioById(@PathVariable Integer id) {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo usuario por ID");
        try {
            UsuarioEntity usuario = usuarioBL.findUsuarioById(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener usuario por ID", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "No se pudo obtener el usuario");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo usuario por ID");
        }
    }
}
