package bo.ucb.edu.internship.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.ucb.edu.internship.dao.EvaluadorDAO;
import bo.ucb.edu.internship.dao.UsuarioDAO;
import bo.ucb.edu.internship.entity.UsuarioEntity;
import bo.ucb.edu.internship.entity.TipoUsuarioEntity;
import bo.ucb.edu.internship.dao.TipoUsuarioDAO;
import bo.ucb.edu.internship.entity.EvaluadorEntity;

@Service
public class EvaluadorBL {

    private final EvaluadorDAO evaluadorDAO;
    private final UsuarioDAO usuarioDAO;
    private final TipoUsuarioDAO tipoUsuarioDAO;

    @Autowired
    public EvaluadorBL(EvaluadorDAO evaluadorDAO, UsuarioDAO usuarioDAO, TipoUsuarioDAO tipoUsuarioDAO) {
        this.evaluadorDAO = evaluadorDAO;
        this.usuarioDAO = usuarioDAO;
        this.tipoUsuarioDAO = tipoUsuarioDAO;
    }

    // metodo para crear un evaluador:
    public EvaluadorEntity createEvaluador(Integer userId, Integer typeUserId) {
        if (userId == null || typeUserId == null) {
            throw new RuntimeException("El ID del usuario y el ID del tipo de usuario son obligatorios");
        }
        
        EvaluadorEntity evaluador = new EvaluadorEntity();
        //obtener objeto usuario con user id con el dao:
        UsuarioEntity usuario = usuarioDAO.findById(userId).orElseThrow(() -> new RuntimeException("No se encontró ningun usuario con el ID proporcionado"));
        //obtener objeto tipo usuario con type user id con el dao:
        TipoUsuarioEntity tipoUsuario = tipoUsuarioDAO.findById(typeUserId).orElseThrow(() -> new RuntimeException("No se encontró ningun tipo de usuario con el ID proporcionado"));
        evaluador.setUserId(usuario);
        evaluador.setTypeUserId(tipoUsuario);
        return evaluadorDAO.save(evaluador);
    }

    //metodo para obtener un todos los evaluadores:
    public List<EvaluadorEntity> getAllEvaluadores() {
        return evaluadorDAO.findAll();
    }

    //metodo para obtener un evaluador por su id:
    public EvaluadorEntity findEvaluadorById(Integer id) {
        return evaluadorDAO.findById(id).orElseThrow(() -> new RuntimeException("No se encontró ningun evaluador con el ID proporcionado"));
    }
}
