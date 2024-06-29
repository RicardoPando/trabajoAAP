package backend.project.controllers;

import backend.project.entities.DetalleHorario;
import backend.project.entities.Horario;
import backend.project.services.DetalleHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DetalleHorarioControler {
    @Autowired
    DetalleHorarioService detalleHorarioService;

    @GetMapping("/detalleHorario")
    public ResponseEntity<List<DetalleHorario>> getAllHorarioDetalle() {
        List<DetalleHorario> horarios = detalleHorarioService.getAllDetallesHorario();
        return new ResponseEntity<>(horarios, HttpStatus.OK);
    }

    @GetMapping("/detalleHorario/{id}")
    public ResponseEntity<DetalleHorario> getHorarioById(@PathVariable Long id) {
        DetalleHorario detalleHorario = detalleHorarioService.getDetalleHorarioById(id);
        return new ResponseEntity<DetalleHorario>(detalleHorario, HttpStatus.OK);
    }
    @GetMapping("/detalleHorario/asesor/{asesorId}")
    public ResponseEntity<List<DetalleHorario>> getDetallesHorarioByAsesorId(@PathVariable Long asesorId) {
        List<DetalleHorario> detallesHorario = detalleHorarioService.getDetalleHorarioByAsesorId(asesorId);
        return new ResponseEntity<>(detallesHorario, HttpStatus.OK);
    }

    @PostMapping("/detalleHorario")
    public ResponseEntity<DetalleHorario> createHorario(@RequestBody DetalleHorario horario) {
        DetalleHorario newDetalleHorario = detalleHorarioService.save(horario);
        return new ResponseEntity<DetalleHorario>(newDetalleHorario, HttpStatus.CREATED);
    }

    @DeleteMapping("/detalleHorario/{id}")
    public ResponseEntity<Void> deleteHorario(@PathVariable Long id) {
        detalleHorarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
