package backend.project.controllers;
import backend.project.entities.Opinion;
import backend.project.services.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class OpinionController {
    @Autowired
    OpinionService opinionService;

    //http://localhost:8080/api/opinion

    //listar
    @GetMapping("/opinion")
    public ResponseEntity<List<Opinion>> getAllOpinion() {
        List<Opinion> opinionList = opinionService.listAll();
        return new ResponseEntity<List<Opinion>>(opinionList, HttpStatus.OK);
    }
    //listar por id
    @GetMapping("/opinion/{id}")
    public ResponseEntity<Opinion> geOpinionById(@PathVariable("id") Long id) {
        Opinion opinion = opinionService.findById(id);
        return new ResponseEntity<Opinion>(opinion, HttpStatus.OK);
    }
    //crear
    @PostMapping("/opinion")
    public ResponseEntity<Opinion> createOpinion(@RequestBody Opinion opinion) {
        Opinion newOpinion = opinionService.save(opinion);
        return new ResponseEntity<Opinion>(newOpinion, HttpStatus.CREATED);
    }
    //eliminar
    @DeleteMapping("/opinion/{id}")
    public ResponseEntity<HttpStatus> deleteOpinion(@PathVariable("id") Long id) {
        opinionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //modificar
    //Alternativa 1 -> Pasar el Id por la ruta
    @PutMapping("/opinion/{id}")
    public ResponseEntity<Opinion> updateOpinion(@RequestBody Opinion opinion, @PathVariable("id") Long id) {
        Opinion foundOpinion = opinionService.findById(id);
        if (opinion.getFecha()!=null) {
            foundOpinion.setFecha(opinion.getFecha());
        }
        if (opinion.getComentario()!=null) {
            foundOpinion.setComentario(opinion.getComentario());
        }
        if (opinion.getUser()!=null) {
            foundOpinion.setUser(opinion.getUser());
        }
        Opinion newOpinion = opinionService.save(foundOpinion);
        return new ResponseEntity<Opinion>(newOpinion, HttpStatus.OK);
    }
}
