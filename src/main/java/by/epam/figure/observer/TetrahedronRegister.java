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

    public double getSquare() {
        return square;
    }

    public double getVolume() {
        return volume;
    }
}
