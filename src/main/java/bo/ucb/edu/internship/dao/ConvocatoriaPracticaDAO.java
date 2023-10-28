package bo.ucb.edu.internship.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import bo.ucb.edu.internship.entity.ConvocatoriaPracticaEntity;

public interface ConvocatoriaPracticaDAO extends JpaRepository<ConvocatoriaPracticaEntity, Integer> {
    
}
