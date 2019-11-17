package by.epam.figure.dao;

import by.epam.figure.bean.Point;
import by.epam.figure.bean.Tetrahedron;
import by.epam.figure.exception.DAOException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TetrahedronCreator {
    private final int NUMBER_OF_POINTS = 4;
    private final int NUMBER_OF_POINT_CHARACTERISTICS = 3;
    private final String FILE_PATH = "data/input.txt";

    public Tetrahedron createTetrahedronFromFile() throws DAOException {

        File file = new File(FILE_PATH);
        try (TetrahedronReader fileReader = new TetrahedronReader(file)) {
            String string = fileReader.getLine();

            TetrahedronParser parser = new TetrahedronParser();
            List<Double> coordinates = parser.parse(string);
            return createTetrahedron(coordinates);
        }
    }

    private Tetrahedron createTetrahedron(List<Double> coordinates){
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_POINTS; ++i) {
            int j = 0;
            double x = coordinates.get(i * NUMBER_OF_POINT_CHARACTERISTICS + j++);
            double y = coordinates.get(i * NUMBER_OF_POINT_CHARACTERISTICS + j++);
            double z = coordinates.get(i * NUMBER_OF_POINT_CHARACTERISTICS + j);
            points.add(new Point(x, y, z));
        }

        Point x1 = points.get(0);
        Point x2 = points.get(1);
        Point x3 = points.get(2);
        Point x4 = points.get(3);

        return new Tetrahedron(x1, x2, x3, x4);
    }

    public List<Tetrahedron> createAllTetrahedronsFromFile() throws DAOException {
        File file = new File(FILE_PATH);
        try (TetrahedronReader fileReader = new TetrahedronReader(file)) {
            String string = fileReader.getLine();

            TetrahedronParser parser = new TetrahedronParser();
            List<Double> listOfDouble = parser.parse(string);

            List<Tetrahedron> tetrahedronList = new ArrayList<>();
            while (true) {
                if (!listOfDouble.isEmpty()) {
                    tetrahedronList.add(createTetrahedron(listOfDouble));
                }
                string = fileReader.getLine();
                if (string == null) {
                    break;
                }

                listOfDouble = parser.parse(string);
            }
            return tetrahedronList;
        }
    }
}
