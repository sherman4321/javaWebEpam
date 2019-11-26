package by.epam.figure.observer;

import by.epam.figure.bean.Tetrahedron;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronParameters implements Observable<Observer> {
    private List<Observer> observers;
    private Tetrahedron tetrahedron;

    private TetrahedronParameters() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer i: observers){
            i.update(tetrahedron);
        }
    }

    public Tetrahedron getTetrahedron() {
        return tetrahedron;
    }

    public void setTetrahedron(Tetrahedron tetrahedron) {
        this.tetrahedron = tetrahedron;
        notifyObserver();
    }
}
