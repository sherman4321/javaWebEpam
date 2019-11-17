package by.epam.figure.logic;

import by.epam.figure.bean.Vector3D;

public class Vector3DLogic {
    public static double length(Vector3D vector3D){
        double x = vector3D.getX();
        double y = vector3D.getY();
        double z = vector3D.getZ();
        return Math.sqrt(x*x + y*y + z*z);
    }
}
