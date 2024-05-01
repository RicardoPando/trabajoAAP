package backend.project.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer ciclo;
    private String nombre;
    private String apellido;
    //clase alumno
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "alumno_id")
    private List<AlumnoCurso> alumnosCursos;

    @JsonIgnore
    @OneToMany(mappedBy = "alumno_id")
    private List<Asesoria> asesorias;


}
