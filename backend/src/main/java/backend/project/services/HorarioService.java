package backend.project.services;
import backend.project.entities.Asesor;
import backend.project.entities.Horario;

import java.util.List;

public interface HorarioService {
    public List<Horario> listAll();
    // no tiene el parametro nombre en la relacion
//    public List<Horario> listByName(String name);

    public Horario findById(Long id);
    public List<Horario> findByAsesorId(Long id);

    public Horario save(Horario horario);
    public void delete(Long id);

}
