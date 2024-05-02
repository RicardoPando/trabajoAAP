package backend.project.repositories;
import backend.project.entities.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Time;
import java.util.List;
public interface HorarioRepository extends JpaRepository<Horario, Long>{
    List<Horario> findByDia(String dia);

    List<Horario> findByHoraInicio(Time horaInicio);
}
