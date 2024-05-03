package backend.project.repositories;
import backend.project.entities.Alumno;
import backend.project.entities.AlumnoCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface AlumnoCursoRepository extends JpaRepository<AlumnoCurso, Long>{
    List<AlumnoCurso> findByCurso_Id(Long id);

    List<AlumnoCurso> findByAlumno_Id(Long id);
}
