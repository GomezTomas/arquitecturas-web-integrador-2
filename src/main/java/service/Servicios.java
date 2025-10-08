package service;

import DTO.EstudianteDTO;
import DTO.CarerraDTO;

import entity.Carrera;
import entity.Estudiante;
import entity.Identificador.EstudianteCarreraID;
import entity.Identificador.Identificador;
import helper.CSVReader;
import helper.EntityManagerHelper;
import repository.CarreraRepository;
import repository.EstudianteCarreraRepository;
import repository.EstudianteRepository;
import repository.RepositoryFactory;

import javax.persistence.EntityManager;
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
    //TODO
    //a) dar de alta un estudiante
    public void altaEstudiante(Estudiante estudiante){
//        er.darDeAlta(estudiante);
    }
    //b) matricular un estudiante en una carrera
    public void matricularEstudiante(int idEstudiante, int idCarrera){
        Estudiante e = er.findById(new Identificador(idEstudiante));
        Carrera c = cr.findById(new Identificador(idCarrera));
        EstudianteCarreraID ecid = new EstudianteCarreraID(e, c);
        if (ecr.findById(ecid) == null){
            ecr.matricular(e, c);
        } else {
            System.out.println("el estudiante se encuentra matriculado");
        }
    }
    //c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
    public List<EstudianteDTO> obtenerEstudiantesOrdenados(String orden){
        String[] criterios = {"DNI","nombre", "apellido", "edad", "genero", "ciudad", "LU"};
        String ordenFinal = "apellido";
        for(String criterio : criterios){
            if(criterio.equals(orden)){
                ordenFinal = orden;
            }
        }
        return er.obtenerEstudiantesOrdenados(ordenFinal);
    }

    public List<EstudianteDTO> obtenerEstudiantesOrdenados(){
       return  obtenerEstudiantesOrdenados("apellido");
    }
    //TODO
    //d) recuperar un estudiante, en base a su número de libreta universitaria.
    public Estudiante obtenerEstudiantePorLU(int lu){
//        return er.findByLU(lu);'
        return null;
    }
    //e) recuperar todos los estudiantes, en base a su género.
    public List<EstudianteDTO> obtenerEstudiantesPorGenero(String genero){
        return er.obtenerEstudiantesPorGenero(genero);
    }
    //TODO
    //f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
    public List<CarerraDTO> obtenerCarrerasConEstudiantesInscriptos(){
        return cr.obtenerCarrerasConEstudiantesInscriptos();
    }
    //g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
    public List<Estudiante> obtenerEstudiantesPorCarreraCiudad(Carrera carrera, String ciudad){
        return er.obtenerEstudiantesPorCarreraCiudad(carrera, ciudad);
    }

}
