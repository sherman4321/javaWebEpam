package by.epam.figure.observer;

import by.epam.figure.bean.Tetrahedron;
import by.epam.figure.logic.TetrahedronLogic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Registrator implements Observer {
    private static final Logger logger= LogManager.getLogger(Registrator.class);

    private TetrahedronLogic tetrahedronLogic;
    private double square;
    private double volume;

    @Override
    public void update(Tetrahedron tetrahedron) {
        square = tetrahedronLogic.square(tetrahedron);
        volume = tetrahedronLogic.volume(tetrahedron);
    }

    public double getSquare() {
        return square;
    }

    public double getVolume() {
        return volume;
    }
}
