package repository.implementacion;

import entity.EstudianteCarrera;
import repository.EstudianteCarreraRepository;

import javax.persistence.EntityManager;

public class EstudianteCarreraRepositoryImpl implements EstudianteCarreraRepository {
    private EntityManager em;
    private static EstudianteCarreraRepository instance = null;

    private EstudianteCarreraRepositoryImpl(EntityManager em) {
        this.em = em;
    }
    public static EstudianteCarreraRepository getInstance(EntityManager em){
        if(instance == null){
            instance = new EstudianteCarreraRepositoryImpl(em);
        }
        return instance;
    }


    @Override
    public void create(EstudianteCarrera ec) {
        em.getTransaction().begin();
        em.persist(ec);
        em.getTransaction().commit();
    }

    @Override
    public EstudianteCarrera findById(int id) {
        em.getTransaction().begin();
        EstudianteCarrera ec = em.find(EstudianteCarrera.class, id);
        em.getTransaction().commit();
        return ec;
    }

    @Override
    public void delete(EstudianteCarrera ec) {
        em.getTransaction().begin();
        em.remove(ec);
        em.getTransaction().commit();
    }

    @Override
    public void update(EstudianteCarrera ec) {
        em.getTransaction().begin();
        em.merge(ec);
        em.getTransaction().commit();
    }
}
