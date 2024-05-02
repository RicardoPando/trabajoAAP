package backend.project.servicesimpl;
import backend.project.entities.Alumno;
import backend.project.entities.Asesor;
import backend.project.entities.Asesoria;
import backend.project.entities.Curso;

import backend.project.exceptions.IncompleteDataException;
import backend.project.exceptions.KeyRepeatedDataException;
import backend.project.exceptions.ResourceNotFoundException;

import backend.project.repositories.AlumnoRepository;
import backend.project.repositories.AsesorRepository;
import backend.project.repositories.AsesoriaRepository;
import backend.project.repositories.CursoRepository;

import backend.project.services.AsesoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return null;
    }

    @Override
    public List<Asesoria> findByAlumno_Id(Long id) {
        return null;
    }

    @Override
    public List<Asesoria> findByAsesor_Id(Long id) {
        return null;
    }

    @Override
    public List<Asesoria> findByCurso_Id(Long id) {
        return null;
    }

    @Override
    public List<Asesoria> listByName(String name) {
        return null;
    }

    @Override
    public List<Alumno> findAsesoria_ByAlumno_Id(Long id) {
        return null;
    }

    @Override
    public List<Curso> findAsesoria_ByCurso_Id(Long id) {
        return null;
    }

    @Override
    public List<Asesor> findAsesoria_ByAsesor_Id(Long id) {
        return null;
    }

    @Override
    public Asesoria findById(Long id) {
        return null;
    }

    @Override
    public Asesoria save(Asesoria asesoria) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
