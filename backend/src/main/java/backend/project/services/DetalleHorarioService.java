package backend.project.services;

import backend.project.entities.DetalleHorario;
import backend.project.entities.Horario;

import java.util.List;

public interface DetalleHorarioService {

    public List<DetalleHorario> getAllDetallesHorario();

    public DetalleHorario getDetalleHorarioById(Long id);
    public List<DetalleHorario> getDetalleHorarioByAsesorId(Long id);
    public DetalleHorario save(DetalleHorario detalleHorario);

    public void delete(Long id);
}
