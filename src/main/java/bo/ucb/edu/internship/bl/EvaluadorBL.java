package bo.ucb.edu.internship.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bo.ucb.edu.internship.dao.EvaluadorDAO;
import bo.ucb.edu.internship.entity.EvaluadorEntity;

import java.util.List;

@Service
public class EvaluadorBL {

    private final EvaluadorDAO evaluadorDAO;

    @Autowired
    public EvaluadorBL(EvaluadorDAO evaluadorDAO) {
        this.evaluadorDAO = evaluadorDAO;
    }

    public List<EvaluadorEntity> getAllEvaluadores() {
        return evaluadorDAO.findAll();
    }

    public EvaluadorEntity findEvaluadorById(Integer id) {
        return evaluadorDAO.findById(id).orElse(null);
    }

    public EvaluadorEntity createEvaluador(EvaluadorEntity evaluadorEntity) {
        // Realiza validaciones según tus requisitos
        return evaluadorDAO.save(evaluadorEntity);
    }
}
