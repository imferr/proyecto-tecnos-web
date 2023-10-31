package bo.ucb.edu.internship.bl;

import org.springframework.stereotype.Service;

import bo.ucb.edu.internship.dao.EstudianteDAO;
import bo.ucb.edu.internship.dao.FormularioSolicitudDAO;
import bo.ucb.edu.internship.entity.EstudianteEntity;
import bo.ucb.edu.internship.entity.FormularioSolicitudEntity;

import java.util.Date;
import java.util.List;

@Service
public class FormularioSolicitudBL {

    private final FormularioSolicitudDAO formularioSolicitudDAO;
    private final EstudianteDAO estudianteDAO;

    public FormularioSolicitudBL(FormularioSolicitudDAO formularioSolicitudDAO, EstudianteDAO estudianteDAO) {
        this.formularioSolicitudDAO = formularioSolicitudDAO;
        this.estudianteDAO = estudianteDAO;
    }

    public FormularioSolicitudEntity createFormularioSolicitud(Date requestDate, Boolean requestStatus, String attachedDocument, Integer studentId) {
        if (requestDate == null) {
            throw new RuntimeException("La fecha de solicitud debe estar completa");
        } else if (requestStatus == null) {
            throw new RuntimeException("El estado de solicitud debe estar completo");
        } else if (attachedDocument == null || attachedDocument.isEmpty()) {
            throw new RuntimeException("El documento adjunto debe estar completo");
        } else if (studentId == null) {
            throw new RuntimeException("El ID del estudiante debe estar completo");
        }

        FormularioSolicitudEntity formularioSolicitud = new FormularioSolicitudEntity();
        EstudianteEntity estudiante = estudianteDAO.findById(studentId).orElseThrow(() -> new RuntimeException("No se encontró ningún estudiante con el ID proporcionado"));
        formularioSolicitud.setRequestDate(requestDate);
        formularioSolicitud.setRequestStatus(requestStatus);
        formularioSolicitud.setAttachedDocument(attachedDocument);
        formularioSolicitud.setStudentId(estudiante);

        return formularioSolicitudDAO.save(formularioSolicitud);
    }

    public List<FormularioSolicitudEntity> getAllFormulariosSolicitud() {
        return formularioSolicitudDAO.findAll();
    }

    public FormularioSolicitudEntity findFormularioSolicitudById(Integer id) {
        return formularioSolicitudDAO.findById(id).orElseThrow(() -> new RuntimeException("No se encontró ningún formulario de solicitud con el ID proporcionado"));
    }

    public FormularioSolicitudEntity updateFormularioSolicitud(Integer id, Date requestDate, Boolean requestStatus, String attachedDocument, Integer studentId) {
        FormularioSolicitudEntity formularioSolicitud = formularioSolicitudDAO.findById(id).orElseThrow(() -> new RuntimeException("No se encontró ningún formulario de solicitud con el ID proporcionado"));
        if (requestDate == null) {
            throw new RuntimeException("La fecha de solicitud debe estar completa");
        } else if (requestStatus == null) {
            throw new RuntimeException("El estado de solicitud debe estar completo");
        } else if (attachedDocument == null || attachedDocument.isEmpty()) {
            throw new RuntimeException("El documento adjunto debe estar completo");
        } else if (studentId == null) {
            throw new RuntimeException("El ID del estudiante debe estar completo");
        }

        EstudianteEntity estudiante = estudianteDAO.findById(studentId).orElseThrow(() -> new RuntimeException("No se encontró ningún estudiante con el ID proporcionado"));
        formularioSolicitud.setRequestDate(requestDate);
        formularioSolicitud.setRequestStatus(requestStatus);
        formularioSolicitud.setAttachedDocument(attachedDocument);
        formularioSolicitud.setStudentId(estudiante);

        return formularioSolicitudDAO.save(formularioSolicitud);
    }

    public void deleteFormularioSolicitud(Integer id) {
        FormularioSolicitudEntity formularioSolicitud = formularioSolicitudDAO.findById(id).orElseThrow(() -> new RuntimeException("No se encontró ningún formulario con el ID proporcionado"));
        formularioSolicitudDAO.delete(formularioSolicitud);
        return ;

    }


}
