package bo.ucb.edu.internship.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bo.ucb.edu.internship.dao.AdministradorDAO;
import bo.ucb.edu.internship.entity.AdministradorEntity;

@Service
public class AdministradorBL {

    private final AdministradorDAO administradorDAO;

    @Autowired
    public AdministradorBL(AdministradorDAO administradorDAO) {
        this.administradorDAO = administradorDAO;
    }

    // Método para crear un administrador:
    public AdministradorEntity createAdministrador(AdministradorEntity administradorEntity) {
        if (administradorEntity.getPosition() == null || administradorEntity.getPosition().length() == 0) {
            throw new RuntimeException("El cargo del administrador no puede estar vacío");
        }
        // Puedes agregar más validaciones según tus necesidades.
        AdministradorEntity administrador = new AdministradorEntity();
        administrador.setPosition(administradorEntity.getPosition());
        // Realiza otras asignaciones de campos si es necesario.
        AdministradorEntity administradorResult = administradorDAO.save(administrador);
        return administradorResult;
    }

    // Método para obtener una lista de todos los administradores registrados:
    public List<AdministradorEntity> getAllAdministradores() {
        return administradorDAO.findAll();
    }

    // Método para obtener un administrador por su ID:
    public AdministradorEntity findAdministradorById(Integer id) {
        return administradorDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún administrador con el ID proporcionado"));
    }

    // Agrega más métodos según tus necesidades, como actualizar, eliminar, etc.
}
