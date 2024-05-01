package backend.project.services;
import backend.project.entities.Alumno;
import backend.project.entities.Asesor;
import backend.project.entities.Asesoria;
import backend.project.entities.Curso;


import java.util.List;

public interface AsesoriaService {
    public List<Asesoria> listAll();
    public List<Asesoria> findByAlumno_Id(Long id);
    public List<Asesoria> findByAsesor_Id(Long id);
    public List<Asesoria> findByCurso_Id(Long id);
    public List<Asesoria> listByName(String name);
    public List<Alumno>  findAsesoria_ByAlumno_Id(Long id);
    public List<Curso>  findAsesoria_ByCurso_Id(Long id);
    public List<Asesor>  findAsesoria_ByAsesor_Id(Long id);
    public Asesoria findById(Long id);
    public Asesoria save(Asesoria asesoria);
    public void delete(Long id);

}
