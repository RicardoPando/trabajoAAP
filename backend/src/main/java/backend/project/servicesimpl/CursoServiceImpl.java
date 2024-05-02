package backend.project.servicesimpl;
import backend.project.exceptions.IncompleteDataException;
import backend.project.exceptions.KeyRepeatedDataException;
import backend.project.exceptions.ResourceNotFoundException;

import backend.project.repositories.CursoRepository;
import backend.project.entities.Curso;
import backend.project.services.CursoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CursoServiceImpl implements CursoService{


    @Override
    public List<Curso> listAll() {
        return null;
    }

    @Override
    public List<Curso> listByName(String name) {
        return null;
    }

    @Override
    public Curso findById(Long id) {
        return null;
    }

    @Override
    public Curso save(Curso curso) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
