package backend.project.servicesimpl;
import backend.project.entities.Asesor;
import backend.project.exceptions.IncompleteDataException;
import backend.project.exceptions.KeyRepeatedDataException;
import backend.project.exceptions.ResourceNotFoundException;

import backend.project.repositories.AsesorRepository;
import backend.project.services.AsesorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service

public class AsesorServiceImpl implements AsesorService {

    @Autowired
    AsesorRepository asesorRepository;
    @Override
    public List<Asesor> listAll() { return asesorRepository.findAll();
    }
    @Override
    public List<Asesor> listByName(String name) {
        List<Asesor> asesores = asesorRepository.findByNombreContaining(name);
        return asesores;
    }

    @Override
    public Asesor findById(Long id) {
        Asesor asesorFound = asesorRepository.findById(id).orElse(null);
        if (asesorFound == null) {
            throw new ResourceNotFoundException("There are no Asesor with the id: "+String.valueOf(id));
        }
        return asesorFound;
    }

    @Override
    public Asesor findByNombreContaining(String nombre) {
        List<Asesor> asesores = asesorRepository.findByNombreContaining(nombre);
        if (asesores.isEmpty()) {
            throw new ResourceNotFoundException("There are no Asesores with the name containing: " + nombre);
        }
        // En caso de encontrar múltiples coincidencias por nombre,
        // puede devolver el primer elemento o manejarlo según su lógica de negocio
        return asesores.get(0);
    }

    @Override
    public Asesor save(Asesor asesor) {
        if (asesor.getNombre()==null || asesor.getNombre().isEmpty()) {
            throw new IncompleteDataException("Asesor name can not be null or empty");
        }
        List<Asesor> asesorList= asesorRepository.findByNombreContaining(asesor.getNombre());
        if (asesorList.size()>1 || (asesorList.size()==1 &&
                (!asesorList.get(0).getId().equals(asesor.getId()) &&
                        asesorList.get(0).getApellido().equals(asesor.getApellido())))) {
            throw new KeyRepeatedDataException("Asesor name and lastname can not be duplicated");
        }
        return asesorRepository.save(asesor);
    }
    @Override
    public void delete(Long id) {
        Asesor asesor = findById(id);
        asesorRepository.delete(asesor);

    }
}
