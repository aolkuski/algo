package tests;

import static org.junit.Assert.assertTrue;
import helpers.PointsListsHelper;
import helpers.WrongDataFormatException;

import java.util.ArrayList;

import org.junit.Test;

import algo.convexhull.FindConvex;
import datastructures.Point;

/**
 * wejcie: p1,p2,...,pn wyjcie: zbiór uporzdkowany otoczki wypuklej, co najmniej 3 punkty (n>2),
 * wspolrzedne polarne
 * 
 * @author aolkuski
 * 
 */

public class ConvexHullTest {

    @Test
    public void checkConvex() throws WrongDataFormatException {
        
        ArrayList<Point> points = PointsListsHelper.createPointsList(
            'A', 0.0, 0.0,
            'B', 1.0, 1.0,
            'C', 2.0, 1.0,
            'D', 3.0, 0.0,
            'E', 2.0, 2.0,
            'F', 5.0, 4.0,
            'G', -2.0, 3.0,
            'H', 0.0, 1.0
            );
        ArrayList<Point> convex = FindConvex.determinConvexHullAsArray(points);
        assertTrue(PointsListsHelper.isTheSameOrder(convex, 'A', 'D', 'F', 'G'));
        
        System.out.println("Convex Hull: ");
        for(Point p:convex){
            System.out.println(p.toString());
        }
        
         points = PointsListsHelper.createPointsList(
            'A', 0.0, 0.0,
            'B', 1.0, 1.0,
            'C', 2.0, 1.0,
            'D', 3.0, 0.0,
            'E', 2.0, 2.0,
            'F', 5.0, 4.0,
            'G', -2.0, 3.0,
            'H', 0.0, 1.0,
            'I', 8.0, -8.0,
            'J', 7.0, -7.0
            );
        convex = FindConvex.determinConvexHullAsArray(points);
        assertTrue(PointsListsHelper.isTheSameOrder(convex, 'I', 'F', 'G', 'J'));
        
        System.out.println("Convex Hull: ");
        for(Point p:convex){
            System.out.println(p.toString());
        }
        
        
    }
}
