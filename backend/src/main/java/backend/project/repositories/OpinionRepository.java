package backend.project.repositories;
import backend.project.entities.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface OpinionRepository extends JpaRepository<Opinion, Long> {

}
