package bo.ucb.edu.internship.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import bo.ucb.edu.internship.entity.AdministradorEntity;

public interface AdministradorDAO extends JpaRepository<AdministradorEntity, Integer> {
    
}
