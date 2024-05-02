package backend.project.repositories;
import backend.project.entities.CanalContacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface CanalContactoRepository extends JpaRepository<CanalContacto, Long>{

    List<CanalContacto> findByTelefono(String telefono);
}
