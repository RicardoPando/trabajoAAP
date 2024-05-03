package backend.project.controllers;
import backend.project.entities.Alumno;
import backend.project.entities.AlumnoCurso;
import backend.project.entities.Curso;
import backend.project.services.AlumnoCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AlumnoCursoController {
    @Autowired
    AlumnoCursoService alumnoCursoService;
    //listar
    @GetMapping("/alumno_curso")
    public ResponseEntity<List<AlumnoCurso>> getAllAlumnoCurso() {
        List<AlumnoCurso> alumnoCurso = alumnoCursoService.listAll();
        return new ResponseEntity<List<AlumnoCurso>>(alumnoCurso, HttpStatus.OK);
    }
    @GetMapping("/alumno_curso/{id}")
    public ResponseEntity<AlumnoCurso> getAlumnoCursoById(@PathVariable("id") Long id) {
        AlumnoCurso alumnoCurso = alumnoCursoService.findById(id);
        return new ResponseEntity<AlumnoCurso>(alumnoCurso, HttpStatus.OK);
    }
    //listar alumno curso por id alumno
    @GetMapping("/alumno_curso/alumno/{id_alumno}")
    public ResponseEntity<List<AlumnoCurso>> getAlumnoCursoByAlumno_Id(@PathVariable("id_alumno") Long id) {
        List<AlumnoCurso> alumnoCursoList = alumnoCursoService.findByAlumno_Id(id);
        return new ResponseEntity<List<AlumnoCurso>>(alumnoCursoList, HttpStatus.OK);
    }
    //listar alumno curso por id curso
    @GetMapping("/alumno_curso/curso/{id_curso}")
    public ResponseEntity<List<AlumnoCurso>> getAlumnoCursoByCurso_Id(@PathVariable("id_curso") Long id) {
        List<AlumnoCurso> alumnoCursoList = alumnoCursoService.findByCurso_Id(id);
        return new ResponseEntity<List<AlumnoCurso>>(alumnoCursoList, HttpStatus.OK);
    }
    //listar curso por id alumno
    @GetMapping("/alumno_curso/curso/alumno/{id_alumno}")
    public ResponseEntity<List<Curso>> getCursoByAsesor_Id(@PathVariable("id_alumno") Long id) {
        List<Curso> cursoList = alumnoCursoService.findCurso_ByAlumno_Id(id);
        return new ResponseEntity<List<Curso>>(cursoList, HttpStatus.OK);
    }
    //listar alumno por id curso
    @GetMapping("/alumno_curso/alumno/curso/{id_curso}")
    public ResponseEntity<List<Alumno>> getAsesorByCurso_Id(@PathVariable("id_curso") Long id) {
        List<Alumno> alumnoList = alumnoCursoService.findAlumno_ByCurso_Id(id);
        return new ResponseEntity<List<Alumno>>(alumnoList, HttpStatus.OK);
    }
    //create
    @PostMapping("/alumno_curso")
    public ResponseEntity<AlumnoCurso> createAlumnoCurso(@RequestBody AlumnoCurso alumnoCurso) {
        AlumnoCurso newAlumnoCurso = alumnoCursoService.save(alumnoCurso);
        return new ResponseEntity<AlumnoCurso>(newAlumnoCurso, HttpStatus.CREATED);
    }
    //modificar
    @PutMapping("/alumno_curso/{id}")
    public ResponseEntity<AlumnoCurso> updateAlumnoCurso(@RequestBody AlumnoCurso alumnoCurso, @PathVariable("id") Long id) {
        AlumnoCurso newAlumnoCurso = alumnoCursoService.save(alumnoCurso);
        return new ResponseEntity<AlumnoCurso>(newAlumnoCurso, HttpStatus.OK);
    }
    //eliminar
    @DeleteMapping("/alumno_curso/{id}")
    public ResponseEntity<HttpStatus> deleteAsesorCurso(@PathVariable("id") Long id) {
        alumnoCursoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
