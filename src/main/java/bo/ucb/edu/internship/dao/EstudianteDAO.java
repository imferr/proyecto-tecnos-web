package bo.ucb.edu.internship.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import bo.ucb.edu.internship.entity.EstudianteEntity;

public interface EstudianteDAO extends JpaRepository<EstudianteEntity, Integer> {
    
}
