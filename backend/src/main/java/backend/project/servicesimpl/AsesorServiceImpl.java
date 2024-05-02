package backend.project.servicesimpl;
import backend.project.exceptions.IncompleteDataException;
import backend.project.exceptions.KeyRepeatedDataException;
import backend.project.exceptions.ResourceNotFoundException;

import backend.project.repositories.AsesorRepository;
import backend.project.entities.Asesor;
import backend.project.services.AsesorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service

public class AsesorServiceImpl implements AsesorService {


    @Override
    public List<Asesor> listAll() {
        return null;
    }

    @Override
    public List<Asesor> listByName(String name) {
        return null;
    }

    @Override
    public Asesor findById(Long id) {
        return null;
    }

    @Override
    public Asesor save(Asesor asesor) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
