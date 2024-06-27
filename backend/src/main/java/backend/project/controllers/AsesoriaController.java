package backend.project.controllers;
import backend.project.dtos.DTOAsesoriaSummary;
import backend.project.entities.Asesor;
import backend.project.entities.Asesoria;
import backend.project.entities.AsesoriaEstado;
import backend.project.entities.Curso;
import backend.project.services.AsesoriaService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AsesoriaController {

    @Autowired
    AsesoriaService asesoriaService;
    //listar
    @GetMapping("/asesoria")
    public ResponseEntity<List<Asesoria>> getAllAsesoria() {
        List<Asesoria> asesoriaList = asesoriaService.listAll();
        return new ResponseEntity<List<Asesoria>>(asesoriaList, HttpStatus.OK);
    }
    @GetMapping("/asesoria/{id}")
    public ResponseEntity<Asesoria> getAsesoriaById(@PathVariable("id") Long id) {
        Asesoria asesoria = asesoriaService.findById(id);
        return new ResponseEntity<Asesoria>(asesoria, HttpStatus.OK);
    }
    //listar asesoria por id alumno
    @GetMapping("/asesoria/alumno/{id_alumno}")
    public ResponseEntity<List<Asesoria>> getAsesoriaByAlumno_Id(@PathVariable("id_alumno") Long id) {
        List<Asesoria> asesoriaList = asesoriaService.findByAlumno_Id(id);
        return new ResponseEntity<List<Asesoria>>(asesoriaList, HttpStatus.OK);
    }
    //listar asesoria por id curso
    @GetMapping("/asesoria/curso/{id_curso}")
    public ResponseEntity<List<Asesoria>> getAsesoriaByCurso_Id(@PathVariable("id_curso") Long id) {
        List<Asesoria> asesoriaList = asesoriaService.findByCurso_Id(id);
        return new ResponseEntity<List<Asesoria>>(asesoriaList, HttpStatus.OK);
    }
    //listar asesoria por id asesor
    @GetMapping("/asesoria/asesor/{id_asesor}")
    public ResponseEntity<List<Asesoria>> getAsesoriaByAsesor_Id(@PathVariable("id_asesor") Long id) {
        List<Asesoria> asesoriaList = asesoriaService.findByAsesor_Id(id);
        return new ResponseEntity<List<Asesoria>>(asesoriaList, HttpStatus.OK);
    }

    //create
    @PostMapping("/asesoria")
    public ResponseEntity<Asesoria> createAsesoria(@RequestBody Asesoria asesoria) {
        Asesoria newAsesoria = asesoriaService.save(asesoria);
        return new ResponseEntity<Asesoria>(newAsesoria, HttpStatus.CREATED);
    }
    //modificar
    @PutMapping("/asesoria/{id}")
    public ResponseEntity<Asesoria> updateAsesoria(@RequestBody Asesoria asesoria, @PathVariable("id") Long id) {
        Asesoria founAsesoria = asesoriaService.findById(id);
        if(asesoria.getFechaRegistro()!=null){
            founAsesoria.setFechaRegistro(asesoria.getFechaRegistro());
        }
        if(asesoria.getTarifaPactadas()!=null){
            founAsesoria.setTarifaPactadas(asesoria.getTarifaPactadas());
        }
        if(asesoria.getFechaRealizado()!=null){
            founAsesoria.setFechaRealizado(asesoria.getFechaRealizado());
        }
        if(asesoria.getCalificacionAsesor()!=null){
            founAsesoria.setCalificacionAsesor(asesoria.getCalificacionAsesor());
        }
        if(asesoria.getCalificacionAlumno()!=null){
            founAsesoria.setCalificacionAlumno(asesoria.getCalificacionAlumno());
        }
        if(asesoria.getEstado()!=null){
            founAsesoria.setEstado(asesoria.getEstado());
        }
        if(asesoria.getHoraInicio()!=null){
            founAsesoria.setHoraInicio(asesoria.getHoraInicio());
        }
        if(asesoria.getHoraFin()!=null){
            founAsesoria.setHoraFin(asesoria.getHoraFin());
        }
        if(asesoria.getDuracion()!=null){
            founAsesoria.setDuracion(asesoria.getDuracion());
        }
        if(asesoria.getMontoCobrado()!=null){
            founAsesoria.setMontoCobrado(asesoria.getMontoCobrado());
        }
        if(asesoria.getAsesor()!=null){
            founAsesoria.setAsesor(asesoria.getAsesor());
        }
        if(asesoria.getAlumno()!=null){
            founAsesoria.setAlumno(asesoria.getAlumno());
        }
        if(asesoria.getCurso()!=null){
            founAsesoria.setCurso(asesoria.getCurso());
        }
        
        Asesoria newAsesoria = asesoriaService.save(founAsesoria);
        return new ResponseEntity<Asesoria>(newAsesoria, HttpStatus.OK);
    }
    //eliminar
    @DeleteMapping("/asesoria/{id}")
    public ResponseEntity<HttpStatus> deleteAsesoria(@PathVariable("id") Long id) {
        asesoriaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/asesoria/summary")
    public ResponseEntity<List<DTOAsesoriaSummary>> getAsesoriaSummary() {
        List<DTOAsesoriaSummary> dtoAsesoriaSummaryList = asesoriaService.listAsesoriaSummary();
        return new ResponseEntity<List<DTOAsesoriaSummary>>(dtoAsesoriaSummaryList, HttpStatus.OK);
    }
}
