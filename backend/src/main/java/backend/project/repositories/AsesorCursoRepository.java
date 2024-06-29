package backend.project.repositories;
import backend.project.entities.Asesor;
import backend.project.entities.AsesorCurso;
import backend.project.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface AsesorCursoRepository extends JpaRepository<AsesorCurso, Long>{
    List<AsesorCurso> findByAsesor_Id(Long id);
    List<AsesorCurso> findByCurso_Id(Long id);
    List<AsesorCurso> findAllByNivelDominio(Integer nivelDominio);

    List<AsesorCurso> findAllByCarrera(String carrera);
    @Query("SELECT ac.curso FROM AsesorCurso ac WHERE ac.carrera = :carrera")
    List<Curso> findCursosByCarrera(@Param("carrera") String carrera);
}
