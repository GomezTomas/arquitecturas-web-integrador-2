package repository;

import entity.Carrera;
import entity.Estudiante;

import java.util.List;

public interface EstudianteRepository extends Repository<Estudiante> {
//    void darDeAlta(Estudiante estudiante);
    List<Estudiante> obtenerEstudiantesOrdenados(String orden);
//    Estudiante findByLU(int lu);
//    List<Estudiante> findByGenero(String genero);
//    List<Estudiante> findByCarreraCiudad(Carrera carrera, String ciudad);
}
