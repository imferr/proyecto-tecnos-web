package bo.ucb.edu.internship.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.ucb.edu.internship.dao.EstudianteDAO;
import bo.ucb.edu.internship.dto.EstudianteDTO;
import bo.ucb.edu.internship.entity.EstudianteEntity;
import bo.ucb.edu.internship.dao.UsuarioDAO;
import bo.ucb.edu.internship.entity.UsuarioEntity;
import bo.ucb.edu.internship.entity.TipoUsuarioEntity;
import bo.ucb.edu.internship.dao.TipoUsuarioDAO;

import java.util.List;

@Service
public class EstudianteBL {

    private final EstudianteDAO estudianteDAO;
    private final UsuarioDAO usuarioDAO;
    private final TipoUsuarioDAO tipoUsuarioDAO;

    @Autowired
    public EstudianteBL(EstudianteDAO estudianteDAO, UsuarioDAO usuarioDAO, TipoUsuarioDAO tipoUsuarioDAO) {
        this.estudianteDAO = estudianteDAO;
        this.usuarioDAO = usuarioDAO;
        this.tipoUsuarioDAO = tipoUsuarioDAO;
    }

    public EstudianteEntity createEstudiante(String semestre, String carrera, Integer userId, Integer typeUserId) {
        if (semestre == null ) {
            throw new RuntimeException("El semestre es obligatorio");
        } else if (carrera == null) {
            throw new RuntimeException("La carrera es obligatoria");
        } else if (userId == null || typeUserId == null) {
            throw new RuntimeException("El ID del usuario y el ID del tipo de usuario son obligatorios");
        }
        EstudianteEntity estudiante = new EstudianteEntity();
        UsuarioEntity usuario = usuarioDAO.findById(userId).orElseThrow(() -> new RuntimeException("No se encontró ningún usuario con el ID proporcionado"));
        TipoUsuarioEntity tipoUsuario = tipoUsuarioDAO.findById(typeUserId).orElseThrow(() -> new RuntimeException("No se encontró ningún tipo de usuario con el ID proporcionado"));
        estudiante.setSemester(semestre);
        estudiante.setCarrier(carrera);
        estudiante.setUserId(usuario);
        estudiante.setTypeUserId(tipoUsuario);
        return estudianteDAO.save(estudiante);   
    }

    public List<EstudianteEntity> getAllEstudiantes() {
        return estudianteDAO.findAll();
    }

    public EstudianteEntity findEstudianteById(Integer id) {
        return estudianteDAO.findById(id).orElseThrow(() -> new RuntimeException("No se encontró ningún estudiante con el ID proporcionado"));
    }
}
