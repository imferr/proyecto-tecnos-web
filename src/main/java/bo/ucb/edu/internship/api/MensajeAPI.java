package bo.ucb.edu.internship.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import bo.ucb.edu.internship.bl.MensajeBL;
import bo.ucb.edu.internship.entity.MensajeEntity;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/v1/mensaje")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MensajeAPI {

    private final MensajeBL mensajeBL;
    private static final Logger LOGGER = Logger.getLogger(MensajeAPI.class.getName());

    @Autowired
    public MensajeAPI(MensajeBL mensajeBL) {
        this.mensajeBL = mensajeBL;
    }

    @PostMapping("/new")
    public ResponseEntity<Map<String, Object>> createMensaje(@RequestBody Map<String, Object> request) {

        String messageContent = (String) request.get("messageContent");
        Date sendDate = (Date) request.get("sendDate");
        Integer userIdSender = (Integer) request.get("userIdSender");
        Integer userIdReceiver = (Integer) request.get("userIdReceiver");
        
        LOGGER.log(Level.INFO, "Inicio del metodo registrando mensaje");
        try {
            mensajeBL.createMensaje(messageContent, sendDate, userIdSender, userIdReceiver);
            Map<String, Object> response = new HashMap<>();
            LOGGER.log(Level.INFO, "Registrando mensaje");
            response.put("message", "El mensaje se ha registrado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al registrar mensaje", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El mensaje no se ha registrado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del metodo registrando mensaje");
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllMessages(){
        try {
            LOGGER.log(Level.INFO, "Iniciando proceso para obtener mensajes");
            List<MensajeEntity> messages = mensajeBL.getAllMessages();
            Map<String, Object> response = new HashMap<>();
            response.put("messages", messages);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener mensajes", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "No se pudo obtener los mensajes");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally{
            LOGGER.log(Level.INFO, "Finalizando proceso para obtener mensajes");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String,Object>> findMessageById(@PathVariable("id") Integer id){
        try {
            LOGGER.log(Level.INFO, "Iniciando proceso para obtener mensaje por id");
            MensajeEntity message = mensajeBL.findMensajeById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener mensaje por id", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "No se pudo obtener el mensaje");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally{
            LOGGER.log(Level.INFO, "Finalizando proceso para obtener mensaje por id");
        }
    }
    
}
