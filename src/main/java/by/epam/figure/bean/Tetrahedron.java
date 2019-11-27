package by.epam.figure.bean;

import java.util.Objects;

public class Tetrahedron {
    private int id;
    private Point x1;
    private Point x2;
    private Point x3;
    private Point x4;

    public Tetrahedron() {
    }

    public Tetrahedron(Tetrahedron tetrahedron){
        this.id = tetrahedron.id;
        this.x1 = tetrahedron.x1;
        this.x2 = tetrahedron.x2;
        this.x3 = tetrahedron.x3;
        this.x4 = tetrahedron.x4;
    }

    public Tetrahedron(Point x1, Point x2, Point x3, Point x4) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tetrahedron that = (Tetrahedron) o;
        return Objects.equals(getX1(), that.getX1()) &&
                Objects.equals(getX2(), that.getX2()) &&
                Objects.equals(getX3(), that.getX3()) &&
                Objects.equals(getX4(), that.getX4());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX1(), getX2(), getX3(), getX4());
    }

    @Override
    public String toString() {
        return "Tetrahedron{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                ", x3=" + x3 +
                ", x4=" + x4 +
                '}';
    }

    public Point getX1() {
        return x1;
    }

    public void setX1(Point x1) {
        this.x1 = x1;
    }

    public Point getX2() {
        return x2;
    }

    public void setX2(Point x2) {
        this.x2 = x2;
    }

    public Point getX3() {
        return x3;
    }

    public void setX3(Point x3) {
        this.x3 = x3;
    }

    public Point getX4() {
        return x4;
    }

    public void setX4(Point x4) {
        this.x4 = x4;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
