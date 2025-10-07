package repository.implementacion;

import entity.Carrera;
import entity.Estudiante;
import entity.EstudianteCarrera;
import entity.Identificador.EntidadRelacionId;
import repository.EstudianteCarreraRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

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
    public void matricular(Estudiante estudiante, Carrera carrera){
        EstudianteCarrera estudianteCarrera = new EstudianteCarrera(new EntidadRelacionId(estudiante.getDNI(), carrera.getId()), estudiante, carrera, 2025,0,0);
        em.getTransaction().begin();
        em.persist(estudianteCarrera);
        em.getTransaction().commit();
    }
    public List<Carrera> getCarrerasConEstudiantes(){

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Carrera> cq = cb.createQuery(Carrera.class);
        Root<Carrera> carrera = cq.from(Carrera.class);
        Join<Object, Object> inscripciones = carrera.join("inscripciones", JoinType.INNER);

        cq.select(carrera).distinct(true);
        return em.createQuery(cq).getResultList();
    }

}
