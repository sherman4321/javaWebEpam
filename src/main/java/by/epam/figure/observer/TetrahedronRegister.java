package by.epam.figure.observer;

import by.epam.figure.bean.Tetrahedron;
import by.epam.figure.logic.TetrahedronLogic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetrahedronRegister implements Observer<Tetrahedron> {
    private static final Logger logger= LogManager.getLogger(TetrahedronRegister.class);

    private TetrahedronLogic tetrahedronLogic;
    private double square;
    private double volume;

    public TetrahedronRegister(Tetrahedron tetrahedron) {
        tetrahedronLogic = new TetrahedronLogic();
        square = tetrahedronLogic.findSquare(tetrahedron);
        volume = tetrahedronLogic.findVolume(tetrahedron);
    }

    @Override
    public void update(Tetrahedron tetrahedron) {
        square = tetrahedronLogic.findSquare(tetrahedron);
        volume = tetrahedronLogic.findVolume(tetrahedron);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TetrahedronRegister register = (TetrahedronRegister) o;
        return Double.compare(register.square, square) == 0 &&
                Double.compare(register.volume, volume) == 0 &&
                Objects.equals(tetrahedronLogic, register.tetrahedronLogic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tetrahedronLogic, square, volume);
    }

    public double getSquare() {
        return square;
    }

    public double getVolume() {
        return volume;
    }
}
