package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import algo.linesdependency.AllLinesIntersection;
import datastructures.points.Point;


public class AllLinesIntersectionTest {

    @Test
    public void test(){
//        System.out.println("4-, non-linear points figure");
        Point ax = new Point(-2.0, 0.0);
        Point ay = new Point(2.0, 0.0);
        Point bx = new Point(-1.0, -1.0);
        Point by = new Point(1.0, -1.0);
        
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(ax);
        points.add(ay);
        points.add(bx);
        points.add(by);
        
        
        AllLinesIntersection ali = new AllLinesIntersection();
        assertEquals(1,ali.pointIntersections(points));
        
//        System.out.println("5-, non-linear points figure (star)");
        Point d = new Point(0.0, 1.0);
        points.add(d);
        ali = new AllLinesIntersection();
        assertEquals(5,ali.pointIntersections(points));
        
    }
}
