package backend.project.servicesimpl;
import backend.project.exceptions.IncompleteDataException;
import backend.project.exceptions.KeyRepeatedDataException;
import backend.project.exceptions.ResourceNotFoundException;

import backend.project.repositories.HorarioRepository;
import backend.project.entities.Horario;
import backend.project.services.HorarioService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class HorarioServiceImpl implements HorarioService {
    @Override
    public List<Horario> listAll() {
        return null;
    }

    @Override
    public List<Horario> listByName(String name) {
        return null;
    }

    @Override
    public Horario findById(Long id) {
        return null;
    }

    @Override
    public Horario save(Horario horario) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
