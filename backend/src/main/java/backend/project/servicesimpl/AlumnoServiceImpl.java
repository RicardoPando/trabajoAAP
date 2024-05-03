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

    @Autowired
    AlumnoRepository alumnoRepository;
    @Override
    public List<Alumno> listAll() { return alumnoRepository.findAll();
    }

    @Override
    public List<Alumno> listByName(String name) {
        List<Alumno> alumnos = alumnoRepository.findByNombreContaining(name);
        return alumnos;
    }

    @Override
    public Alumno findById(Long id) {
        Alumno alumnoFound = alumnoRepository.findById(id).orElse(null);
        if (alumnoFound == null) {
            throw new ResourceNotFoundException("There are no Alumno with the id: "+String.valueOf(id));
        }
        return alumnoFound;
    }

    @Override
    public Alumno save(Alumno alumno) {
        if (alumno.getNombre()==null || alumno.getNombre().isEmpty()) {
            throw new IncompleteDataException("Alumno name can not be null or empty");
        }
        List<Alumno> alumnoList= alumnoRepository.findByNombreContaining(alumno.getNombre());
        if (alumnoList.size()>1 || (alumnoList.size()==1 &&
                (!alumnoList.get(0).getId().equals(alumno.getId()) &&
                        alumnoList.get(0).getApellido().equals(alumno.getApellido())))) {
            throw new KeyRepeatedDataException("Alumno name and lastname can not be duplicated");
        }
        return alumnoRepository.save(alumno);
    }
    @Override
    public void delete(Long id) {
        Alumno alumno = findById(id);
        alumnoRepository.delete(alumno);

    }
}
