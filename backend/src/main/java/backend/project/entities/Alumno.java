package backend.project.entities;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IDAlumno;

    @Column(name = "Ciclo",nullable = false)
    private int Ciclo;
    @Column(name = "nombreAlumno",nullable = false)
    private String nombreAlumno;
    @Column(name = "apellidoAlumno",nullable = false)
    private String apellidoAlumno;

    @Column(name = "fecha_registro",nullable = false)
    private LocalDate fechaRegistro;

    public Alumno() {}

    public Alumno(int IDAlumno, int ciclo, String nombreAlumno, String apellidoAlumno, LocalDate fechaRegistro) {
        this.IDAlumno = IDAlumno;
        this.Ciclo = ciclo;
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIDAlumno() {
        return IDAlumno;
    }

    public void setIDAlumno(int IDAlumno) {
        this.IDAlumno = IDAlumno;
    }

    public int getCiclo() {
        return Ciclo;
    }

    public void setCiclo(int ciclo) {
        this.Ciclo = ciclo;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }

    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
