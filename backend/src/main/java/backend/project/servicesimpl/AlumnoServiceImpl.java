package backend.project.servicesimpl;
import backend.project.exceptions.IncompleteDataException;
import backend.project.exceptions.KeyRepeatedDataException;
import backend.project.exceptions.ResourceNotFoundException;

import backend.project.repositories.AlumnoRepository;
import backend.project.entities.Alumno;
import backend.project.services.AlumnoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service

public class AlumnoServiceImpl implements AlumnoService{
    @Override
    public List<Alumno> listAll() {
        return null;
    }

    @Override
    public List<Alumno> listByName(String name) {
        return null;
    }

    @Override
    public Alumno findById(Long id) {
        return null;
    }

    @Override
    public Alumno save(Alumno alumno) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
