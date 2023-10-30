package bo.ucb.edu.internship.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import bo.ucb.edu.internship.entity.EvaluacionPasantiaEntity;

public interface EvaluacionPasantiaDAO extends JpaRepository<EvaluacionPasantiaEntity, Integer> {
    
}
