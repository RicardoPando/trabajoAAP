package backend.project.repositories;
import backend.project.entities.CanalContacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface CanalContactoRepository extends JpaRepository<CanalContacto, Long>{

    @Query(value = "SELECT * FROM CanalContacto WHERE telefono = :telefono", nativeQuery = true)
    List<CanalContacto> findByTelefono(String telefono);

}
