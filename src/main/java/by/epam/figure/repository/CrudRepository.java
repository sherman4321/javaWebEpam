package by.epam.figure.repository;

import by.epam.figure.bean.Tetrahedron;

public interface CrudRepository {
    boolean create(Tetrahedron tetrahedron);
    Tetrahedron readById(int id);
    void update(int id, Tetrahedron tetrahedron);
    Tetrahedron delete(int id);
}
