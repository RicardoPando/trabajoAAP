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
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer ciclo;

    @JsonIgnore
    @OneToMany(mappedBy = "alumno")
    private List<AlumnoCurso> alumnosCursos;

    @JsonIgnore
    @OneToMany(mappedBy = "asesor")
    private List<AsesorCurso> asesorCursos;

    @JsonIgnore
    @OneToMany(mappedBy = "curso")
    private List<Asesoria> asesorias;

}
