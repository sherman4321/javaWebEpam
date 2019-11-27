package by.epam.figure.repository;

import by.epam.figure.bean.Tetrahedron;

import java.util.List;

public interface CrudRepository<E, T> {
    void save(T id, E e);
    E readById(T id);
    E delete(T id);
    List<E> getAll();
}
