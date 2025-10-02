package service;

import helper.CSVReader;
import helper.EntityManagerHelper;
import repository.CarreraRepository;
import repository.EstudianteCarreraRepository;
import repository.EstudianteRepository;
import repository.RepositoryFactory;
import repository.implementacion.EstudianteCarreraRepositoryImpl;

import javax.persistence.EntityManager;
import java.io.IOException;

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
}
