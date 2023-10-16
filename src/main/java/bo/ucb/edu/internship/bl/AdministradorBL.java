package bo.ucb.edu.internship.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bo.ucb.edu.internship.dao.AdministradorDAO;
import bo.ucb.edu.internship.entity.AdministradorEntity;
import bo.ucb.edu.internship.entity.EmpresaEntity;
import bo.ucb.edu.internship.entity.TipoUsuarioEntity;
import bo.ucb.edu.internship.entity.UsuarioEntity;
import bo.ucb.edu.internship.dao.EmpresaDAO;
import bo.ucb.edu.internship.dao.TipoUsuarioDAO;
import bo.ucb.edu.internship.dao.UsuarioDAO;

@Service
public class AdministradorBL {

    private final AdministradorDAO administradorDAO;
    private final EmpresaDAO empresaDAO;
    private final UsuarioDAO usuarioDAO;
    private final TipoUsuarioDAO tipoUsuarioDAO;

    @Autowired
    public AdministradorBL(AdministradorDAO administradorDAO, EmpresaDAO empresaDAO, UsuarioDAO usuarioDAO, TipoUsuarioDAO tipoUsuarioDAO) {
        this.administradorDAO = administradorDAO;
        this.empresaDAO = empresaDAO;
        this.usuarioDAO = usuarioDAO;
        this.tipoUsuarioDAO = tipoUsuarioDAO;
    }

    // Método para crear un administrador:
    public AdministradorEntity createAdministrador(String cargo, Integer companyId, Integer userId, Integer typeuserId) {
        if (cargo == null || cargo.equals("")) {
            throw new RuntimeException("El cargo no debe estar vacío");
        } else if (companyId == null) {
            throw new RuntimeException("El companyId debe estar completo");
        } else if (userId == null) {
            throw new RuntimeException("El userId debe estar completo");
        } else if (typeuserId == null) {
            throw new RuntimeException("El typeuserId debe estar completo");
        }
        AdministradorEntity administrador = new AdministradorEntity();
        EmpresaEntity empresa = empresaDAO.findById(companyId).orElseThrow(() -> new RuntimeException("No se encontró ninguna empresa con el ID proporcionado"));
        UsuarioEntity usuario = usuarioDAO.findById(userId).orElseThrow(() -> new RuntimeException("No se encontró ningún usuario con el ID proporcionado"));
        TipoUsuarioEntity tipoUsuario = tipoUsuarioDAO.findById(typeuserId).orElseThrow(() -> new RuntimeException("No se encontró ningún tipo de usuario con el ID proporcionado"));
        administrador.setPosition(cargo);
        administrador.setCompanyId(empresa);
        administrador.setUserId(usuario);
        administrador.setTypeUserId(tipoUsuario);
        return administradorDAO.save(administrador);
    }

    // Método para obtener todos los administradores:
    public List<AdministradorEntity> getAllAdministradores() {
        return administradorDAO.findAll();
    }

    // Método para obtener un administrador por ID:
    public AdministradorEntity findAdministradorById(Integer id) {
        return administradorDAO.findById(id).orElseThrow(() -> new RuntimeException("No se encontró ningún administrador con el ID proporcionado"));
    }
}