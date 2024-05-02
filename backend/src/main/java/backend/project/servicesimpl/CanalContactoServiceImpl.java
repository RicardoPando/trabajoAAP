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
    @Autowired
    CanalContactoRepository canalContactoRepository;
    @Override
    public List<CanalContacto> listAll() {
        return canalContactoRepository.findAll();
    }

    //no hay el parametro nombre en la relacion
//    @Override
//    public List<CanalContacto> listByName(String name) {
//        return null;
//    }
    @Override
    public CanalContacto findById(Long id) {
        CanalContacto canalContactoFound = canalContactoRepository.findById(id).orElse(null);
        if (canalContactoFound == null) {
            throw new ResourceNotFoundException("There are no Canal Contacto with the id: "+String.valueOf(id));
        }
        return canalContactoFound;
    }

    @Override
    public CanalContacto save(CanalContacto canalContacto) {
        if (canalContacto.getTelefono()==null || canalContacto.getTelefono().isEmpty()) {
            throw new IncompleteDataException("Canal Contacto telefono can not be null or empty");
        }
        List<CanalContacto> canalContactoList= canalContactoRepository.findByTelefono(canalContacto.getTelefono());
        if (canalContactoList.size()>1 || (canalContactoList.size()==1 && !canalContactoList.get(0).getId().equals(canalContacto.getId())) ) {
            throw new KeyRepeatedDataException("Canal Contacto telefono can not be duplicated");
        }

        return canalContactoRepository.save(canalContacto);
    }

    @Override
    public void delete(Long id) {
        CanalContacto canalContacto = findById(id);
        canalContactoRepository.delete(canalContacto);
    }
}
