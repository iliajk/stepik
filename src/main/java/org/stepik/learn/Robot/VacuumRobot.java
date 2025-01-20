package org.stepik.learn.Robot;

import java.util.ArrayList;
import java.util.List;

public class VacuumRobot extends Robot {
    private int[] dimension;

    public VacuumRobot(int x, int y, Direction direction) {
        super(x, y, direction);
    }

    public int[] getDimension(){
        return dimension;
    }

    public int getX(){
        System.out.println("Vacuum Robot X Position = " + super.getX());
        return super.getX();
    }


    public int getY(){
        System.out.println("Vacuum Robot Y Position = " + super.getY());
        return super.getY();
    }

}