package repository;

public interface Repository<T> {
    T findById(int id);
    void create(T elem);
    void delete(T elem);
    void update(T elem);

}
