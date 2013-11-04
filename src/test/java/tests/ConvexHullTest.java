package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import algo.convexhull.FindConvex;
import datastructures.points.Point;
import datastructures.points.PointsListsHelper;
import exceptions.WrongDataFormatException;

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
//        assertTrue(PointsListsHelper.isTheSameOrder(convex, 'A', 'D', 'F', 'G'));
        
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
            'J', 7.0, -7.0,
            'K', 2.0, 3.0,
            'L', -0.5, 45.1,
            'M', -1.333, -5.444
            );
        convex = FindConvex.determinConvexHullAsArray(points);
        assertTrue(PointsListsHelper.isTheSameOrder(convex, 'I', 'L', 'G', 'M'));
        
        System.out.println("Convex Hull: ");
        for(Point p:convex){
            System.out.println(p.toString());
        }
        
        points = PointsListsHelper.createPointsList(
             0, 14, 56 , 
             1, 46, 89 , 
             2, 99, 8 , 
             3, 77, 32 , 
             4, 60, 82 , 
             5, 16, 98 , 
             6, 66, 69 , 
             7, 81, 22 , 
             8, 77, 18 , 
             9, 77, 23 , 
             10, 39, 7 , 
             11, 69, 95 , 
             12, 15, 78 , 
             13, 70, 9 , 
             14, 36, 20 , 
             15, 6, 27 , 
             16, 44, 68 , 
             17, 49, 48 , 
             18, 35, 26 , 
             19, 54, 98 , 
             20, 31, 2 , 
             21, 63, 92 , 
             22, 37, 22 , 
             23, 3, 3 , 
             24, 43, 81 
            );
        convex = FindConvex.determinConvexHullAsArray(points);
        assertTrue(PointsListsHelper.isTheSameOrder(convex, 20, 2, 11, 19, 5, 15, 23));
        
        System.out.println("Convex Hull: ");
        for(Point p:convex){
            System.out.println(p.toString());
        }
        
        
    }
}
