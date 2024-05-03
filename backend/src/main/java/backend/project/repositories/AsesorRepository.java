package backend.project.repositories;
import backend.project.entities.Asesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface AsesorRepository extends JpaRepository<Asesor, Long> {
    List<Asesor> findByNombreContaining(String nombre);
}
