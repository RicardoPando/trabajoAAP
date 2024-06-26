package backend.project.services;
import backend.project.entities.CanalContacto;

import java.util.List;

public interface CanalContactoService {
    public List<CanalContacto> listAll();
    //no hay el parametro en la relacion
//    public List<CanalContacto> listByName(String name);

    public CanalContacto findById(Long id);

    public CanalContacto save(CanalContacto canalContacto);
    public void delete(Long id);

}
