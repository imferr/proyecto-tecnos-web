package bo.ucb.edu.internship.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import bo.ucb.edu.internship.entity.UsuarioEntity;

public interface UsuarioDAO extends JpaRepository<UsuarioEntity, Integer> {
        
}
