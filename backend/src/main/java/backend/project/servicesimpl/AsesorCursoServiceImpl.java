package backend.project.servicesimpl;
import backend.project.entities.Asesor;
import backend.project.entities.Curso;
import backend.project.entities.AsesorCurso;

import backend.project.exceptions.IncompleteDataException;
import backend.project.exceptions.KeyRepeatedDataException;
import backend.project.exceptions.ResourceNotFoundException;

import backend.project.repositories.*;

import backend.project.services.AsesorCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public List<AsesorCurso> findByAsesor_Id(Long id) {
        return null;
    }

    @Override
    public List<AsesorCurso> findByCurso_Id(Long id) {
        return null;
    }

    @Override
    public List<AsesorCurso> listByName(String name) {
        return null;
    }

    @Override
    public List<Asesor> findAsesor_ByCurso_Id(Long id) {
        return null;
    }

    @Override
    public List<Curso> findCurso_ByAsesor_Id(Long id) {
        return null;
    }

    @Override
    public AsesorCurso findById(Long id) {
        return null;
    }

    @Override
    public AsesorCurso save(AsesorCurso asesorCurso) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
