package bo.ucb.edu.internship.bl;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bo.ucb.edu.internship.dao.EvaluacionPasantiaDAO;
import bo.ucb.edu.internship.entity.EvaluacionPasantiaEntity;
import bo.ucb.edu.internship.dao.PracticaRealizadaDAO;
import bo.ucb.edu.internship.entity.PracticaRealizadaEntity;
import bo.ucb.edu.internship.dao.EvaluadorDAO;
import bo.ucb.edu.internship.entity.EvaluadorEntity;

@Service
public class EvaluacionPasantiaBL {
    
    private final EvaluacionPasantiaDAO evaluacionPasantiaDAO;
    private final PracticaRealizadaDAO practicaRealizadaDAO;
    private final EvaluadorDAO evaluadorDAO;

    @Autowired
    public EvaluacionPasantiaBL(EvaluacionPasantiaDAO evaluacionPasantiaDAO, PracticaRealizadaDAO practicaRealizadaDAO, EvaluadorDAO evaluadorDAO) {
        this.evaluacionPasantiaDAO = evaluacionPasantiaDAO;
        this.practicaRealizadaDAO = practicaRealizadaDAO;
        this.evaluadorDAO = evaluadorDAO;
    }

    //metodo para crear una evaluación de pasantía:
    public EvaluacionPasantiaEntity createEvaluacionPasantia(Integer evaluacionId, DecimalFormat evaluacionDesempenio, String comentarioEvaluacion, Integer practicaRealizadaId, Integer evaluadorId) {
        if (evaluacionId == null) {
            throw new RuntimeException("El ID de la evaluación debe estar completo");
        } else if (evaluacionDesempenio == null) {
            throw new RuntimeException("La nota de la evaluación debe estar completa");
        } else if (comentarioEvaluacion == null || comentarioEvaluacion.isEmpty()) {
            throw new RuntimeException("El comentario de la evaluación debe estar completo");
        } else if (practicaRealizadaId == null) {
            throw new RuntimeException("El ID de la práctica realizada debe estar completo");
        } else if (evaluadorId == null) {
            throw new RuntimeException("El ID del evaluador debe estar completo");
        }
        EvaluacionPasantiaEntity evaluacionPasantia = new EvaluacionPasantiaEntity();
        PracticaRealizadaEntity practicaRealizada = practicaRealizadaDAO.findById(practicaRealizadaId).orElseThrow(() -> new RuntimeException("No se encontró ninguna práctica realizada con el ID proporcionado"));
        EvaluadorEntity evaluador = evaluadorDAO.findById(evaluadorId).orElseThrow(() -> new RuntimeException("No se encontró ningún evaluador con el ID proporcionado"));
        evaluacionPasantia.setEvaluacionId(evaluacionId);
        evaluacionPasantia.setNotaEvaluacion(evaluacionDesempenio);
        evaluacionPasantia.setComentsEvaluacion(comentarioEvaluacion);
        evaluacionPasantia.setPracticaRealizadaId(practicaRealizada);
        evaluacionPasantia.setEvaluadorId(evaluador);
        return evaluacionPasantiaDAO.save(evaluacionPasantia);
    }

    //metodo para obtener todas las evaluaciones de pasantía, en base a una lista:
    public List<EvaluacionPasantiaEntity> getAllEvaluacionesPasantia() {
        return evaluacionPasantiaDAO.findAll();
    }

    //metodo para obtener una evaluación de pasantía por su id:
    public EvaluacionPasantiaEntity getEvaluacionPasantiaById(Integer evaluacionId) {
        return evaluacionPasantiaDAO.findById(evaluacionId).orElseThrow(() -> new RuntimeException("No se encontró ninguna evaluación de pasantía con el ID proporcionado"));
    }

    //metodo para actualizar una evaluación de pasantía por su id:
    public EvaluacionPasantiaEntity updateEvaluacionPasantiaById(Integer evaluacionId, DecimalFormat evaluacionDesempenio, String comentarioEvaluacion, Integer practicaRealizadaId, Integer evaluadorId) {
        EvaluacionPasantiaEntity evaluacionPasantia = evaluacionPasantiaDAO.findById(evaluacionId).orElseThrow(() -> new RuntimeException("No se encontró ninguna evaluación de pasantía con el ID proporcionado"));
        if (evaluacionId == null) {
            throw new RuntimeException("El ID de la evaluación debe estar completo");
        } else if (evaluacionDesempenio == null) {
            throw new RuntimeException("La nota de la evaluación debe estar completa");
        } else if (comentarioEvaluacion == null || comentarioEvaluacion.isEmpty()) {
            throw new RuntimeException("El comentario de la evaluación debe estar completo");
        } else if (practicaRealizadaId == null) {
            throw new RuntimeException("El ID de la práctica realizada debe estar completo");
        } else if (evaluadorId == null) {
            throw new RuntimeException("El ID del evaluador debe estar completo");
        }
        PracticaRealizadaEntity practicaRealizada = practicaRealizadaDAO.findById(practicaRealizadaId).orElseThrow(() -> new RuntimeException("No se encontró ninguna práctica realizada con el ID proporcionado"));
        EvaluadorEntity evaluador = evaluadorDAO.findById(evaluadorId).orElseThrow(() -> new RuntimeException("No se encontró ningún evaluador con el ID proporcionado"));
        evaluacionPasantia.setEvaluacionId(evaluacionId);
        evaluacionPasantia.setNotaEvaluacion(evaluacionDesempenio);
        evaluacionPasantia.setComentsEvaluacion(comentarioEvaluacion);
        evaluacionPasantia.setPracticaRealizadaId(practicaRealizada);
        evaluacionPasantia.setEvaluadorId(evaluador);
        return evaluacionPasantiaDAO.save(evaluacionPasantia);
    }
}
