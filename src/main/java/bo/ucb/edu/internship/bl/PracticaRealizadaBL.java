package bo.ucb.edu.internship.bl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bo.ucb.edu.internship.dao.PracticaRealizadaDAO;
import bo.ucb.edu.internship.entity.PracticaRealizadaEntity;

@Service
public class PracticaRealizadaBL {

    private final PracticaRealizadaDAO practicaRealizadaDAO;

    @Autowired
    public PracticaRealizadaBL(PracticaRealizadaDAO practicaRealizadaDAO) {
        this.practicaRealizadaDAO = practicaRealizadaDAO;
    }

    //metodo para crear una práctica realizada:
    public PracticaRealizadaEntity createPracticaRealizada(Date fechaInicio, Date fechaFinalizacion, Boolean estadoPractica) {
        if (fechaInicio == null || fechaInicio.toString().isEmpty()) {
            throw new RuntimeException("La fecha de inicio debe estar completa");
        } else if (fechaFinalizacion == null || fechaFinalizacion.toString().isEmpty()) {
            throw new RuntimeException("La fecha de finalización debe estar completa");
        } else if (estadoPractica == null) {
            throw new RuntimeException("El estado de la práctica debe estar completo");
        }
        PracticaRealizadaEntity practicaRealizada = new PracticaRealizadaEntity();
        practicaRealizada.setDatePracticaRealizadaBegin(fechaInicio);
        practicaRealizada.setDatePracticaRealizadaEnd(fechaFinalizacion);
        practicaRealizada.setStatePracticaRealizada(estadoPractica);
        return practicaRealizadaDAO.save(practicaRealizada);
    }

    //metodo para obtener todas las prácticas realizadas, en base a una lista:
    public List<PracticaRealizadaEntity> getAllPracticasRealizadas() {
        return practicaRealizadaDAO.findAll();
    }

    //metodo para obtener una práctica realizada por su id:
    public PracticaRealizadaEntity getPracticaRealizadaById(Integer practicaId) {
        return practicaRealizadaDAO.findById(practicaId).orElseThrow(() -> new RuntimeException("No se encontró ninguna práctica realizada con el ID proporcionado"));
    }

    //metodo para actualizar una práctica realizada por su id:
    public PracticaRealizadaEntity updatePracticaRealizadaById(Integer practicaId, Date fechaInicio, Date fechaFinalizacion, Boolean estadoPractica) {
        PracticaRealizadaEntity practicaRealizada = practicaRealizadaDAO.findById(practicaId).orElseThrow(() -> new RuntimeException("No se encontró ninguna práctica realizada con el ID proporcionado"));
        if (fechaInicio == null || fechaInicio.toString().isEmpty()) {
            throw new RuntimeException("La fecha de inicio debe estar completa");
        } else if (fechaFinalizacion == null || fechaFinalizacion.toString().isEmpty()) {
            throw new RuntimeException("La fecha de finalización debe estar completa");
        } else if (estadoPractica == null) {
            throw new RuntimeException("El estado de la práctica debe estar completo");
        }
        practicaRealizada.setDatePracticaRealizadaBegin(fechaInicio);
        practicaRealizada.setDatePracticaRealizadaEnd(fechaFinalizacion);
        practicaRealizada.setStatePracticaRealizada(estadoPractica);
        return practicaRealizadaDAO.save(practicaRealizada);
    }
}

