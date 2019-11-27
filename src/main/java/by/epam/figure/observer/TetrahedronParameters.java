package by.epam.figure.observer;

import by.epam.figure.bean.Tetrahedron;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronParameters implements Observable<TetrahedronRegister> {
    private List<Observer> observers;
    private Tetrahedron tetrahedron;

    private TetrahedronParameters() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(TetrahedronRegister observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(TetrahedronRegister observer) {
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
