package backend.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "detalles")
public class DetalleHorario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "horario_id")
    private Horario horario;


    @JsonIgnore
    @OneToMany(mappedBy = "detalle")
    private List<Asesoria> asesorias;

    private LocalTime horaInicio;
    private LocalTime horaFin;

    // getters and setters
}