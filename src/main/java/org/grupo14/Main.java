package org.grupo14;

import entity.Carrera;
import service.Servicios;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Servicios servicios = new Servicios();
//        servicio.cargarDatos();
        //Las opciones son "DNI", "nombre", "apellido", "edad", "genero", "ciudad", "LU"
        //cualquier otra opcion o valor nulo ordena por apellido
//        System.out.println(servicios.obtenerEstudiantesOrdenados("LU"));
        //Las opciones son "Agender", "Bigender", "Female", "Genderfluid", "Male", "Masculino", "Non-binary", "Polygender"
        System.out.println(servicios.obtenerEstudiantesPorGenero("Polygender"));
//        System.out.println(servicios.obtenerEstudiantesPorCarreraCiudad(new Carrera(2, "test", 0), "Idvor"));
    }
}