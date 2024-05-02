package backend.project.services;
import backend.project.entities.Opinion;

import java.util.List;

public interface OpinionService {
    public List<Opinion> listAll();
    public List<Opinion> listByName(String name);

    public Opinion findById(Long id);

    public Opinion save(Opinion opinion);
    public void delete(Long id);

}
