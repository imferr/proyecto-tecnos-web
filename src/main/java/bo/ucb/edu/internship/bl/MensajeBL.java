package bo.ucb.edu.internship.bl;

import bo.ucb.edu.internship.dao.MensajeDAO;
import bo.ucb.edu.internship.dao.UsuarioDAO;
import bo.ucb.edu.internship.entity.MensajeEntity;
import bo.ucb.edu.internship.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;



@Service 
public class MensajeBL{
    private final MensajeDAO mensajeDAO;
    private final UsuarioDAO usuarioDAO;

    @Autowired
    public MensajeBL(MensajeDAO mensajeDAO, UsuarioDAO usuarioDAO) {
        this.mensajeDAO = mensajeDAO;
        this.usuarioDAO = usuarioDAO;
    }
    //Metodos de la clase MensajeBL
    //Metodo para crear un mensaje
    public MensajeEntity createMensaje(String messageContent, Date sendDate, Integer userIdSender, Integer userIdReceiver) {
        if (messageContent == null ) {
            throw new RuntimeException("El contenido del mensaje es obligatorio");
        } else if (sendDate == null) {
            throw new RuntimeException("La fecha de envio es obligatoria");
        } else if (userIdSender == null || userIdReceiver == null) {
            throw new RuntimeException("El ID del usuario emisor y el ID del usuario receptor son obligatorios");
        }
        MensajeEntity mensaje = new MensajeEntity();
        UsuarioEntity usuarioSender = usuarioDAO.findById(userIdSender).orElseThrow(() -> new RuntimeException("No se encontró ningún usuario con el ID proporcionado"));
        UsuarioEntity usuarioReceiver = usuarioDAO.findById(userIdReceiver).orElseThrow(() -> new RuntimeException("No se encontró ningún usuario con el ID proporcionado"));
        mensaje.setMessageContent(messageContent);
        mensaje.setSendDate(sendDate);
        mensaje.setUserIdSender(usuarioSender);
        mensaje.setUserIdReceiver(usuarioReceiver);
        return mensajeDAO.save(mensaje);   
    }

    public List<MensajeEntity> getAllMessages() {
        return mensajeDAO.findAll();
    }

    public MensajeEntity findMensajeById(Integer id) {
        return mensajeDAO.findById(id).orElseThrow(() -> new RuntimeException("No se encontró ningún estudiante con el ID proporcionado"));
    }

}