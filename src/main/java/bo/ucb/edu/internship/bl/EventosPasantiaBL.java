package bo.ucb.edu.internship.bl;

import java.security.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bo.ucb.edu.internship.dao.EventosPasantiaDAO;
import bo.ucb.edu.internship.entity.EventosPasantiaEntity;
import bo.ucb.edu.internship.dao.PracticaRealizadaDAO;
import bo.ucb.edu.internship.entity.PracticaRealizadaEntity;
import bo.ucb.edu.internship.dao.ConvocatoriaPracticaDAO;
import bo.ucb.edu.internship.entity.ConvocatoriaPracticaEntity;

@Service
public class EventosPasantiaBL {
    
    private final EventosPasantiaDAO eventosPasantiaDAO;
    private final PracticaRealizadaDAO practicaRealizadaDAO;
    private final ConvocatoriaPracticaDAO convocatoriaPracticaDAO;

    @Autowired
    public EventosPasantiaBL(EventosPasantiaDAO eventosPasantiaDAO, PracticaRealizadaDAO practicaRealizadaDAO, ConvocatoriaPracticaDAO convocatoriaPracticaDAO) {
        this.eventosPasantiaDAO = eventosPasantiaDAO;
        this.practicaRealizadaDAO = practicaRealizadaDAO;
        this.convocatoriaPracticaDAO = convocatoriaPracticaDAO;
    }

    //metodo para crear un evento de pasantia:
    public EventosPasantiaEntity createEventosPasantia(String tipoEvento, Timestamp dateEvento, String descriptionEvento, Integer practicaRealizadaId, Integer convocatoriaPracticaId) {
        if (tipoEvento == null) {
            throw new RuntimeException("El tipo de evento debe estar completo");
        } else if (dateEvento == null || dateEvento.toString().isEmpty()) {
            throw new RuntimeException("La fecha del evento debe estar completa");
        } else if (descriptionEvento == null) {
            throw new RuntimeException("La descripción del evento debe estar completa");
        } else if (practicaRealizadaId == null) {
            throw new RuntimeException("La práctica realizada debe estar completa");
        } else if (convocatoriaPracticaId == null) {
            throw new RuntimeException("La convocatoria de práctica debe estar completa");
        }
        EventosPasantiaEntity eventosPasantia = new EventosPasantiaEntity();
        PracticaRealizadaEntity practicaRealizada = practicaRealizadaDAO.findById(practicaRealizadaId).orElseThrow(() -> new RuntimeException("No se encontró ninguna práctica realizada con el ID proporcionado"));
        ConvocatoriaPracticaEntity convocatoriaPractica = convocatoriaPracticaDAO.findById(convocatoriaPracticaId).orElseThrow(() -> new RuntimeException("No se encontró ninguna convocatoria de práctica con el ID proporcionado"));
        eventosPasantia.setTipoEvento(tipoEvento);
        eventosPasantia.setDateEvento(dateEvento);
        eventosPasantia.setDescriptionEvento(descriptionEvento);
        eventosPasantia.setPracticaRealizadaId(practicaRealizada);
        eventosPasantia.setConvocatoriaPracticaId(convocatoriaPractica);
        return eventosPasantiaDAO.save(eventosPasantia);
    }

    //metodo para obtener todos los eventos de pasantia:
    public List<EventosPasantiaEntity> getAllEventosPasantia() {
        return eventosPasantiaDAO.findAll();
    }

    //metodo para obtener un evento de pasantia por su id:
    public EventosPasantiaEntity getEventosPasantiaById(Integer eventoId) {
        return eventosPasantiaDAO.findById(eventoId).orElseThrow(() -> new RuntimeException("No se encontró ningún evento de pasantía con el ID proporcionado"));
    }

    //metodo para actualizar un evento de pasantia:
    public EventosPasantiaEntity updateEventosPasantia(Integer eventoId, EventosPasantiaEntity eventosPasantiaEntity) {
        if (eventosPasantiaEntity.getTipoEvento() == null) {
            throw new RuntimeException("El tipo de evento debe estar completo");
        } else if (eventosPasantiaEntity.getDateEvento() == null || eventosPasantiaEntity.getDateEvento().toString().isEmpty()) {
            throw new RuntimeException("La fecha del evento debe estar completa");
        } else if (eventosPasantiaEntity.getDescriptionEvento() == null) {
            throw new RuntimeException("La descripción del evento debe estar completa");
        } else if (eventosPasantiaEntity.getPracticaRealizadaId() == null) {
            throw new RuntimeException("La práctica realizada debe estar completa");
        } else if (eventosPasantiaEntity.getConvocatoriaPracticaId() == null) {
            throw new RuntimeException("La convocatoria de práctica debe estar completa");
        }
        EventosPasantiaEntity eventosPasantia = eventosPasantiaDAO.findById(eventoId).orElseThrow(() -> new RuntimeException("No se encontró ningún evento de pasantía con el ID proporcionado"));
        PracticaRealizadaEntity practicaRealizada = practicaRealizadaDAO.findById(eventosPasantiaEntity.getPracticaRealizadaId().getPracticaRealizadaId()).orElseThrow(() -> new RuntimeException("No se encontró ninguna práctica realizada con el ID proporcionado"));
        ConvocatoriaPracticaEntity convocatoriaPractica = convocatoriaPracticaDAO.findById(eventosPasantiaEntity.getConvocatoriaPracticaId().getConvocatoriaPracticaId()).orElseThrow(() -> new RuntimeException("No se encontró ninguna convocatoria de práctica con el ID proporcionado"));
        eventosPasantia.setTipoEvento(eventosPasantiaEntity.getTipoEvento());
        eventosPasantia.setDateEvento(eventosPasantiaEntity.getDateEvento());
        eventosPasantia.setDescriptionEvento(eventosPasantiaEntity.getDescriptionEvento());
        eventosPasantia.setPracticaRealizadaId(practicaRealizada);
        eventosPasantia.setConvocatoriaPracticaId(convocatoriaPractica);
        eventosPasantiaDAO.save(eventosPasantia);
        return eventosPasantia;
    }
}
