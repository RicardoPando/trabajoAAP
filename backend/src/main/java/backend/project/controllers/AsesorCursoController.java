package backend.project.controllers;
import backend.project.entities.Asesor;
import backend.project.entities.AsesorCurso;
import backend.project.entities.Curso;
import backend.project.services.AsesorCursoService;
import org.apache.xmlbeans.impl.store.Cur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AsesorCursoController {

    @Autowired
    AsesorCursoService asesorCursoService;
    //listar
    @GetMapping("/asesor_curso")
    public ResponseEntity<AsesorCurso> getAllAsesorCurso(Long id) {
        AsesorCurso asesorCurso = asesorCursoService.findById(id);
        return new ResponseEntity<AsesorCurso>(asesorCurso, HttpStatus.OK);
    }
    @GetMapping("/asesor_curso/{id}")
    public ResponseEntity<AsesorCurso> getAsesorCursoById(@PathVariable("id") Long id) {
        AsesorCurso asesorCurso = asesorCursoService.findById(id);
        return new ResponseEntity<AsesorCurso>(asesorCurso, HttpStatus.OK);
    }
    //listar asesor curso por id asesor
    @GetMapping("/asesor_curso/asesor/{id_asesor}")
    public ResponseEntity<List<AsesorCurso>> getAsesorCursoByAsesor_Id(@PathVariable("id_asesor") Long id) {
        List<AsesorCurso> asesorCursoList = asesorCursoService.findByAsesor_Id(id);
        return new ResponseEntity<List<AsesorCurso>>(asesorCursoList, HttpStatus.OK);
    }
    //listar asesor curso por id curso
    @GetMapping("/asesor_curso/curso/{id_curso}")
    public ResponseEntity<List<AsesorCurso>> getAsesorCursoByCurso_Id(@PathVariable("id_curso") Long id) {
        List<AsesorCurso> asesorCursoList = asesorCursoService.findByCurso_Id(id);
        return new ResponseEntity<List<AsesorCurso>>(asesorCursoList, HttpStatus.OK);
    }
    //listar curso por id asesor
    @GetMapping("/asesor_curso/curso/asesor/{id_asesor}")
    public ResponseEntity<List<Curso>> getCursoByAsesor_Id(@PathVariable("id_asesor") Long id) {
        List<Curso> cursoList = asesorCursoService.findCurso_ByAsesor_Id(id);
        return new ResponseEntity<List<Curso>>(cursoList, HttpStatus.OK);
    }
    //listar asesor por id curso
    @GetMapping("/asesor_curso/asesor/curso/{id_curso}")
    public ResponseEntity<List<Asesor>> getAsesorByCurso_Id(@PathVariable("id_curso") Long id) {
        List<Asesor> asesorList = asesorCursoService.findAsesor_ByCurso_Id(id);
        return new ResponseEntity<List<Asesor>>(asesorList, HttpStatus.OK);
    }
    //create
    @PostMapping("/asesor_curso")
    public ResponseEntity<AsesorCurso> createAsesorCurso(@RequestBody AsesorCurso asesorCurso) {
        AsesorCurso newAsesorCurso = asesorCursoService.save(asesorCurso);
        return new ResponseEntity<AsesorCurso>(newAsesorCurso, HttpStatus.CREATED);
    }
    //modificar
    @PutMapping("/asesor_curso/{id}")
    public ResponseEntity<AsesorCurso> updateAsesorCurso(@RequestBody AsesorCurso asesorCurso, @PathVariable("id") Long id) {
        AsesorCurso newAsesorCurso = asesorCursoService.save(asesorCurso);
        return new ResponseEntity<AsesorCurso>(newAsesorCurso, HttpStatus.OK);
    }
    //eliminar
    @DeleteMapping("/asesor_curso/{id}")
    public ResponseEntity<HttpStatus> deleteAsesorCurso(@PathVariable("id") Long id) {
        asesorCursoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
