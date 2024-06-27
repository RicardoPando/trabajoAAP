package backend.project.servicesimpl;
import backend.project.entities.Asesor;
import backend.project.exceptions.IncompleteDataException;
import backend.project.exceptions.KeyRepeatedDataException;
import backend.project.exceptions.ResourceNotFoundException;

import backend.project.repositories.AsesorRepository;
import backend.project.repositories.HorarioRepository;
import backend.project.entities.Horario;
import backend.project.services.HorarioService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
@Service
public class HorarioServiceImpl implements HorarioService {
    @Autowired
    HorarioRepository horarioRepository;
    AsesorRepository asesorRepository;
    @Override
    public List<Horario> listAll() {
        return horarioRepository.findAll();
    }

    //no tiene el parametro nombre en la relacion
//    @Override
//    public List<Horario> listByName(String name) {
//
//        return null;
//    }

    @Override
    public Horario findById(Long id) {
        Horario horarioFound = horarioRepository.findById(id).orElse(null);
        if (horarioFound == null) {
            throw new ResourceNotFoundException("There are no Horario with the id: "+String.valueOf(id));
        }
        return horarioFound;
    }

    @Override
    public List<Horario> findByAsesorId(Long id) {
        return horarioRepository.findByAsesorId(id);
    }

    public boolean isNewInicioValid(LocalTime inicio, LocalTime fin, LocalTime newInicio) {
        return newInicio.isBefore(inicio) || newInicio.isAfter(fin);
    }

    @Override
    public Horario save(Horario horario) {

        if (horario.getDia()==null || horario.getDia().isEmpty()) {
            throw new IncompleteDataException("Horario dia can not be null or empty");
        }
        List<Horario> horarioList= horarioRepository.findByDia(horario.getDia());
        if (horarioList.size()>1 || (horarioList.size()==1 &&
                (!horarioList.get(0).getId().equals(horario.getId()) && (
                        horarioList.get(0).getAsesor().getId().equals(horario.getAsesor().getId()) &&
                        horarioList.get(0).getDia().equals(horario.getDia()) &&
                                !isNewInicioValid(horarioList.get(0).getHoraInicio(),horarioList.get(0).getHoraFin(),horario.getHoraInicio())
                        )))) {
            throw new KeyRepeatedDataException("la nueva hora de inicio no puede estar en el rango de otra hora inicio y fin anteriormente registrada");
        }

        return horarioRepository.save(horario);
    }

    @Override
    public void delete(Long id) {
        Horario horario = findById(id);
        horarioRepository.delete(horario);
    }
}
