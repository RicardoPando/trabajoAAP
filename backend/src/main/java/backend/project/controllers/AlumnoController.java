package backend.project.controllers;


import backend.project.entities.Alumno;
import backend.project.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    //http://localhost:8080/api/alumno

    //listar
    @GetMapping("/alumno")
    public ResponseEntity<List<Alumno>> getAllAlumno() {
        List<Alumno> alumnoList = alumnoService.listAll();
        return new ResponseEntity<List<Alumno>>(alumnoList, HttpStatus.OK);
    }
    //listar por id
    @GetMapping("/alumno/{id}")
    public ResponseEntity<Alumno> geAlumnoById(@PathVariable("id") Long id) {
        Alumno alumno = alumnoService.findById(id);
        return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
    }
    //crear
    @PostMapping("/alumno")
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno) {
        Alumno newAlumno = alumnoService.save(alumno);
        return new ResponseEntity<Alumno>(newAlumno, HttpStatus.CREATED);
    }
    //eliminar
    @DeleteMapping("/alumno/{id}")
    public ResponseEntity<HttpStatus> deleteAlumno(@PathVariable("id") Long id) {
        alumnoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //modificar
    //Alternativa 1 -> Pasar el Id por la ruta
    @PutMapping("/alumno/{id}")
    public ResponseEntity<Alumno> updateAlumno(@RequestBody Alumno alumno, @PathVariable("id") Long id) {
        Alumno foundAlumno = alumnoService.findById(id);
        if (alumno.getApellido()!=null) {
            foundAlumno.setApellido(alumno.getApellido());
        }
        if (alumno.getNombre()!=null) {
            foundAlumno.setNombre(alumno.getNombre());
        }
        if (alumno.getAlumnosCursos()!=null) {
            foundAlumno.setAlumnosCursos(alumno.getAlumnosCursos());
        }
        if (alumno.getCiclo()!=null) {
            foundAlumno.setCiclo(alumno.getCiclo());
        }
        if (alumno.getAsesorias()!=null) {
            foundAlumno.setAsesorias(alumno.getAsesorias());
        }
        Alumno newAlumno = alumnoService.save(foundAlumno);
        return new ResponseEntity<Alumno>(newAlumno, HttpStatus.OK);
    }
}
