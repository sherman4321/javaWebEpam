package by.epam.figure.logic;

import by.epam.figure.bean.Point;
import by.epam.figure.bean.Tetrahedron;
import by.epam.figure.bean.Vector3D;

public class TetrahedronLogic {
    public double square(Tetrahedron tetrahedron){
        Point x1 = tetrahedron.getX1();
        Point x2 = tetrahedron.getX2();
        Point x3 = tetrahedron.getX3();
        Point x4 = tetrahedron.getX4();
        return squareOfFace(x1, x2, x3) +
                squareOfFace(x2, x3, x4) +
                squareOfFace(x3, x4, x1) +
                squareOfFace(x4, x1, x2);
    }

    private double squareOfFace(Point x1, Point x2, Point x3) {
        double AB = length(x1, x2);
        double AC = length(x1, x3);
        double CB = length(x3, x2);
        double semiPerimeter = (AB + AC + CB) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - AB) * (semiPerimeter - AC) * (semiPerimeter - CB));
    }

    public double volume(Tetrahedron tetrahedron){
        Point r1 = tetrahedron.getX1();
        Point r2 = tetrahedron.getX2();
        Point r3 = tetrahedron.getX3();
        Point r4 = tetrahedron.getX4();
        return ((r2.getX() - r1.getX()) * (r3.getY() - r1.getY()) * (r4.getZ() - r1.getZ()) +
                (r2.getY() - r1.getY()) * (r3.getZ() - r1.getZ()) * (r4.getX() - r1.getX()) +
                (r3.getX() - r1.getX()) * (r4.getY() - r1.getY()) * (r2.getZ() - r1.getZ()) -
                (r2.getZ() - r1.getZ()) * (r3.getY() - r1.getY()) * (r4.getX() - r1.getX()) -
                (r3.getZ() - r1.getZ()) * (r4.getY() - r1.getY()) * (r2.getX() - r1.getX()) -
                (r3.getX() - r1.getX()) * (r2.getY() - r1.getY()) * (r4.getZ() - r1.getZ())) / 6;
    }

    private double length(Point x1, Point x2){
        Vector3D vector3D = new Vector3D(x1, x2);
        return Vector3DLogic.length(vector3D);
    }

    private Point pointOfSplitByPlaneXY(Point p1, Point p2){
        double x;
        double y;
        if(p1.getX() > p2.getX()){
            x = p1.getX() - ((p1.getX() - p2.getX()) * p1.getZ() / (p1.getZ() - p2.getZ()));
        }else{
            x = ((p2.getX() - p1.getX()) * p1.getZ() / (p1.getZ() - p2.getZ())) - p1.getX();
        }
        if(p1.getY() > p2.getY()){
            y = p1.getY() - ((p1.getY() - p2.getY()) * p1.getZ() / (p1.getZ() - p2.getZ()));
        }else{
            y = p1.getY() - ((p1.getY() - p2.getY()) * p1.getZ() / (p1.getZ() - p2.getZ()));
        }
        return new Point(x, y, 0);
    }

    public double ratioOfPartsOfTetrahedron(Tetrahedron tetrahedron) {
        Point r4 = tetrahedron.getX4();
        Point r1 = pointOfSplitByPlaneXY(r4, tetrahedron.getX1());
        Point r2 = pointOfSplitByPlaneXY(r4, tetrahedron.getX2());
        Point r3 = pointOfSplitByPlaneXY(r4, tetrahedron.getX3());
        Tetrahedron tetrahedron1 = new Tetrahedron(r1, r2, r3, r4);
        double volume = volume(tetrahedron);
        double volume1 = volume(tetrahedron1);
        return (volume1)/(volume-volume1);
    }

    public boolean isTetrahedron(Tetrahedron tetrahedron){
        Point r1 = tetrahedron.getX1();
        Point r2 = tetrahedron.getX2();
        Point r3 = tetrahedron.getX3();
        Point r4 = tetrahedron.getX4();

        if (r1.getX() == r2.getX() && r2.getX() == r3.getX() && r3.getX() == r4.getX()) {
            return false;
        }
        if (r1.getZ() == r2.getZ() && r2.getZ() == r3.getZ() && r3.getZ() == r4.getZ()) {
            return false;
        }
        if (r1.getY() == r2.getY() && r2.getY() == r3.getY() && r3.getY() == r4.getY()) {
            return false;
        }
        return true;
    }

    public boolean isTetrahedronOnPlane(Tetrahedron tetrahedron) {
        Point r1 = tetrahedron.getX1();
        Point r2 = tetrahedron.getX2();
        Point r3 = tetrahedron.getX3();

        if((r1.getX()==0 && r2.getX()==0 && r3.getX()==0) ||
                (r1.getY()==0 && r2.getY()==0 && r3.getY()==0) ||
                (r1.getZ()==0 && r2.getZ()==0 && r3.getZ()==0)){
            return true;
        }
        return false;
    }
}


