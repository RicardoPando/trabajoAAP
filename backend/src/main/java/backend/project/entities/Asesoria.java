package backend.project.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "asesorias")
public class Asesoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaRegistro;
    private Double tarifaPactadas;
    private Date fechaRealizado;
    private Integer calificacionAsesor;
    private Integer calificacionAlumno;
    private AsesoriaEstado estado;
    private Time horaInicio;
    private Time horaFin;
    private Integer duracion;
    private Double montoCobrado;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "asesor_id")
    private Asesor asesor;

}

