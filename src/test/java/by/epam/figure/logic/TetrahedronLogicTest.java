package by.epam.figure.logic;

import by.epam.figure.bean.Point;
import by.epam.figure.bean.Tetrahedron;
import by.epam.figure.dao.TetrahedronParser;
import by.epam.figure.dao.TetrahedronReader;
import by.epam.figure.exception.DAOException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class TetrahedronLogicTest {
    private final double DELTA = 0.1;
    private static TetrahedronLogic tetrahedronLogic;
    private static Tetrahedron tetrahedron;
    private static final String FILE_PATH = "src/test/resources/testData.txt";

    @BeforeClass
    public static void initializeTetrahedron(){
        tetrahedronLogic = new TetrahedronLogic();
        try {
        TetrahedronReader reader = new TetrahedronReader(new File(FILE_PATH));
            TetrahedronParser parser = new TetrahedronParser();
            List<Double> coordinatesList = parser.parse(reader.getLine());
            Point x1 = new Point (coordinatesList.get(0), coordinatesList.get(1), coordinatesList.get(2));
            Point x2 = new Point (coordinatesList.get(3), coordinatesList.get(4), coordinatesList.get(5));
            Point x3 = new Point (coordinatesList.get(6), coordinatesList.get(7), coordinatesList.get(8));
            Point x4 = new Point (coordinatesList.get(9), coordinatesList.get(10), coordinatesList.get(11));
            tetrahedron = new Tetrahedron(x1, x2, x3, x4);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void volumeTetrahedronTrue(){
        double expected = 216.667;
        double actual = tetrahedronLogic.volume(tetrahedron);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void IsTetrahedronTrue(){
        Assert.assertTrue(tetrahedronLogic.isTetrahedron(tetrahedron));
    }

    @Test
    public void squareTetrahedronTrue(){
        double expected = 104.62 + 50 + 130;
        double actual=tetrahedronLogic.square(tetrahedron);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void IsTetrahedronBaseOnCoordinatePlaneTrue(){
        Assert.assertFalse(tetrahedronLogic.isTetrahedronOnPlane(tetrahedron));
    }

    @Test
    public void TetrahedronSplitByCoordinatePlaneTrue(){
        double expected = 48 / (216.667 - 48);
        double actual=tetrahedronLogic.ratioOfPartsOfTetrahedron(tetrahedron);
        Assert.assertEquals(actual, expected, DELTA);
    }
}
