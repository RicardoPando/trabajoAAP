package backend.project.servicesimpl;
import backend.project.entities.Alumno;
import backend.project.entities.Curso;
import backend.project.entities.AlumnoCurso;

import backend.project.exceptions.IncompleteDataException;
import backend.project.exceptions.KeyRepeatedDataException;
import backend.project.exceptions.ResourceNotFoundException;

import backend.project.repositories.AlumnoRepository;
import backend.project.repositories.AlumnoCursoRepository;
import backend.project.repositories.CursoRepository;

import backend.project.services.AlumnoCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoCursoServiceImpl implements AlumnoCursoService{
    @Autowired
    AlumnoCursoRepository alumnoCursoRepository;
    @Autowired
    AlumnoRepository alumnoRepository;
    @Autowired
    CursoRepository cursoRepository;
    @Override
    public List<AlumnoCurso> listAll() {
        return null;
    }

    @Override
    public List<AlumnoCurso> findByAlumno_Id(Long id) {
        return null;
    }

    @Override
    public List<AlumnoCurso> findByCurso_Id(Long id) {
        return null;
    }

    @Override
    public List<AlumnoCurso> listByName(String name) {
        return null;
    }

    @Override
    public List<Alumno> findAlumno_ByCurso_Id(Long id) {
        return null;
    }

    @Override
    public List<Curso> findCurso_ByAlumno_Id(Long id) {
        return null;
    }

    @Override
    public AlumnoCurso findById(Long id) {
        return null;
    }

    @Override
    public AlumnoCurso save(AlumnoCurso alumnoCurso) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
