package by.epam.figure.repository;

import by.epam.figure.bean.Tetrahedron;
import by.epam.figure.bean.comparator.TetrahedronComparatorX1;
import by.epam.figure.observer.TetrahedronRegister;

import java.util.*;

public class TetrahedronRepository implements CrudRepository {
    private List<Tetrahedron> tetrahedronList;
    private Map<Integer, TetrahedronRegister> registers;

    public TetrahedronRepository() {
        tetrahedronList = new ArrayList<>();
        registers = new HashMap<>();
    }

    public TetrahedronRepository(List<Tetrahedron> tetrahedronList, Map<Integer, TetrahedronRegister> registers) {
        this.tetrahedronList = tetrahedronList;
        this.registers = registers;
    }

    public List<Tetrahedron> getTetrahedronList() {
        return tetrahedronList;
    }

    public void setTetrahedronList(List<Tetrahedron> tetrahedronList) {
        this.tetrahedronList = tetrahedronList;
    }

    public List<Tetrahedron> readAllBySquare(double from, double to){
        List<Tetrahedron> tetrahedra = new ArrayList<>();
        double square;
        for(Tetrahedron i: tetrahedronList){
            square = registers.get(i.getId()).getSquare();
            if(square >= from && square <= to){
                tetrahedra.add(i);
            }
        }
        return tetrahedra;
    }

    public void sortByX(){
        Collections.sort(tetrahedronList, new TetrahedronComparatorX1());
    }

    @Override
    public boolean create(Tetrahedron tetrahedron) {
        if(tetrahedronList.add(tetrahedron)){
            tetrahedron.setId(tetrahedronList.indexOf(tetrahedron));
            TetrahedronRegister tetrahedronRegister = new TetrahedronRegister(tetrahedron);
            registers.put(tetrahedron.getId(), tetrahedronRegister);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Tetrahedron readById(int id) {
        return tetrahedronList.get(id);
    }

    @Override
    public void update(int id, Tetrahedron tetrahedron) {
        tetrahedronList.add(id, tetrahedron);
    }

    @Override
    public Tetrahedron delete(int id) {
        return tetrahedronList.remove(id);
    }
}
