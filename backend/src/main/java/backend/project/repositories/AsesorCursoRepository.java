package backend.project.repositories;
import backend.project.entities.AsesorCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface AsesorCursoRepository extends JpaRepository<AsesorCurso, Long>{
    List<AsesorCurso> findByAsesor_Id(Long id);
    List<AsesorCurso> findByCurso_Id(Long id);
    List<AsesorCurso> findAllByNivelDominio(Integer nivelDominio);
}
