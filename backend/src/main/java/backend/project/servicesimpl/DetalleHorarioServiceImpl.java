package backend.project.servicesimpl;

import backend.project.entities.DetalleHorario;
import backend.project.entities.Horario;
import backend.project.repositories.DetalleHorarioRepository;
import backend.project.services.DetalleHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleHorarioServiceImpl implements DetalleHorarioService {
    @Autowired
    private DetalleHorarioRepository detalleHorarioRepository;

    @Override
    public List<DetalleHorario> getAllDetallesHorario() {
        return detalleHorarioRepository.findAll();
    }

    @Override
    public DetalleHorario getDetalleHorarioById(Long id) {
        return detalleHorarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<DetalleHorario> getDetalleHorarioByAsesorId(Long id) {
        return detalleHorarioRepository.findDetalleHorariosByHorario_Asesor_Id(id);
    }

    @Override
    public DetalleHorario save(DetalleHorario detalleHorario) {
        return detalleHorarioRepository.save(detalleHorario);
    }

    @Override
    public void delete(Long id) {
        detalleHorarioRepository.deleteById(id);
    }
}
