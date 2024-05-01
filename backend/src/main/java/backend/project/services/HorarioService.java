package backend.project.services;
import backend.project.entities.Horario;

import java.util.List;

public interface HorarioService {
    public List<Horario> listAll();
    public List<Horario> listByName(String name);

    public Horario findById(Long id);

    public Horario save(Horario horario);
    public void delete(Long id);

}
