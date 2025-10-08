package org.grupo14;

import entity.Carrera;
import service.Servicios;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Servicios servicios = new Servicios();
        //realiar una sola vez
//        servicios.cargarDatos();
        //a) dar de alta un estudiante
        //b) matricular un estudiante en una carrera
//        servicios.matricularEstudiante(23322529, 4);

        //c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
        //Las opciones son "DNI", "nombre", "apellido", "edad", "genero", "ciudad", "LU"
        //cualquier otra opcion o valor nulo ordena por apellido
        System.out.println(servicios.obtenerEstudiantesOrdenados("LU"));

        //d) recuperar un estudiante, en base a su número de libreta universitaria.

        //e) recuperar todos los estudiantes, en base a su género.
        //Las opciones son "Agender", "Bigender", "Female", "Genderfluid", "Male", "Masculino", "Non-binary", "Polygender"
//        System.out.println(servicios.obtenerEstudiantesPorGenero("Polygender"));
        //f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
        //g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
//        System.out.println(servicios.obtenerEstudiantesPorCarreraCiudad(new Carrera(2, "test", 0), "Idvor"));
    }
}