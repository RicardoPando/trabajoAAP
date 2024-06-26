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
@Table(name = "alumnos_cursos")
public class AlumnoCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}
