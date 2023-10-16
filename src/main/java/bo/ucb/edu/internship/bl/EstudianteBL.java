package bo.ucb.edu.internship.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bo.ucb.edu.internship.dao.EstudianteDAO;
import bo.ucb.edu.internship.entity.EstudianteEntity;
import bo.ucb.edu.internship.entity.TipoUsuarioEntity;
import bo.ucb.edu.internship.entity.UsuarioEntity;

import java.util.List;

@Service
public class EstudianteBL {

    private final EstudianteDAO estudianteDAO;

    @Autowired
    public EstudianteBL(EstudianteDAO estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }

    // Método para crear un estudiante:
    public EstudianteEntity createEstudiante(EstudianteEntity estudianteEntity) {
        // Validaciones, similar a las realizadas en los ejemplos anteriores
        if (estudianteEntity.getSemester() == null || estudianteEntity.getSemester().length() == 0) {
            throw new RuntimeException("El semestre del estudiante no puede estar vacío");
        }
        if (estudianteEntity.getCarrier() == null || estudianteEntity.getCarrier().length() == 0) {
            throw new RuntimeException("La carrera del estudiante no puede estar vacía");
        }
        // Otras validaciones aquí...

        EstudianteEntity estudiante = new EstudianteEntity();
        estudiante.setSemester(estudianteEntity.getSemester());
        estudiante.setCarrier(estudianteEntity.getCarrier());
        estudiante.setUser(estudianteEntity.getUser());
        estudiante.setTypeUser(estudianteEntity.getTypeUser());
        EstudianteEntity estudianteResult = estudianteDAO.save(estudiante);
        return estudianteResult;
    }

    // Método para obtener una lista de todos los estudiantes registrados:
    public List<EstudianteEntity> getAllEstudiantes() {
        return estudianteDAO.findAll();
    }

    // Método para encontrar un estudiante por su ID:
    public EstudianteEntity findEstudianteById(Integer id) {
        return estudianteDAO.findById(id).orElseThrow(() -> new RuntimeException("No se encontró ningún estudiante con el ID proporcionado"));
    }
}
