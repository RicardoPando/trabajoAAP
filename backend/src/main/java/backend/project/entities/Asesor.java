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
    private Long    id;
    private String  nombre;
    private String  apellido;
    private Integer tarifa;
    private String  experiencia;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "asesor")
    private List<AsesorCurso> asesorCursos;

    @OneToMany(mappedBy = "asesor", cascade = CascadeType.ALL)
    private List<Horario> horarios;

    @OneToMany(mappedBy = "asesor")
    private List<Asesoria> asesorias;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "canal_contacto_id")
    private CanalContacto canalContacto;

}
