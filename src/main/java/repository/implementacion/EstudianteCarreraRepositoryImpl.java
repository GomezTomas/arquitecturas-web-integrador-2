package repository.implementacion;

import entity.EstudianteCarrera;
import repository.EstudianteCarreraRepository;

import javax.persistence.EntityManager;

public class EstudianteCarreraRepositoryImpl implements EstudianteCarreraRepository {
    private EntityManager em;

    @Override
    public void create(EstudianteCarrera elem) {

    }

    @Override
    public EstudianteCarrera findById(int id) {
        return null;
    }

    @Override
    public void delete(EstudianteCarrera elem) {

    }

    @Override
    public void update(EstudianteCarrera elem) {

    }
}
