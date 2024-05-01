package backend.project.services;
import backend.project.entities.Asesor;

import java.util.List;
public interface AsesorService {
    public List<Asesor> listAll();
    public List<Asesor> listByName(String name);

    public Asesor findById(Long id);

    public Asesor save(Asesor asesor);
    public void delete(Long id);

}
