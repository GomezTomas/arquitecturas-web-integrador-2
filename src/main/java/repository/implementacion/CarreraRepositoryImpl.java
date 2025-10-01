package repository.implementacion;

import entity.Carrera;
import repository.CarreraRepository;

import javax.persistence.EntityManager;

public class CarreraRepositoryImpl implements CarreraRepository {
    private EntityManager em;
    @Override
    public void create(Carrera elem) {

    }

    @Override
    public Carrera findById(int id) {
        return null;
    }

    @Override
    public void delete(Carrera elem) {

    }

    @Override
    public void update(Carrera elem) {

    }
}
