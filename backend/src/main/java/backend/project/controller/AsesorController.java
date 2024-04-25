package backend.project.controller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "asesores")


public class AsesorController {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private Integer experiencia;
    private Integer tarifa;

    @Override
    public String toString() {
        return "Asesor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", experiencia=" + experiencia +
                ", tarifa=" + tarifa +
                '}';
    }
}
