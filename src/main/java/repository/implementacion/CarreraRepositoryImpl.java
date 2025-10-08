package repository.implementacion;

import DTO.CarerraDTO;
import entity.Carrera;
import entity.Identificador.Identificador;
import repository.CarreraRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

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
    public Carrera findById(Identificador id) {
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

    //recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
    public List<CarerraDTO> obtenerCarrerasConEstudiantesInscriptos() {
        String query = "SELECT c.carrera, COUNT(ec) FROM Carrera c JOIN EstudianteCarrera ec ON ec.carrera.id ORDER BY COUNT(ec) DESC ";
        Query q = em.createQuery(query);
        List<Object[]> resultados = q.getResultList();
        List<CarerraDTO> carrerasDTO = new ArrayList<>();
        for (Object[] fila : resultados) {
            String nombreCarrera = (String) fila[0];
            Long cantidad = (Long) fila[1]; // COUNT devuelve Long
            carrerasDTO.add(new CarerraDTO(nombreCarrera, cantidad.intValue()));
        }

        return carrerasDTO;
    }

}
