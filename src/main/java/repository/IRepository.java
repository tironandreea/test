package repository;

/**
 * Created by Tiron Andreea on 12/03/2017.
 */
public interface IRepository<ID, T> {
    int size();
    void save(T entity);
    void delete(ID id);
    void update(ID id, T entity);
    T findOne(ID id);
    Iterable<T> findAll();
}