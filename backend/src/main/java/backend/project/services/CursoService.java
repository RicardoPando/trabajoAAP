package backend.project.services;
import backend.project.entities.Curso;

import java.util.List;
public interface CursoService {
    public List<Curso> listAll();
    public List<Curso> listByName(String name);
    public Curso findById(Long id);

    public Curso save(Curso curso);
    public void delete(Long id);
    public Curso update(Long id,Curso curso);
}
