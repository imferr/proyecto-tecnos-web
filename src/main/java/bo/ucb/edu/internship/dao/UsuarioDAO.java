package bo.ucb.edu.internship.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import bo.ucb.edu.internship.entity.UsuarioEntity;

public interface UsuarioDAO extends JpaRepository<UsuarioEntity, Integer> {
    Optional<UsuarioEntity> findByEmail(String email);
}
