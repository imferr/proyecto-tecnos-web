package bo.ucb.edu.internship.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bo.ucb.edu.internship.dao.UseiDAO;
import bo.ucb.edu.internship.entity.UseiEntity;
import bo.ucb.edu.internship.dao.UsuarioDAO;
import bo.ucb.edu.internship.entity.UsuarioEntity;
import bo.ucb.edu.internship.dao.TipoUsuarioDAO;
import bo.ucb.edu.internship.entity.TipoUsuarioEntity; 

@Service
public class UseiBL {
    
    private final UseiDAO useiDAO;
    private final UsuarioDAO usuarioDAO;
    private final TipoUsuarioDAO tipoUsuarioDAO;

    @Autowired
    public UseiBL(UseiDAO useiDAO, UsuarioDAO usuarioDAO, TipoUsuarioDAO tipoUsuarioDAO) {
        this.useiDAO = useiDAO;
        this.usuarioDAO = usuarioDAO;
        this.tipoUsuarioDAO = tipoUsuarioDAO;
    }

    //metodo para crear un usei:
    public UseiEntity createUsei(Integer userId, Integer typeuserId) {
        if (userId == null) {
            throw new RuntimeException("El usuario debe estar completo");
        } else if (typeuserId == null) {
            throw new RuntimeException("El tipo de usuario debe estar completo");
        }
        UseiEntity usei = new UseiEntity();
        UsuarioEntity usuario = usuarioDAO.findById(userId).orElseThrow(() -> new RuntimeException("No se encontró ningún usuario con el ID proporcionado"));
        TipoUsuarioEntity tipoUsuario = tipoUsuarioDAO.findById(typeuserId).orElseThrow(() -> new RuntimeException("No se encontró ningún tipo de usuario con el ID proporcionado"));
        usei.setUserId(usuario);
        usei.setTypeUserId(tipoUsuario);
        return useiDAO.save(usei);
    }

    //metodo para obtener todos los useis:
    public List<UseiEntity> getAllUseis() {
        return useiDAO.findAll();
    }

    //metodo para obtener un usei por ID:
    public UseiEntity findUseiById(Integer id) {
        return useiDAO.findById(id).orElseThrow(() -> new RuntimeException("No se encontró ningún usei con el ID proporcionado"));
    }

    //metodo para actualizar un usei por ID:
    public UseiEntity updateUseiById(Integer id, Integer userId, Integer typeuserId) {
        if (userId == null) {
            throw new RuntimeException("El usuario debe estar completo");
        } else if (typeuserId == null) {
            throw new RuntimeException("El tipo de usuario debe estar completo");
        }
        UseiEntity usei = useiDAO.findById(id).orElseThrow(() -> new RuntimeException("No se encontró ningún usei con el ID proporcionado"));
        UsuarioEntity usuario = usuarioDAO.findById(userId).orElseThrow(() -> new RuntimeException("No se encontró ningún usuario con el ID proporcionado"));
        TipoUsuarioEntity tipoUsuario = tipoUsuarioDAO.findById(typeuserId).orElseThrow(() -> new RuntimeException("No se encontró ningún tipo de usuario con el ID proporcionado"));
        usei.setUserId(usuario);
        usei.setTypeUserId(tipoUsuario);
        return useiDAO.save(usei);
    }

}
