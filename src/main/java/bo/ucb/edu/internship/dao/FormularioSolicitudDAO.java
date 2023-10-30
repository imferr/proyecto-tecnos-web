package bo.ucb.edu.internship.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import bo.ucb.edu.internship.entity.FormularioSolicitudEntity;

public interface FormularioSolicitudDAO extends JpaRepository<FormularioSolicitudEntity, Integer> {
    
}
