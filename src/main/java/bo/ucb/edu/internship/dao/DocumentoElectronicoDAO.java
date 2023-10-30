package bo.ucb.edu.internship.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import bo.ucb.edu.internship.entity.DocumentoElectronicoEntity;


public interface DocumentoElectronicoDAO extends JpaRepository<DocumentoElectronicoEntity, Integer> {
    
}
