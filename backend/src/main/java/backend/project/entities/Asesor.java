package backend.project.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "asesores")


public class Asesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private Integer tarifa;
    private String experiencia;

    @JsonIgnore
    @OneToOne(mappedBy = "usuario")
    private Usuario usuario;

    @JsonIgnore
    @OneToMany(mappedBy = "asesor")
    private List<AsesorCurso> asesorCursos;

}
