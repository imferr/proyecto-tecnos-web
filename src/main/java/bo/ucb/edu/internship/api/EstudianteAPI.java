package bo.ucb.edu.internship.api;

import bo.ucb.edu.internship.dto.EstudianteDTO;
import bo.ucb.edu.internship.entity.EstudianteEntity;
import bo.ucb.edu.internship.entity.TipoUsuarioEntity;
import bo.ucb.edu.internship.entity.UsuarioEntity;
import bo.ucb.edu.internship.bl.EstudianteBL;
import bo.ucb.edu.internship.bl.TipoUsuarioBL;
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
@RequestMapping(value = "/api/v1/estudiantes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EstudianteAPI {

    private final EstudianteBL estudianteBL;
    private static final Logger LOGGER = Logger.getLogger(EstudianteAPI.class.getName());

    @Autowired
    public EstudianteAPI(EstudianteBL estudianteBL) {
        this.estudianteBL = estudianteBL;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createEstudiante(@RequestBody Map<String, Object> request) {

        String semester = (String) request.get("semester");
        String carrier = (String) request.get("carrier");
        Integer userId = (Integer) request.get("userId");
        Integer typeUserId = (Integer) request.get("typeUserId");
        
        LOGGER.log(Level.INFO, "Inicio del metodo registrando estudiante");
        try {
            estudianteBL.createEstudiante(semester, carrier, userId, typeUserId);
            Map<String, Object> response = new HashMap<>();
            LOGGER.log(Level.INFO, "Registrando estudiante");
            response.put("message", "El estudiante se ha registrado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al registrar estudiante", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El estudiante no se ha registrado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo registrando estudiante");
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllEstudiantes() {
        try {
            LOGGER.log(Level.INFO, "Iniciando el metodo obteniendo estudiantes");
            List<EstudianteEntity> estudiantes = estudianteBL.getAllEstudiantes();
            Map<String, Object> response = new HashMap<>();
            LOGGER.log(Level.INFO, "Obteniendo estudiantes");
            response.put("estudiantes", estudiantes);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "No se pudo encontrar a los estudiantes");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo obteniendo estudiantes");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findEstudianteById(@PathVariable Integer id) {
        try {
            LOGGER.log(Level.INFO, "Iniciando el metodo obteniendo estudiante por id");
            EstudianteEntity estudiante = estudianteBL.findEstudianteById(id);
            Map<String, Object> response = new HashMap<>();
            LOGGER.log(Level.INFO, "Obteniendo estudiante por id");
            response.put("estudiante", estudiante);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "No se pudo encontrar al estudiante");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo obteniendo estudiante por id");
        }
    }
}
