package backend.project.repositories;

import backend.project.entities.DetalleHorario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleHorarioRepository extends JpaRepository<DetalleHorario,Long> {
    List<DetalleHorario> findDetalleHorariosByHorario_Asesor_Id(Long AsesorId);
}
