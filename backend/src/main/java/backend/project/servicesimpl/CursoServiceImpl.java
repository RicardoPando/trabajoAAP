package backend.project.servicesimpl;
import backend.project.entities.Curso;
import backend.project.exceptions.IncompleteDataException;
import backend.project.exceptions.KeyRepeatedDataException;
import backend.project.exceptions.ResourceNotFoundException;

import backend.project.repositories.CursoRepository;
import backend.project.repositories.CursoRepository;
import backend.project.entities.Curso;
import backend.project.services.CursoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CursoServiceImpl implements CursoService{

    @Autowired
    CursoRepository cursoRepository;
    @Override
    public List<Curso> listAll() { return cursoRepository.findAll();
    }

    @Override
    public List<Curso> listByName(String name) {
        List<Curso> cursos = cursoRepository.findByNombreContaining(name);
        return cursos;
    }

    @Override
    public Curso findById(Long id) {
        Curso cursoFound = cursoRepository.findById(id).orElse(null);
        if (cursoFound == null) {
            throw new ResourceNotFoundException("There are no Curso with the id: "+String.valueOf(id));
        }
        return cursoFound;
    }

    @Override
    public Curso save(Curso curso) {
        if (curso.getNombre()==null || curso.getNombre().isEmpty()) {
            throw new IncompleteDataException("Curso name can not be null or empty");
        }
        List<Curso> cursoList= cursoRepository.findByNombreContaining(curso.getNombre());
        if (cursoList.size()>1 || (cursoList.size()==1 && !cursoList.get(0).getId().equals(curso.getId()))) {
            throw new KeyRepeatedDataException("Curso name can not be duplicated");
        }
        return cursoRepository.save(curso);
    }
    @Override
    public void delete(Long id) {
        Curso curso = findById(id);
        cursoRepository.delete(curso);

    }

    @Override
    public Curso update(Long id, Curso curso) {
        return null;
    }
}
