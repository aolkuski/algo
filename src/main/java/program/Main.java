package program;

import algo.linesdependency.LinesIntersection;
import datastructures.Point;
import datastructures.Section;


public class Main {

    public static void main(String args[]) {
        Point ax = new Point(-2.0, 0.0);
        Point ay = new Point(2.0, 0.0);

        Point bx = new Point(3.0, 1.0);
        Point by = new Point(3.0, 3.0);

        Section sgmA = new Section(ax, ay);
        Section sgmB = new Section(bx, by);


        System.out.println(LinesIntersection.isIntersected(sgmA, sgmB));

    }
}
