package backend.project.servicesimplements;

import backend.project.entities.Alumno;
import backend.project.repositories.AlumnoRepository;
import backend.project.serviceinterfaces.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlumnoServiceImplement implements AlumnoService {
    @Autowired
    private AlumnoRepository aR;

    public void insert(Alumno alumno) {aR.save(alumno);}

    @Override
    public List<Alumno> list() {
        return aR.findAll();
    }

    @Override
    public void delete(int IDAlumno) {
        aR.deleteById(IDAlumno);
    }

    @Override
    public Alumno listarId(int IDAlumno) {
        return aR.findById(IDAlumno).orElse(new Alumno());
    }

    @Override
    public List<Alumno> findByFechaRegistro(LocalDate fechaRegistro) {
        return aR.findByFechaRegistro(fechaRegistro);
    }


}



