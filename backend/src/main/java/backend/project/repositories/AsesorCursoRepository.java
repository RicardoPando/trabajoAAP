package backend.project.repositories;
import backend.project.entities.AsesorCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface AsesorCursoRepository extends JpaRepository<AsesorCurso, Long>{
}
