package tests;

import java.util.ArrayList;

import org.junit.Test;


import datastructures.points.Point;
import datastructures.points.PointsOrder;


public class SortingPointsTest {

    @Test
    public void checkOrder(){
        Point A = new Point(-2.0, 0.0);
        Point B = new Point(2.0, 0.0);
        Point C = new Point(-1.0, -1.0);
        Point D = new Point(3.0, -1.0);
        Point E = new Point(0.0, 0.0);
        Point F = new Point(1.0, 1.0);
        
        ArrayList<Point> points= new ArrayList<Point>();
        points.add(A);
        points.add(B);
        points.add(C);
        points.add(D);
        points.add(E);
        points.add(F);
        
        ArrayList<Point> sorted = PointsOrder.sortFromLeftBottom(points);
        
        for(Point p:sorted){
            System.out.println(p.toString());
        }
    }
}
