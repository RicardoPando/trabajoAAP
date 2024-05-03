package backend.project.services;
import backend.project.entities.Asesor;
import backend.project.entities.AsesorCurso;
import backend.project.entities.Curso;

import java.util.List;

public interface AsesorCursoService {
    public List<AsesorCurso> listAll();
    public List<AsesorCurso> findByAsesor_Id(Long id);
    public List<AsesorCurso> findByCurso_Id(Long id);
    public List<Asesor>  findAsesor_ByCurso_Id(Long id);
    public List<Curso>  findCurso_ByAsesor_Id(Long id);
    public AsesorCurso findById(Long id);
    public AsesorCurso save(AsesorCurso asesorCurso);
    public void delete(Long id);

}
