package bo.ucb.edu.internship.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import bo.ucb.edu.internship.entity.EmpresaEntity;

public interface EmpresaDAO extends JpaRepository<EmpresaEntity, Integer> {
    
}
