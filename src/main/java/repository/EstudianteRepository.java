package repository;

import entity.Carrera;
import entity.Estudiante;

import java.util.List;

public interface EstudianteRepository extends Repository<Estudiante> {
//    void darDeAlta(Estudiante estudiante);
    List<Estudiante> obtenerEstudiantesOrdenados(String orden);
//    Estudiante findByLU(int lu);
    List<Estudiante> obtenerEstudiantesPorGenero(String genero);
//    List<Estudiante> findByCarreraCiudad(Carrera carrera, String ciudad);
//g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
    List<Estudiante> obtenerEstudiantesPorCarreraCiudad(Carrera carrera, String ciudad);
}
