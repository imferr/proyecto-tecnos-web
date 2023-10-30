package bo.ucb.edu.internship.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import bo.ucb.edu.internship.entity.EventosPasantiaEntity;

public interface EventosPasantiaDAO extends JpaRepository<EventosPasantiaEntity, Integer> {
    
}
