package backend.project.repositories;
import backend.project.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByNombreContaining(String nombre);
}
