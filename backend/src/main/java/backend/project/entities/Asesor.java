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
    @OneToOne(mappedBy = "user_id")
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "asesor_id")
    private List<AsesorCurso> asesorCursos;

    @OneToMany(mappedBy = "asesor_id", cascade = CascadeType.ALL)
    private List<Horario> horarios;

    @OneToMany(mappedBy = "asesor_id")
    private List<Asesoria> asesorias;

    @OneToOne(mappedBy = "asesor_id")
    @JsonIgnore
    private CanalContacto canalContactos;

}
