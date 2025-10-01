package entity;

import javax.persistence.*;

@Entity
public class Carrera {

    @Id
    @Column
    private int id;
    private String carrera;
    private int duracion;

     @ManyToOne
     @JoinColumn
     private EstudianteCarrera estudianteCarrera;

    public Carrera() {
    }
    public Carrera(int id, String carrera, int duracion) {
        this.id = id;
        this.carrera = carrera;
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
