package bo.ucb.edu.internship.api;

import bo.ucb.edu.internship.dto.EmpresaDTO;
import bo.ucb.edu.internship.entity.EmpresaEntity;
import bo.ucb.edu.internship.bl.EmpresaBL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/v1/empresa")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class EmpresaAPI {
    
    private final EmpresaBL empresaBL;
    private static final Logger LOGGER = Logger.getLogger(EmpresaAPI.class.getName());

    @Autowired
    public EmpresaAPI(EmpresaBL empresaBL) {
        this.empresaBL = empresaBL;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createEmpresa(@RequestBody EmpresaEntity empresaEntity) {
        LOGGER.log(Level.INFO, "Inicio del metodo registrando empresa");
        try {
            empresaBL.createEmpresa(empresaEntity);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La empresa se ha registrado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al registrar empresa", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La empresa no se ha registrado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo registrando empresa");
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllEmpresas() {
        LOGGER.log(Level.INFO, "Inicio del metodo obteniendo todas las empresas");
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("empresas", empresaBL.getAllEmpresas());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener todas las empresas", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "No se pudo obtener las empresas");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo obteniendo todas las empresas");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findEmpresaById(@PathVariable Integer id) {
        LOGGER.log(Level.INFO, "Inicio del metodo obteniendo empresa por id");
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("empresa", empresaBL.findEmpresaById(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener empresa por id", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "No se pudo obtener la empresa");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo obteniendo empresa por id");
        }
    }
}
