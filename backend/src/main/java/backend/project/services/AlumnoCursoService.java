package backend.project.services;
import backend.project.entities.Alumno;
import backend.project.entities.AlumnoCurso;
import backend.project.entities.Curso;

import java.util.List;

public interface AlumnoCursoService {
    public List<AlumnoCurso> listAll();
    public List<AlumnoCurso> findByAlumno_Id(Long id);
    public List<AlumnoCurso> findByCurso_Id(Long id);
    public List<Alumno>  findAlumno_ByCurso_Id(Long id);
    public List<Curso>  findCurso_ByAlumno_Id(Long id);
    public AlumnoCurso findById(Long id);
    public AlumnoCurso save(AlumnoCurso alumnoCurso);
    public void delete(Long id);

}
