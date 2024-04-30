package backend.project.repositories;
import backend.project.entities.Asesoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface AsesoriaRepository extends JpaRepository<Asesoria, Long>{
}
