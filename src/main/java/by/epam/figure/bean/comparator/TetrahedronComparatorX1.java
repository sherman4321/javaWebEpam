package by.epam.figure.bean.comparator;

import by.epam.figure.bean.Tetrahedron;

import java.util.Comparator;

public class TetrahedronComparatorX1 implements Comparator<Tetrahedron> {
    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        double x1 = o1.getX1().getX();
        double x2 = o2.getX2().getX();
        if(x1 > x2){
            return 1;
        }
        else if(x1 == x2){
            return 0;
        }
        else{
            return -1;
        }
    }
}
