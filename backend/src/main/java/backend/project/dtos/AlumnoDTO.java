package backend.project.dtos;

import javax.persistence.Column;
import java.time.LocalDate;

public class AlumnoDTO {

    private int IDAlumno;
    private int Ciclo;
    private String apellidoAlumno;

    private LocalDate fechaRegistro;
    private String nombreAlumno;




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
