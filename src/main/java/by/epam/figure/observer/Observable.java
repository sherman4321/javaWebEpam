package by.epam.figure.observer;

public interface Observable<Observer> {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
