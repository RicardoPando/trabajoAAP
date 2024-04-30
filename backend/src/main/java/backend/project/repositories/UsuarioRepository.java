package backend.project.repositories;
import backend.project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<User, Long> {
}
