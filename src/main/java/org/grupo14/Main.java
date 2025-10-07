package org.grupo14;

import entity.Carrera;
import service.Servicios;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Servicios servicios = new Servicios();
//        servicio.cargarDatos();
//        System.out.println(servicio.obtenerEstudiantesOrdenados());
//        System.out.println(servicios.obtenerEstudiantesPorGenero("Polygender"));
        System.out.println(servicios.obtenerEstudiantesPorCarreraCiudad(new Carrera(2, "test", 0), "Idvor"));
    }
}