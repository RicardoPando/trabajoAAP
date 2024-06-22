package backend.project.repositories;

import backend.project.entities.Authority;
import backend.project.entities.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    public Authority findByName(AuthorityName name);
}
