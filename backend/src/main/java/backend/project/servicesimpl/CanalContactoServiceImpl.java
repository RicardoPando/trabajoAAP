package backend.project.servicesimpl;
import backend.project.exceptions.IncompleteDataException;
import backend.project.exceptions.KeyRepeatedDataException;
import backend.project.exceptions.ResourceNotFoundException;

import backend.project.repositories.CanalContactoRepository;
import backend.project.entities.CanalContacto;
import backend.project.services.CanalContactoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CanalContactoServiceImpl implements CanalContactoService {
    @Override
    public List<CanalContacto> listAll() {
        return null;
    }

    @Override
    public List<CanalContacto> listByName(String name) {
        return null;
    }

    @Override
    public CanalContacto findById(Long id) {
        return null;
    }

    @Override
    public CanalContacto save(CanalContacto canalContacto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
