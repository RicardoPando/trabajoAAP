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

//    private boolean isOverlapping(List<LocalTime> start1, List<LocalTime> end1, List<LocalTime> start2, List<LocalTime> end2) {
//        for (int i = 0; i < start1.size(); i++) {
//            for (int j = 0; j < start2.size(); j++) {
//                if (isOverlapping(start1.get(i), end1.get(i), start2.get(j), end2.get(j))) {
//                    return true; // Hay superposición
//                }
//            }
//        }
//        return false; // No hay superposición en ninguno de los intervalos
//    }
//    private boolean isOverlapping(LocalTime start1, LocalTime end1, LocalTime start2, LocalTime end2) {
//        // Verifica si los intervalos [start1, end1] y [start2, end2] se superponen
//        return start1.isBefore(end2) && start2.isBefore(end1);
//    }
//    private boolean isNewInicioValid(List<Horario> horarioList, Horario newHorario) {
//        for (Horario existingHorario : horarioList) {
//            if (existingHorario.getId() != null && !existingHorario.getId().equals(newHorario.getId()) &&
//                    existingHorario.getAsesor().getId().equals(newHorario.getAsesor().getId())) {
//
//                // Verificar superposición de horarios
//                if (isOverlapping(existingHorario.getHorasInicio(), existingHorario.getHorasFin(),
//                        newHorario.getHorasInicio(), newHorario.getHorasFin())) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
    @Override
    public Horario save(Horario horario) {

//        if (horario.getDia()==null || horario.getDia().isEmpty()) {
//            throw new IncompleteDataException("Horario dia can not be null or empty");
//        }
//        List<Horario> horarioList= horarioRepository.findByDia(horario.getDia());
//        if (!horarioList.isEmpty() && !isNewInicioValid(horarioList, horario)) {
//            throw new KeyRepeatedDataException("La nueva hora de inicio no puede estar en el rango de otra hora inicio y fin anteriormente registrada");
//        }
        return horarioRepository.save(horario);
    }

    @Override
    public void delete(Long id) {
        Horario horario = findById(id);
        horarioRepository.delete(horario);
    }
}
