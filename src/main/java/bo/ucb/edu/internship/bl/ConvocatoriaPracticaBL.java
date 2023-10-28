package bo.ucb.edu.internship.bl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bo.ucb.edu.internship.dao.ConvocatoriaPracticaDAO;
import bo.ucb.edu.internship.entity.ConvocatoriaPracticaEntity;
import bo.ucb.edu.internship.dao.EmpresaDAO;
import bo.ucb.edu.internship.entity.EmpresaEntity;
import bo.ucb.edu.internship.dao.UseiDAO;
import bo.ucb.edu.internship.entity.UseiEntity;

@Service
public class ConvocatoriaPracticaBL {
    
    private final ConvocatoriaPracticaDAO convocatoriaPracticaDAO;
    private final EmpresaDAO empresaDAO;
    private final UseiDAO useiDAO;

    @Autowired
    public ConvocatoriaPracticaBL(ConvocatoriaPracticaDAO convocatoriaPracticaDAO, EmpresaDAO empresaDAO, UseiDAO useiDAO) {
        this.convocatoriaPracticaDAO = convocatoriaPracticaDAO;
        this.empresaDAO = empresaDAO;
        this.useiDAO = useiDAO;
    }

    //metodo para crear una convocatoria de practica:
    public ConvocatoriaPracticaEntity createConvocatoriaPractica(String titleConvocatoria, String descriptionConvocatoria, Date dateConvocatoria, Boolean stateConvocatoria, Integer companyId, Integer useiId) {
        if (titleConvocatoria == null) {
            throw new RuntimeException("El título de la convocatoria debe estar completo");
        } else if (descriptionConvocatoria == null) {
            throw new RuntimeException("La descripción de la convocatoria debe estar completa");
        } else if (dateConvocatoria == null || dateConvocatoria.toString().isEmpty()) {
            throw new RuntimeException("La fecha de la convocatoria debe estar completa");
        } else if (stateConvocatoria == null) {
            throw new RuntimeException("El estado de la convocatoria debe estar completo");
        } else if (companyId == null) {
            throw new RuntimeException("La empresa debe estar completa");
        } else if (useiId == null) {
            throw new RuntimeException("El usei debe estar completo");
        }
        ConvocatoriaPracticaEntity convocatoriaPractica = new ConvocatoriaPracticaEntity();
        EmpresaEntity empresa = empresaDAO.findById(companyId).orElseThrow(() -> new RuntimeException("No se encontró ninguna empresa con el ID proporcionado"));
        UseiEntity usei = useiDAO.findById(useiId).orElseThrow(() -> new RuntimeException("No se encontró ningún usei con el ID proporcionado"));
        convocatoriaPractica.setTitleConvocatoria(titleConvocatoria);
        convocatoriaPractica.setDescriptionConvocatoria(descriptionConvocatoria);
        convocatoriaPractica.setDateConvocatoria(dateConvocatoria);
        convocatoriaPractica.setStateConvocatoria(stateConvocatoria);
        convocatoriaPractica.setCompanyId(empresa);
        convocatoriaPractica.setUseiId(usei);
        return convocatoriaPracticaDAO.save(convocatoriaPractica);
    }

    //metodo para obtener todas las convocatorias de practica:
    public List<ConvocatoriaPracticaEntity> getAllConvocatoriaPractica() {
        return convocatoriaPracticaDAO.findAll();
    }

    //metodo para obtener una convocatoria de practica por ID:
    public ConvocatoriaPracticaEntity findConvocatoriaPracticaById(Integer id) {
        return convocatoriaPracticaDAO.findById(id).orElseThrow(() -> new RuntimeException("No se encontró ninguna convocatoria de práctica con el ID proporcionado"));
    }

    //metodo para actualizar una convocatoria de practica por ID:
    public ConvocatoriaPracticaEntity updateConvocatoriaPracticaById(Integer id, String titleConvocatoria, String descriptionConvocatoria, Date dateConvocatoria, Boolean stateConvocatoria, Integer companyId, Integer useiId) {
        if (titleConvocatoria == null) {
            throw new RuntimeException("El título de la convocatoria debe estar completo");
        } else if (descriptionConvocatoria == null) {
            throw new RuntimeException("La descripción de la convocatoria debe estar completa");
        } else if (dateConvocatoria == null || dateConvocatoria.toString().isEmpty()) {
            throw new RuntimeException("La fecha de la convocatoria debe estar completa");
        } else if (stateConvocatoria == null) {
            throw new RuntimeException("El estado de la convocatoria debe estar completo");
        } else if (companyId == null) {
            throw new RuntimeException("La empresa debe estar completa");
        } else if (useiId == null) {
            throw new RuntimeException("El usei debe estar completo");
        }
        ConvocatoriaPracticaEntity convocatoriaPractica = convocatoriaPracticaDAO.findById(id).orElseThrow(() -> new RuntimeException("No se encontró ninguna convocatoria de práctica con el ID proporcionado"));
        EmpresaEntity empresa = empresaDAO.findById(companyId).orElseThrow(() -> new RuntimeException("No se encontró ninguna empresa con el ID proporcionado"));
        UseiEntity usei = useiDAO.findById(useiId).orElseThrow(() -> new RuntimeException("No se encontró ningún usei con el ID proporcionado"));
        convocatoriaPractica.setTitleConvocatoria(titleConvocatoria);
        convocatoriaPractica.setDescriptionConvocatoria(descriptionConvocatoria);
        convocatoriaPractica.setDateConvocatoria(dateConvocatoria);
        convocatoriaPractica.setStateConvocatoria(stateConvocatoria);
        convocatoriaPractica.setCompanyId(empresa);
        convocatoriaPractica.setUseiId(usei);
        return convocatoriaPracticaDAO.save(convocatoriaPractica);
    }
}
