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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumnos;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "asesor_id", nullable = false)
    private Asesor asesores;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;
}

