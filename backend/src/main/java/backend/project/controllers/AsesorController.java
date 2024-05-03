package backend.project.controllers;
import backend.project.entities.Asesor;
import backend.project.services.AsesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")


public class AsesorController {

    @Autowired
    AsesorService asesorService;

    //http://localhost:8080/api/asesor

    //listar
    @GetMapping("/asesor")
    public ResponseEntity<List<Asesor>> getAllAsesor() {
        List<Asesor> asesorList = asesorService.listAll();
        return new ResponseEntity<List<Asesor>>(asesorList, HttpStatus.OK);
    }
    //listar por id
    @GetMapping("/asesor/{id}")
    public ResponseEntity<Asesor> geAsesorById(@PathVariable("id") Long id) {
        Asesor asesor = asesorService.findById(id);
        return new ResponseEntity<Asesor>(asesor, HttpStatus.OK);
    }
    //crear
    @PostMapping("/asesor")
    public ResponseEntity<Asesor> createAsesor(@RequestBody Asesor asesor) {
        Asesor newAsesor = asesorService.save(asesor);
        return new ResponseEntity<Asesor>(newAsesor, HttpStatus.CREATED);
    }
    //eliminar
    @DeleteMapping("/asesor/{id}")
    public ResponseEntity<HttpStatus> deleteAsesor(@PathVariable("id") Long id) {
        asesorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //modificar
    //Alternativa 1 -> Pasar el Id por la ruta
    @PutMapping("/asesor/{id}")
    public ResponseEntity<Asesor> updateAsesor(@RequestBody Asesor asesor, @PathVariable("id") Long id) {
        Asesor foundAsesor = asesorService.findById(id);
        if (asesor.getApellido()!=null) {
            foundAsesor.setApellido(asesor.getApellido());
        }
        if (asesor.getNombre()!=null) {
            foundAsesor.setNombre(asesor.getNombre());
        }
        if (asesor.getExperiencia()!=null) {
            foundAsesor.setAsesorias(asesor.getAsesorias());
        }
        if (asesor.getTarifa()!=null) {
            foundAsesor.setTarifa(asesor.getTarifa());
        }
        if (asesor.getAsesorCursos()!=null) {
            foundAsesor.setAsesorCursos(asesor.getAsesorCursos());
        }
        if (asesor.getHorarios()!=null) {
            foundAsesor.setHorarios(asesor.getHorarios());
        }
        if (asesor.getCanalContacto()!=null) {
            foundAsesor.setCanalContacto(asesor.getCanalContacto());
        }
        if (asesor.getAsesorias()!=null) {
            foundAsesor.setAsesorias(asesor.getAsesorias());
        }
        if (asesor.getUser()!=null) {
            foundAsesor.setUser(asesor.getUser());
        }

        Asesor newAsesor = asesorService.save(foundAsesor);
        return new ResponseEntity<Asesor>(newAsesor, HttpStatus.OK);
    }
}
