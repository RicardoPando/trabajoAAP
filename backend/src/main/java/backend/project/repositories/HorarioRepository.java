package backend.project.repositories;
import backend.project.entities.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Time;
import java.util.List;
public interface HorarioRepository extends JpaRepository<Horario, Long>{
    @Query(value="SELECT * FROM Horario WHERE dia=?1" , nativeQuery = true)
    List<Horario> findByDia(String dia);

    @Query(value="SELECT * FROM Horario WHERE horaInicio=?1" , nativeQuery = true)
    List<Horario> findByHoraInicio(Time horaInicio);
}
