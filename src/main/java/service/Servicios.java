package service;

import entity.Carrera;
import entity.Estudiante;
import helper.CSVReader;
import helper.EntityManagerHelper;
import repository.CarreraRepository;
import repository.EstudianteCarreraRepository;
import repository.EstudianteRepository;
import repository.RepositoryFactory;
import repository.implementacion.EstudianteCarreraRepositoryImpl;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

public class Servicios {
    private EstudianteRepository er;
    private CarreraRepository cr;
    private EstudianteCarreraRepository ecr;
    private EntityManager em;
    private RepositoryFactory rf;

    public Servicios(){
        this.em = EntityManagerHelper.getEntityManager();
        this.rf = new RepositoryFactory();
        this.er = rf.getEstudianteRepository(em);
        this.cr = rf.getCarreraRepository(em);
        this.ecr = rf.getEstudianteCarreraRepository(em);
    }

    public void cargarDatos() {
        CSVReader csvReader = new CSVReader(em, cr, er, ecr);
        try {
            csvReader.cargarDatos();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //a) dar de alta un estudiante
    public void altaEstudiante(Estudiante estudiante){
        er.darDeAlta(estudiante);
    }
    //b) matricular un estudiante en una carrera
    public void matricularEstudiante(Estudiante estudiante, Carrera carrera){
        ecr.matricular(estudiante, carrera);
    }
    //c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
    public List<Estudiante> obtenerEstudiantesOrdenados(String orden){
        //chequear que el orden sea posible, sino ordenar por apellido.
        String[] criterios = {"nombre", "apellido"};
        String ordenFinal = "apellido";
        for(String criterio : criterios){
            if(criterio.equals(orden)){
                ordenFinal = orden;
            }
        }
        return er.obtenerEstudiantesOrdenados(ordenFinal);
    }
    //d) recuperar un estudiante, en base a su número de libreta universitaria.
    public Estudiante obtenerEstudiantePorLU(int lu){
        return er.findByLU(lu);
    }
    //e) recuperar todos los estudiantes, en base a su género.
    public List<Estudiante> obtenerEstudiantesPorGenero(String genero){
        //las opciones pueden ser m, f, masculino, femenino, male, female
        //if m, masc, masculino, male = male.
        //if f, fem, femenino, female = female.
        return er.findByGenero(genero);
    }
    //f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
    public List<Carrera> obtenerCarrerasConEstudiantesInscriptos(){
        return cr.carrerasConEstudiantes();
    }
    //g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
    public List<Estudiante> obtenerEstudiantesPorCarreraCiudad(Carrera carrera, String ciudad){
        return er.findByCarreraCiudad(carrera, ciudad);
    }

}
