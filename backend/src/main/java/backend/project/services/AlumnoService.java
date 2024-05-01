package backend.project.services;
import backend.project.entities.Alumno;

import java.util.List;

public interface AlumnoService {
    public List<Alumno> listAll();
    public List<Alumno> listByName(String name);

    public Alumno findById(Long id);

    public Alumno save(Alumno alumno);
    public void delete(Long id);

}
