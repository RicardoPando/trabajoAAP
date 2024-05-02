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

    @Autowired
    OpinionRepository opinionRepository;
    @Override
    public List<Opinion> listAll() { return opinionRepository.findAll();
    }
// no tiene el parametro name la relacion
//    @Override
//    public List<Opinion> listByName(String name) {
//        return null;
//    }

    @Override
    public Opinion findById(Long id) {
        Opinion opinionFound = opinionRepository.findById(id).orElse(null);
        if (opinionFound == null) {
            throw new ResourceNotFoundException("There are no Opinion with the id: "+String.valueOf(id));
        }
        return opinionFound;
    }

    @Override
    public Opinion save(Opinion opinion) {

        if (opinion.getComentario()==null || opinion.getComentario().isEmpty()) {
            throw new IncompleteDataException("Opinion coment can not be null or empty");
        }
        return opinionRepository.save(opinion);
    }
    @Override
    public void delete(Long id) {
        Opinion opinion = findById(id);
        opinionRepository.delete(opinion);

    }
}
