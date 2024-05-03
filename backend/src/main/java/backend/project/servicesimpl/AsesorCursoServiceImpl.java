package backend.project.servicesimpl;
import backend.project.entities.Asesor;
import backend.project.entities.Curso;
import backend.project.entities.AsesorCurso;
import backend.project.exceptions.ResourceNotFoundException;
import backend.project.repositories.*;
import backend.project.services.AsesorCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AsesorCursoServiceImpl implements AsesorCursoService{
    @Autowired
    AsesorCursoRepository asesorCursoRepository;
    @Autowired
    AsesorRepository asesorRepository;
    @Autowired
    CursoRepository cursoRepository;
    @Override
    public List<AsesorCurso> listAll() {
        List<AsesorCurso> asesorCursos = asesorCursoRepository.findAll();
        for (AsesorCurso ep: asesorCursos) {
            //elimina la bidireccionalidad
            ep.getAsesor().setAsesorCursos(null);
            ep.getCurso().setAsesorCursos(null);
        }
        return asesorCursos;
    }
    @Override
    public List<AsesorCurso> findByAsesor_Id(Long id) {
        List<AsesorCurso> asesorCursos = asesorCursoRepository.findByAsesor_Id(id);
        for (AsesorCurso ac: asesorCursos) {
            //elimina la bidireccionalidad
            ac.getAsesor().setAsesorCursos(null);
            ac.getCurso().setAsesorCursos(null);
        }
        return asesorCursos;
    }
    @Override
    public List<AsesorCurso> findByCurso_Id(Long id) {

        List<AsesorCurso> asesorCursos = asesorCursoRepository.findByCurso_Id(id);
        for (AsesorCurso ac: asesorCursos) {
            //elimina la bidireccionalidad
            ac.getAsesor().setAsesorCursos(null);
            ac.getCurso().setAsesorCursos(null);
        }
        return asesorCursos;
    }
    @Override
    public List<Asesor> findAsesor_ByCurso_Id(Long id) {
        List<AsesorCurso> asesorCursos = asesorCursoRepository.findByCurso_Id(id);
        List<Asesor> asesorList = new ArrayList<>();
        for (AsesorCurso ac: asesorCursos) {
            //para romper la bidireccionalidad
            ac.getAsesor().setAsesorCursos(null);
            //agrega el asesor a la lista asesorList
            asesorList.add(ac.getAsesor());
        }
        return asesorList;
    }

    @Override
    public List<Curso> findCurso_ByAsesor_Id(Long id) {
        List<AsesorCurso> asesorCursos = asesorCursoRepository.findByAsesor_Id(id);
        List<Curso> cursoList = new ArrayList<>();
        for (AsesorCurso ac: asesorCursos) {
            //para romper la bidireccionalidad
            ac.getAsesor().setAsesorCursos(null);
            //agrega el curso a la lista cursoList
            cursoList.add(ac.getCurso());
        }
        return cursoList;
    }

    @Override
    public AsesorCurso findById(Long id) {

        AsesorCurso asesorCursoFound = asesorCursoRepository.findById(id).orElse(null);
        if (asesorCursoFound == null) {
            throw new ResourceNotFoundException("There are no Asesor Curso with the id: "+String.valueOf(id));
        }
        return asesorCursoFound;
    }

    @Override
    public AsesorCurso save(AsesorCurso asesorCurso) {
        Asesor asesor=asesorRepository.findById(asesorCurso.getAsesor().getId()).get();
        Curso curso=cursoRepository.findById(asesorCurso.getCurso().getId()).get();
        asesorCurso.setAsesor(asesor);
        asesorCurso.setCurso(curso);
        return asesorCursoRepository.save(asesorCurso);
    }

    @Override
    public void delete(Long id) {
        AsesorCurso asesorCurso = findById(id);
        asesorCursoRepository.delete(asesorCurso);

    }
}
