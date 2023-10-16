package bo.ucb.edu.internship.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import bo.ucb.edu.internship.entity.EvaluadorEntity;

public interface EvaluadorDAO extends JpaRepository<EvaluadorEntity, Integer> {
    
}
