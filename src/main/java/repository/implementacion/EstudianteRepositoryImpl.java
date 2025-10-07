package repository.implementacion;

import entity.Estudiante;
import repository.EstudianteRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

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
        em.getTransaction().commit();
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


    @Override
    public List<Estudiante> obtenerEstudiantesOrdenados(String orden) {
        em.getTransaction().begin();
        String o = "apellido";
        String query = "SELECT e FROM Estudiante e ORDER BY e."+o;
        Query q = em.createQuery(query,  Estudiante.class);
//        q.setParameter("orden", o);
        return q.getResultList();
    }

    public List<Estudiante> obtenerEstudiantesPorGenero(String genero){
        em.getTransaction().begin();
        String query = "SELECT e FROM Estudiante e WHERE e.genero = :genero";
        //TypedQuery<Estudiante> → evita tener que hacer cast al tipo de resultado.
        TypedQuery<Estudiante> q = em.createQuery(query, Estudiante.class);
        q.setParameter("genero", genero);
        return q.getResultList();
    }
}
