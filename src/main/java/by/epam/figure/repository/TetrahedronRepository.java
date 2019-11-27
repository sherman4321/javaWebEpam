package by.epam.figure.repository;

import by.epam.figure.bean.Tetrahedron;
import by.epam.figure.bean.comparator.TetrahedronFirstPointComparator;
import by.epam.figure.observer.TetrahedronRegister;

import java.util.*;

public class TetrahedronRepository implements CrudRepository<Tetrahedron, Integer> {
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

    public List<Tetrahedron> getAll() {
        return new ArrayList<>(tetrahedronList);
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

    public List<Tetrahedron> sortByFirstPoint(){
        List<Tetrahedron> list = new ArrayList<>(tetrahedronList);
        Collections.sort(list, new TetrahedronFirstPointComparator());
        return list;
    }

    @Override
    public void save(Integer id,Tetrahedron tetrahedron) {
            Tetrahedron temp = new Tetrahedron(tetrahedron);
            tetrahedronList.add(id, temp);
    }

    @Override
    public Tetrahedron readById(Integer id) {
        return new Tetrahedron(tetrahedronList.get(id));
    }

    @Override
    public Tetrahedron delete(Integer id) {
        return new Tetrahedron(tetrahedronList.remove((int)id));
    }
}
