package by.epam.figure.observer;

public interface Observable<E> {
    void registerObserver(E observer);
    void removeObserver(E observer);
    void notifyObserver();
}
