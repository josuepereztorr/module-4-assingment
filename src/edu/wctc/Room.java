package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {

    private List<Wall> wallList = new ArrayList<>();

    public Room(double width, double length, double height) {

        // width and height
        Wall wall1 = new Wall(width, height);
        Wall wall2 = new Wall(width, height);

        // length and height
        Wall wall3 = new Wall(length, height);
        Wall wall4 = new Wall(length, height);

        wallList.add(wall1);
        wallList.add(wall2);
        wallList.add(wall3);
        wallList.add(wall4);
    }

    public double getArea() {
        double area = 0;

        for (Wall w : wallList) {
            area += w.getArea();
        }

        return  area;
    }

    public String toString() {
        return String.format("%s", getArea());
    }
}
