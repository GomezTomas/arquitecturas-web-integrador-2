package repository.implementacion;

import entity.Carrera;
import entity.Estudiante;
import repository.CarreraRepository;
import repository.EstudianteRepository;

import javax.persistence.EntityManager;

public class EstudianteRepositoryImpl implements EstudianteRepository {
    private EntityManager em;
    private static EstudianteRepository instance = null;

    private EstudianteRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public static EstudianteRepository getInstance(EntityManager em) {
        if (instance == null) {
            instance = new EstudianteRepositoryImpl(em);
        }
        return instance;
    }



    @Override
    public Estudiante findById(int id) {
        em.getTransaction().begin();
        Estudiante estudiante = em.find(Estudiante.class, id);
        return estudiante;
    }

    @Override
    public void create(Estudiante estudiante) {
       em.getTransaction().begin();
       em.persist(estudiante);
       em.getTransaction().commit();
    }

    @Override
    public void delete(Estudiante estudiante) {
       em.getTransaction().begin();
       em.remove(estudiante);
       em.getTransaction().commit();
    }

    @Override
    public void update(Estudiante estudiante) {
       em.getTransaction().begin();
       em.merge(estudiante);
       em.getTransaction().commit();

    }
}
