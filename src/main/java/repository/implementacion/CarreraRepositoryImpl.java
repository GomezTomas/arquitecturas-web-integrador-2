package repository.implementacion;

import entity.Carrera;
import repository.CarreraRepository;

import javax.persistence.EntityManager;

public class CarreraRepositoryImpl implements CarreraRepository {

    private EntityManager em;
    private static CarreraRepositoryImpl instance = null;

    private CarreraRepositoryImpl(EntityManager em) {
        this.em = em;
    }
    public static CarreraRepositoryImpl getInstance(EntityManager em) {
        if (instance == null) {
            instance = new CarreraRepositoryImpl(em);
        }
        return instance;
    }

    @Override
    public void create(Carrera carrera) {
        em.getTransaction().begin();
        em.persist(carrera);
        em.getTransaction().commit();
    }

    @Override
    public Carrera findById(int id) {
        em.getTransaction().begin();
        Carrera carrera = em.find(Carrera.class, id);
        em.getTransaction().commit();
        return carrera;
    }

    @Override
    public void delete(Carrera carrera) {
        em.getTransaction().begin();
        em.remove(carrera);
        em.getTransaction().commit();

    }

    @Override
    public void update(Carrera carrera) {
        em.getTransaction().begin();
        em.merge(carrera);
        em.getTransaction().commit();
    }
}
