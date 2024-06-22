package backend.project.servicesimpl;
import backend.project.entities.*;
import backend.project.exceptions.ResourceNotFoundException;
import backend.project.repositories.AlumnoRepository;
import backend.project.repositories.AsesorRepository;
import backend.project.repositories.AsesoriaRepository;
import backend.project.repositories.CursoRepository;
import backend.project.services.AsesoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AsesoriaServiceImpl implements AsesoriaService{
    @Autowired
    AlumnoRepository alumnoRepository;
    @Autowired
    AsesorRepository asesorRepository;
    @Autowired
    AsesoriaRepository asesoriaRepository;
    @Autowired
    CursoRepository cursoRepository;

    @Override
    public List<Asesoria> listAll() {
        return asesoriaRepository.findAll();
    }
    @Override
    public List<Asesoria> findByAlumno_Id(Long id) {
        List<Asesoria> asesorias = asesoriaRepository.findByAlumno_Id(id);
        for (Asesoria a: asesorias) {
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
        for (Asesoria a: asesorias) {
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
        for (Asesoria a: asesorias) {
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
            throw new ResourceNotFoundException("There are no Asesoria with the id: "+String.valueOf(id));
        }
        return asesoriaFound;
    }
    @Override
    public Asesoria save(Asesoria asesoria) {
<<<<<<< Updated upstream
//        Alumno alumno = alumnoRepository.findById(asesoria.getAlumno().getId()).get();
//        Curso curso = cursoRepository.findById(asesoria.getCurso().getId()).get();
//        Asesor asesor = asesorRepository.findById(asesoria.getAsesor().getId()).get();
//        asesoria.setAlumno(alumno);
//        asesoria.setCurso(curso);
//        asesoria.setAsesor(asesor);
        return asesoriaRepository.save(asesoria);
=======
        List<Asesoria> asesorias = asesoriaRepository.findByAsesor_Id(asesoria.getAsesor().getId());

        Alumno alumno = alumnoRepository.findById(asesoria.getAlumno().getId()).get();
        Curso curso = cursoRepository.findById(asesoria.getCurso().getId()).get();
        Asesor asesor = asesorRepository.findById(asesoria.getAsesor().getId()).get();
        asesoria.setAlumno(alumno);
        asesoria.setCurso(curso);
        asesoria.setAsesor(asesor);

        //asesorias.add(asesoria);

        if (asesorias.size()>1){
            for (Asesoria a : asesorias) {
                    if ( asesoria.getFechaRealizado().equals(a.getFechaRealizado()) &&
                            estaEnRango(a.getHoraInicio(),a.getHoraFin(),asesoria.getHoraInicio()))
                {
                    throw new KeyRepeatedDataException("el asesor ya cuenta con una asesoria con el horario registrada");
                }
            }
        }
        Asesoria newAsesoria = asesoriaRepository.save(asesoria);
        newAsesoria.getAsesor().setHorarios(null);
        newAsesoria.getAsesor().setAsesorias(null);
        newAsesoria.getAsesor().setAsesorCursos(null);
        return newAsesoria;
>>>>>>> Stashed changes
    }

    @Override
    public void delete(Long id) {
        Asesoria asesoria = findById(id);
        asesoriaRepository.delete(asesoria);
    }
}
