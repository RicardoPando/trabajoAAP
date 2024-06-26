package backend.project.servicesimpl;
import backend.project.dtos.DTOAsesoriaSummary;
import backend.project.entities.*;
import backend.project.exceptions.ResourceNotFoundException;
import backend.project.repositories.*;
import backend.project.services.AsesoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AsesoriaServiceImpl implements AsesoriaService {
    @Autowired
    AlumnoRepository alumnoRepository;
    @Autowired
    AsesorRepository asesorRepository;
    @Autowired
    AsesoriaRepository asesoriaRepository;
    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    private OpinionRepository opinionRepository;
    @Autowired
    private HorarioRepository horarioRepository;


    @Override
    public List<Asesoria> listAll() {

        return asesoriaRepository.findAll();
    }

    @Override
    public List<Asesoria> findByAlumno_Id(Long id) {
        List<Asesoria> asesorias = asesoriaRepository.findByAlumno_Id(id);
        for (Asesoria a : asesorias) {
            //elimina la bidireccionalidad
            a.getAsesor().setAsesorias(null);
            a.getCurso().setAsesorias(null);
            a.getAlumno().setAsesorias(null);
        }
        return asesorias;
    }

    @Override
    public List<Asesoria> findByAsesor_Id(Long id) {
        List<Asesoria> asesorias = asesoriaRepository.findByAsesor_Id(id);
        for (Asesoria a : asesorias) {
            //elimina la bidireccionalidad
            a.getAsesor().setAsesorias(null);
            a.getCurso().setAsesorias(null);
            a.getAlumno().setAsesorias(null);
        }
        return asesorias;
    }
    @Override
    public List<Asesoria> findByCurso_Id(Long id) {
        List<Asesoria> asesorias = asesoriaRepository.findByCurso_Id(id);
        for (Asesoria a : asesorias) {
            //elimina la bidireccionalidad
            a.getAsesor().setAsesorias(null);
            a.getCurso().setAsesorias(null);
            a.getAlumno().setAsesorias(null);
        }
        return asesorias;
    }

    @Override
    public Asesoria findById(Long id) {
        Asesoria asesoriaFound = asesoriaRepository.findById(id).orElse(null);
        if (asesoriaFound == null) {
            throw new ResourceNotFoundException("There are no Asesoria with the id: " + String.valueOf(id));
        }
        return asesoriaFound;
    }
    public Boolean estaEnRango(Date inicio, Date fin, Date newInicio){
        if(inicio.compareTo(newInicio)<=0 && newInicio.compareTo(fin)<=0)
        {
            return true;
        }
        return false;
    }
    @Override
    public Asesoria save(Asesoria asesoria) {

        //List<Asesoria> asesorias = asesoriaRepository.findByAsesor_Id(asesoria.getAsesor().getId());

        Alumno alumno = alumnoRepository.findById(asesoria.getAlumno().getId()).get();
        Curso curso = cursoRepository.findById(asesoria.getCurso().getId()).get();
        Asesor asesor = asesorRepository.findById(asesoria.getAsesor().getId()).get();

        List<LocalTime> horaInicio = asesor.getHorarios().stream().
                map(Horario::getHoraInicio).toList();

        List<LocalTime> horaFin = asesor.getHorarios().stream().
                map(Horario::getHoraFin).toList();

        for(LocalTime hInicio :horaInicio){
            asesoria.setHoraInicio(hInicio);
        }
        for(LocalTime hFin :horaFin){
            asesoria.setHoraFin(hFin);
        }

        asesoria.setAlumno(alumno);
        asesoria.setCurso(curso);
        asesoria.setAsesor(asesor);

//        if (asesorias.size()>1){
//            for (Asesoria a : asesorias) {
//                if ( asesoria.getFechaRealizado().equals(a.getFechaRealizado()) &&
//                            estaEnRango(a.getHoraInicio(),a.getHoraFin(),asesoria.getHoraInicio()))
//                {
//                    throw new KeyRepeatedDataException("el asesor ya cuenta con una asesoria con el horario registrada");
//                }
//            }
//        }

        Asesoria newAsesoria = asesoriaRepository.save(asesoria);
        newAsesoria.getAsesor().setHorarios(null);
        newAsesoria.getAsesor().setAsesorias(null);
        newAsesoria.getAsesor().setAsesorCursos(null);
        return asesoriaRepository.save(asesoria);
    }

    @Override
    public void delete(Long id) {
        Asesoria asesoria = findById(id);
        asesoriaRepository.delete(asesoria);
    }
    @Override
    public List<DTOAsesoriaSummary> listAsesoriaSummary(){
        List<Asesoria> asesorias = asesoriaRepository.findAll();
        List<DTOAsesoriaSummary> asesoriaSummaryList = new ArrayList<>();
        for (Asesoria a: asesorias) {
            String asesorName = a.getAsesor().getNombre();
            String alumnoName = a.getAlumno().getNombre();
            String cursoName = a.getCurso().getNombre();
            Date fecha = a.getFechaRealizado();
            Integer duracion= a.getDuracion();
            String opinion = a.getAsesor().getUser().getOpinion() != null ? a.getAsesor().getUser().getOpinion().toString() : null;
            DTOAsesoriaSummary dtoAsesoriaSummary = new DTOAsesoriaSummary(asesorName,alumnoName,cursoName,fecha,duracion,opinion);
            asesoriaSummaryList.add(dtoAsesoriaSummary);
        }

        return asesoriaSummaryList;

    }
}
