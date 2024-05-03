package backend.project.repositories;
import backend.project.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{
    List<Alumno> findByNombreContaining(String nombre);
}
