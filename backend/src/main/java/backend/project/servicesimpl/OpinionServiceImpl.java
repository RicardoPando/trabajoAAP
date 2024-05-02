package backend.project.servicesimpl;
import backend.project.exceptions.IncompleteDataException;
import backend.project.exceptions.KeyRepeatedDataException;
import backend.project.exceptions.ResourceNotFoundException;

import backend.project.repositories.OpinionRepository;
import backend.project.entities.Opinion;
import backend.project.services.OpinionService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class OpinionServiceImpl implements OpinionService {
    @Override
    public List<Opinion> listAll() {
        return null;
    }

    @Override
    public List<Opinion> listByName(String name) {
        return null;
    }

    @Override
    public Opinion findById(Long id) {
        return null;
    }

    @Override
    public Opinion save(Opinion opinion) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
