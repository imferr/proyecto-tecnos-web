package bo.ucb.edu.internship.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import bo.ucb.edu.internship.entity.PracticaRealizadaEntity;

public interface PracticaRealizadaDAO extends JpaRepository<PracticaRealizadaEntity, Integer> {
    
}
