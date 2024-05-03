package backend.project.servicesimpl;
import backend.project.entities.*;

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

import java.util.ArrayList;
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
        return alumnoCursoRepository.findAll();
    }

    @Override
    public List<AlumnoCurso> findByCurso_Id(Long id) {
        List<AlumnoCurso> alumnoCursos = alumnoCursoRepository.findByCurso_Id(id);
        for (AlumnoCurso ac: alumnoCursos) {
            //elimina la bidireccionalidad
            ac.getAlumno().setAlumnosCursos(null);
            ac.getCurso().setAsesorCursos(null);
        }
        return alumnoCursos;
    }
    @Override
    public List<AlumnoCurso> findByAlumno_Id(Long id) {
        List<AlumnoCurso> alumnoCursos = alumnoCursoRepository.findByAlumno_Id(id);
        for (AlumnoCurso ac: alumnoCursos) {
            //elimina la bidireccionalidad
            ac.getAlumno().setAlumnosCursos(null);
            ac.getCurso().setAsesorCursos(null);
        }
        return alumnoCursos;

    }
    @Override
    public List<Alumno> findAlumno_ByCurso_Id(Long id) {
        List<AlumnoCurso> alumnoCursos = alumnoCursoRepository.findByCurso_Id(id);
        List<Alumno> alumnoList = new ArrayList<>();
        for (AlumnoCurso ac: alumnoCursos) {
            //para romper la bidireccionalidad
            ac.getAlumno().setAlumnosCursos(null);
            //agrega el asesor a la lista asesorList
            alumnoList.add(ac.getAlumno());
        }
        return alumnoList;
    }
    @Override
    public List<Curso> findCurso_ByAlumno_Id(Long id) {
        List<AlumnoCurso> alumnoCursos = alumnoCursoRepository.findByAlumno_Id(id);
        List<Curso> cursoList = new ArrayList<>();
        for (AlumnoCurso ac: alumnoCursos) {
            //para romper la bidireccionalidad
            ac.getAlumno().setAlumnosCursos(null);
            //agrega el asesor a la lista asesorList
            cursoList.add(ac.getCurso());
        }
        return cursoList;
    }
    @Override
    public AlumnoCurso findById(Long id) {
        AlumnoCurso alumnoCursoFound = alumnoCursoRepository.findById(id).orElse(null);
        if (alumnoCursoFound == null) {
            throw new ResourceNotFoundException("There are no Alumno Curso with the id: "+String.valueOf(id));
        }
        return alumnoCursoFound;
    }

    @Override
    public AlumnoCurso save(AlumnoCurso alumnoCurso) {
        Alumno alumno = alumnoRepository.findById(alumnoCurso.getAlumno().getId()).get();
        Curso curso = cursoRepository.findById(alumnoCurso.getCurso().getId()).get();
        alumnoCurso.setAlumno(alumno);
        alumnoCurso.setCurso(curso);
        return alumnoCursoRepository.save(alumnoCurso);
    }

    @Override
    public void delete(Long id) {
        AlumnoCurso alumnoCurso = findById(id);
        alumnoCursoRepository.delete(alumnoCurso);
    }
}
