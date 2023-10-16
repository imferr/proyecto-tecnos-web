package bo.ucb.edu.internship.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.ucb.edu.internship.dao.EstudianteDAO;
import bo.ucb.edu.internship.dto.EstudianteDTO;
import bo.ucb.edu.internship.entity.EstudianteEntity;

import java.util.List;

@Service
public class EstudianteBL {

    private final EstudianteDAO estudianteDAO;

    @Autowired
    public EstudianteBL(EstudianteDAO estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }

    public EstudianteEntity createEstudiante(EstudianteEntity estudianteEntity) {
        // Realiza las validaciones necesarias
        // ...

        // Puedes agregar más lógica aquí si es necesario

        EstudianteEntity estudiante = estudianteDAO.save(estudianteEntity);
        return estudiante;
    }

    public List<EstudianteEntity> getAllEstudiantes() {
        return estudianteDAO.findAll();
    }

    public EstudianteEntity findEstudianteById(Integer id) {
        return estudianteDAO.findById(id).orElseThrow(() -> new RuntimeException("No se encontró ningún estudiante con el ID proporcionado"));
    }

    public void createEstudiante(EstudianteDTO estudianteDTO) {
    }
}
