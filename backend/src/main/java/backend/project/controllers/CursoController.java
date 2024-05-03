package backend.project.controllers;
import backend.project.entities.Curso;
import backend.project.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CursoController {
    @Autowired
    CursoService cursoService;

    //http://localhost:8080/api/curso

    //listar
    @GetMapping("/curso")
    public ResponseEntity<List<Curso>> getAllCurso() {
        List<Curso> cursoList = cursoService.listAll();
        return new ResponseEntity<List<Curso>>(cursoList, HttpStatus.OK);
    }
    //listar por id
    @GetMapping("/curso/{id}")
    public ResponseEntity<Curso> geCursoById(@PathVariable("id") Long id) {
        Curso curso = cursoService.findById(id);
        return new ResponseEntity<Curso>(curso, HttpStatus.OK);
    }
    //crear
    @PostMapping("/curso")
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
        Curso newCurso = cursoService.save(curso);
        return new ResponseEntity<Curso>(newCurso, HttpStatus.CREATED);
    }
    //eliminar
    @DeleteMapping("/curso/{id}")
    public ResponseEntity<HttpStatus> deleteCurso(@PathVariable("id") Long id) {
        cursoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //modificar
    //Alternativa 1 -> Pasar el Id por la ruta
    @PutMapping("/curso/{id}")
    public ResponseEntity<Curso> updateCurso(@RequestBody Curso curso, @PathVariable("id") Long id) {
        Curso foundCurso = cursoService.findById(id);
        if (curso.getNombre()!=null) {
            foundCurso.setNombre(curso.getNombre());
        }
        if (curso.getCiclo()!=null) {
            foundCurso.setCiclo(curso.getCiclo());
        }
        if (curso.getAsesorias()!=null) {
            foundCurso.setAsesorias(curso.getAsesorias());
        }
        if (curso.getAsesorCursos()!=null) {
            foundCurso.setAsesorCursos(curso.getAsesorCursos());
        }
        if (curso.getAlumnosCursos()!=null) {
            foundCurso.setAlumnosCursos(curso.getAlumnosCursos());
        }

        Curso newCurso = cursoService.save(foundCurso);
        return new ResponseEntity<Curso>(newCurso, HttpStatus.OK);
    }
   
}
