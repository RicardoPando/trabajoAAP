package backend.project.repositories;

import backend.project.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository <Alumno, Integer> {
    List<Alumno> findByFechaRegistro(LocalDate fechaRegistro);
}
