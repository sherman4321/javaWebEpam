package by.epam.figure.repository;

import by.epam.figure.bean.Tetrahedron;
import by.epam.figure.bean.util.TetrahedronComparator;
import by.epam.figure.logic.TetrahedronLogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TetrahedronRepository implements CrudRepository {
    List<Tetrahedron> tetrahedronList;

    public TetrahedronRepository() {
        tetrahedronList = new ArrayList<>();
    }

    public TetrahedronRepository(List<Tetrahedron> tetrahedronList) {
        this.tetrahedronList = tetrahedronList;
    }

    public List<Tetrahedron> getTetrahedronList() {
        return tetrahedronList;
    }

    public void setTetrahedronList(List<Tetrahedron> tetrahedronList) {
        this.tetrahedronList = tetrahedronList;
    }

    public List<Tetrahedron> readAllBySquare(double from, double to){
        List<Tetrahedron> tetrahedra = new ArrayList<>();
        TetrahedronLogic logic = new TetrahedronLogic();
        for(Tetrahedron i: tetrahedronList){
            double square = logic.square(i);
            if(square >= from && square <= to){
                tetrahedra.add(i);
            }
        }
        return tetrahedra;
    }

    public void sortByX(){
        Collections.sort(tetrahedronList, new TetrahedronComparator());
    }

    @Override
    public boolean create(Tetrahedron tetrahedron) {
        if(tetrahedronList.add(tetrahedron)){
            tetrahedron.setId(tetrahedronList.indexOf(tetrahedron));
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Tetrahedron read(int id) {
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
