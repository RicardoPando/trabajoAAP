package backend.project.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "horarios")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dia;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horario")
    private List<DetalleHorario> detalles;


    @ManyToOne
    @JoinColumn(name = "asesor_id", nullable = true)
    private Asesor asesor;

}
