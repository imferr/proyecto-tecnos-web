package bo.ucb.edu.internship.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bo.ucb.edu.internship.dao.AdministradorDAO;
import bo.ucb.edu.internship.entity.AdministradorEntity;
import bo.ucb.edu.internship.entity.EmpresaEntity;
import bo.ucb.edu.internship.entity.UsuarioEntity;
import bo.ucb.edu.internship.entity.TipoUsuarioEntity;

import java.util.List;

@Service
public class AdministradorBL {

    private final AdministradorDAO administradorDAO;

    @Autowired
    public AdministradorBL(AdministradorDAO administradorDAO) {
        this.administradorDAO = administradorDAO;
    }

    // Método para crear un administrador:
    public AdministradorEntity createAdministrador(AdministradorEntity administradorEntity) {
        // Validaciones, similar a las realizadas en EmpresaBL
        if (administradorEntity.getPosition() == null || administradorEntity.getPosition().length() == 0) {
            throw new RuntimeException("El cargo del administrador no puede estar vacío");
        }
        // Otras validaciones aquí...

        AdministradorEntity administrador = new AdministradorEntity();
        administrador.setPosition(administradorEntity.getPosition());
        administrador.setUserId(administradorEntity.getUserId());
        administrador.setTypeUser(administradorEntity.getTypeUser());
        administrador.setCompanyId(administradorEntity.getCompanyId());
        AdministradorEntity administradorResult = administradorDAO.save(administrador);
        return administradorResult;
    }

    // Método para obtener una lista de todos los administradores registrados:
    public List<AdministradorEntity> getAllAdministradores() {
        return administradorDAO.findAll();
    }

    // Método para encontrar un administrador por su ID:
    public AdministradorEntity findAdministradorById(Integer id) {
        return administradorDAO.findById(id).orElseThrow(() -> new RuntimeException("No se encontró ningún administrador con el ID proporcionado"));
    }
}
