package entity;

import entity.Identificador.EntidadRelacionId;

import javax.persistence.*;

@Entity
public class EstudianteCarrera {
    @EmbeddedId
    private EntidadRelacionId id;
    @ManyToOne
    private Estudiante estudiante;
    @ManyToOne
    private Carrera carrera;
    @Column
    private int inscripcion;
    @Column
    private int graduacion;
    @Column
    private int antiguedad;
    public EstudianteCarrera(){}

    public EstudianteCarrera(EntidadRelacionId id, Estudiante estudiante, Carrera carrera, int inscripcion, int graduacion, int antiguedad) {
        this.id = id;
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.inscripcion = inscripcion;
        this.graduacion = graduacion;
        this.antiguedad = antiguedad;
    }

    public EntidadRelacionId getId() {
        return id;
    }

    public void setId(EntidadRelacionId id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setIdCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public int getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(int inscripcion) {
        this.inscripcion = inscripcion;
    }

    public int getGraduacion() {
        return graduacion;
    }

    public void setGraduacion(int graduacion) {
        this.graduacion = graduacion;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
}
