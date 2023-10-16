package bo.ucb.edu.internship.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bo.ucb.edu.internship.dao.TipoUsuarioDAO;
import bo.ucb.edu.internship.entity.TipoUsuarioEntity;
import java.util.List;

@Service
public class TipoUsuarioBL {

    private final TipoUsuarioDAO tipoUsuarioDAO;

    @Autowired
    public TipoUsuarioBL(TipoUsuarioDAO tipoUsuarioDAO) {
        this.tipoUsuarioDAO = tipoUsuarioDAO;
    }

    public TipoUsuarioEntity createTipoUsuario(TipoUsuarioEntity tipoUsuario) {
        // Realiza validaciones según tus requisitos
        if (tipoUsuario.getTypeUser() == null || tipoUsuario.getTypeUser().isEmpty()) {
            throw new IllegalArgumentException("El campo 'typeUser' no puede estar vacío.");
        }

        // Guardar el nuevo TipoUsuario en la base de datos
        return tipoUsuarioDAO.save(tipoUsuario);
    }

    public List<TipoUsuarioEntity> getAllTipoUsuarios() {
        return tipoUsuarioDAO.findAll();
    }

    public TipoUsuarioEntity findTipoUsuarioById(Integer id) {
        return tipoUsuarioDAO.findById(id).orElseThrow(() -> new RuntimeException("No se encontró ningún tipo de usuario con el ID proporcionado"));
    }
}

