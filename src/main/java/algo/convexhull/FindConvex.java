package algo.convexhull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import algo.pointdependency.Predicate;

import datastructures.matrix.Matrix;
import datastructures.matrix.MatrixDet;
import datastructures.points.Point;
import datastructures.points.PointsOrder;


public class FindConvex {

    public static Stack<Point> determinConvexHull(ArrayList<Point> points) {
        return getConvexHull(points);
    }
    
    public static ArrayList<Point> determinConvexHullAsArray(ArrayList<Point> points) {
        Stack<Point> convex = getConvexHull(points);
        ArrayList<Point> convexArrayList = new ArrayList<Point>();
        
        while (!convex.isEmpty()){
            convexArrayList.add(convex.pop());
        }
        Collections.reverse(convexArrayList);
        return convexArrayList;
    }
    
    private static Stack<Point> getConvexHull(ArrayList<Point> points) {
        Stack<Point> convex = new Stack<Point>();

        ArrayList<Point> sortedPoints = PointsOrder.sortFromLeftBottom(points);
        sortedPoints = PointsOrder.moveAllPointsAccordingToStartingPoint(sortedPoints);
        Point startPoint = sortedPoints.remove(0);

        sortedPoints = PointsOrder.sortByPolarCoordinates(sortedPoints);
        sortedPoints = removePointsWithSameFi(sortedPoints);

        sortedPoints.add(0, startPoint);

        convex.push(sortedPoints.get(0));
        convex.push(sortedPoints.get(1));
        convex.push(sortedPoints.get(2));
        
        for(int i = 3; i < sortedPoints.size(); i++) {
            Point pTop = convex.elementAt(convex.size() - 1);
            Point pPrevTop = convex.elementAt(convex.size() - 2);
            while (Predicate.determine(MatrixDet.count(new Matrix(pPrevTop, pTop, sortedPoints.get(i)))).equals("right")) {
                convex.pop();
                pTop = convex.elementAt(convex.size() - 1);
                pPrevTop = convex.elementAt(convex.size() - 2);
            }
            convex.push(sortedPoints.get(i));
        }
        return convex;

    }

    private static ArrayList<Point> removePointsWithSameFi(ArrayList<Point> points) {
        ArrayList<Point> cleared = points;
        
        for(int i = 0; i < cleared.size() - 1; i++) {
            Point p1 = cleared.get(i);
            Point p2 = cleared.get(i + 1);
            
            if (p1.getFi() == p2.getFi()) {
                if (p1.getR() > p2.getR()) {
                    cleared.remove(i + 1);
                } else {
                    cleared.remove(i);
                }
                i = i-1;
            }
        }
        return cleared;
    }
    
    
}
