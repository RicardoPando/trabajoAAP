package backend.project.controller;

import backend.project.dtos.AlumnoDTO;
import backend.project.entities.Alumno;
import backend.project.serviceinterfaces.AlumnoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    @Autowired
    private AlumnoService aS;

    @PreAuthorize("hasAuthority('Alumno')")
    @PostMapping
    public void registrar(@RequestBody AlumnoDTO dto){
        ModelMapper m = new ModelMapper();
        Alumno a = m.map(dto,Alumno.class);
        aS.insert(a);
    }
    @PutMapping
    public void modificar(@RequestBody AlumnoDTO dto){
        ModelMapper m = new ModelMapper();
        Alumno a = m.map(dto,Alumno.class);
        aS.insert(a);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id) {aS.delete(id);}
    @PreAuthorize("hasAuthority('Alumno')")
    @GetMapping("/{id}")
    public AlumnoDTO listarId(@PathVariable("id")Integer id) {
        ModelMapper m = new ModelMapper();
        AlumnoDTO dto = m.map(aS.listarId(id), AlumnoDTO.class);
        return dto;
    }
    @GetMapping
    public List<AlumnoDTO> listar(){
        return aS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, AlumnoDTO.class);
        }).collect(Collectors.toList());
    }
    public List<AlumnoDTO>buscar(@RequestBody Map<String, String> request){
        String fechaStr = request.get("fecha");
        LocalDate fecha = LocalDate.parse(fechaStr);
        return aS.findByFechaRegistro(fecha).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, AlumnoDTO.class);
        }).collect(Collectors.toList());

    }
}
