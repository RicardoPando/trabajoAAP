package backend.project.repositories;
import backend.project.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
