package backend.project.repositories;
import backend.project.entities.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
public interface HorarioRepository extends JpaRepository<Horario, Long>{
    //List<Horario> findByDia(String dia);

    @Query("SELECT h FROM Horario h WHERE h.dia = :dia")
    List<Horario> findByDia(@Param("dia") String dia);

    @Query(value="SELECT * FROM Horario WHERE horaInicio=?1" , nativeQuery = true)
    List<Horario> findByHoraInicio(LocalTime horaInicio);

    List<Horario> findByAsesorId(Long id);
}
