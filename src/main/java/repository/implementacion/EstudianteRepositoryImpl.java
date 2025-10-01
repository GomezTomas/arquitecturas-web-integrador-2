package repository.implementacion;

import entity.Estudiante;
import repository.EstudianteRepository;

import javax.persistence.EntityManager;

public class EstudianteRepositoryImpl implements EstudianteRepository {
    private EntityManager em;

    @Override
    public Estudiante findById(int id) {
        return null;
    }

    @Override
    public void create(Estudiante elem) {

    }

    @Override
    public void delete(Estudiante elem) {

    }

    @Override
    public void update(Estudiante elem) {

    }
}
