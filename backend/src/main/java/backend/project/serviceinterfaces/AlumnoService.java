package backend.project.serviceinterfaces;

import backend.project.entities.Alumno;

import java.time.LocalDate;
import java.util.List;

public interface AlumnoService {

    public void insert(Alumno alumno);

    public List<Alumno> list();

    public void delete(int IDAlumno);

    public Alumno  listarId(int IDAlumno);

    List<Alumno>findByFechaRegistro(LocalDate fechaRegistro);


}
