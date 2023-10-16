package bo.ucb.edu.internship.api;

import bo.ucb.edu.internship.entity.EvaluadorEntity;
import bo.ucb.edu.internship.bl.EvaluadorBL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/evaluador")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EvaluadorAPI {

    private final EvaluadorBL evaluadorBL;

    @Autowired
    public EvaluadorAPI(EvaluadorBL evaluadorBL) {
        this.evaluadorBL = evaluadorBL;
    }

    @PostMapping("/register")
    public ResponseEntity<EvaluadorEntity> createEvaluador(@RequestBody EvaluadorEntity evaluadorEntity) {
        EvaluadorEntity evaluador = evaluadorBL.createEvaluador(evaluadorEntity);
        return new ResponseEntity<>(evaluador, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<EvaluadorEntity>> getAllEvaluadores() {
        List<EvaluadorEntity> evaluadores = evaluadorBL.getAllEvaluadores();
        return new ResponseEntity<>(evaluadores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluadorEntity> findEvaluadorById(@PathVariable Integer id) {
        EvaluadorEntity evaluador = evaluadorBL.findEvaluadorById(id);
        if (evaluador != null) {
            return new ResponseEntity<>(evaluador, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
