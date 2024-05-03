package backend.project.services;
import backend.project.dtos.DTOAsesoriaSummary;
import backend.project.entities.Asesoria;



import java.util.List;

public interface AsesoriaService {
    public List<Asesoria> listAll();
    public List<Asesoria> findByAlumno_Id(Long id);
    public List<Asesoria> findByAsesor_Id(Long id);
    public List<Asesoria> findByCurso_Id(Long id);
    public Asesoria findById(Long id);
    public Asesoria save(Asesoria asesoria);
    public void delete(Long id);
    public List<DTOAsesoriaSummary> listAsesoriaSummary();
}
