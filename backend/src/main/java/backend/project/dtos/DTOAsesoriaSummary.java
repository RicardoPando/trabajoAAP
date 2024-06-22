package backend.project.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class DTOAsesoriaSummary {
    private String asesorName;
    private String alumnoName;
    private String cursoName;
    private Date fecha;
    private Integer duracion;
    private String opinion;
}
