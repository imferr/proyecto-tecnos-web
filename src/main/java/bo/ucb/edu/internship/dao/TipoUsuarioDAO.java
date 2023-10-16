package bo.ucb.edu.internship.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import bo.ucb.edu.internship.entity.TipoUsuarioEntity;

public interface TipoUsuarioDAO extends JpaRepository<TipoUsuarioEntity, Integer> {
    
}
