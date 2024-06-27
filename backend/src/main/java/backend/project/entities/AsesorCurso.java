package backend.project.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "asesores_cursos")
public class AsesorCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer nivelDominio;
    //private Date disponibilidad;


    @ManyToOne
    @JoinColumn(name = "asesor_id")
    private Asesor asesor;


    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}
