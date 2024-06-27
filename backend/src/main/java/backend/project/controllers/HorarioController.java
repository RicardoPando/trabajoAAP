package backend.project.controllers;
import backend.project.entities.Horario;
import backend.project.services.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class HorarioController {
    @Autowired
    HorarioService horarioService;

    //http://localhost:8080/api/horario

    //listar
    @GetMapping("/horario")
    public ResponseEntity<List<Horario>> getAllHorario() {
        List<Horario> horarioList = horarioService.listAll();
        return new ResponseEntity<List<Horario>>(horarioList, HttpStatus.OK);
    }
    //listar por id
    @GetMapping("/horario/{id}")
    public ResponseEntity<Horario> geHorarioById(@PathVariable("id") Long id) {
        Horario horario = horarioService.findById(id);
        return new ResponseEntity<Horario>(horario, HttpStatus.OK);
    }
    //listar por id de asesor
    @GetMapping("/horario/asesor/{id}")
    public ResponseEntity<List<Horario>> getHorariosPorAsesorId(@PathVariable("id") Long id) {
        List<Horario> horario = horarioService.findByAsesorId(id);
        return new ResponseEntity<List<Horario>>(horario, HttpStatus.OK);
    }
    //crear
    @PostMapping("/horario")
    public ResponseEntity<Horario> createHorario(@RequestBody Horario horario) {
        Horario newHorario = horarioService.save(horario);
        return new ResponseEntity<Horario>(newHorario, HttpStatus.CREATED);
    }
    //eliminar
    @DeleteMapping("/horario/{id}")
    public ResponseEntity<HttpStatus> deleteHorario(@PathVariable("id") Long id) {
        horarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //modificar
    //Alternativa 1 -> Pasar el Id por la ruta
    @PutMapping("/horario/{id}")
    public ResponseEntity<Horario> updateHorario(@RequestBody Horario horario, @PathVariable("id") Long id) {
        Horario foundHorario = horarioService.findById(id);
        if (horario.getDia()!=null) {
            foundHorario.setDia(horario.getDia());
        }
        if (horario.getHoraInicio()!=null) {
            foundHorario.setHoraInicio(horario.getHoraInicio());
        }
        if (horario.getHoraFin()!=null) {
            foundHorario.setHoraFin(horario.getHoraFin());
        }
        if (horario.getAsesor()!=null) {
            foundHorario.setAsesor(horario.getAsesor());
        }
        Horario newHorario = horarioService.save(foundHorario);
        return new ResponseEntity<Horario>(newHorario, HttpStatus.OK);
    }
}
