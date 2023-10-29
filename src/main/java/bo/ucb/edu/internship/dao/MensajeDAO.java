package bo.ucb.edu.internship.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import bo.ucb.edu.internship.entity.MensajeEntity;

public interface MensajeDAO extends JpaRepository<MensajeEntity, Integer> {
    
}
