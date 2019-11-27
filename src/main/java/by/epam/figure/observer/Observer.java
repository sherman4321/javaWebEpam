package by.epam.figure.observer;

import by.epam.figure.bean.Tetrahedron;

public interface Observer<E> {
    void update(E e);
}
