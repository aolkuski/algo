package datastructures.points;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class PointsOrder {

    public static ArrayList<Point> sortFromLeftBottom(ArrayList<Point> points) {
        ArrayList<Point> sortedPoints = new ArrayList<Point>();
        sortedPoints = points;

        Collections.sort(points, new XComparator());
        Collections.sort(points, new YComparator());

        return sortedPoints;
    }

    public static ArrayList<Point> sortByPolarCoordinates(ArrayList<Point> points) {
        ArrayList<Point> sortedPoints = new ArrayList<Point>();
        sortedPoints = points;       
        return sortBy(sortedPoints, new PolarComparator());
    }
    
    public static ArrayList<Point> sortById(ArrayList<Point> points){
        ArrayList<Point> sortedPoints = new ArrayList<Point>();
        sortedPoints = points;       
        return sortBy(sortedPoints, new IdComparator());
    }
    
    private static ArrayList<Point> sortBy(ArrayList<Point> points, Comparator<Point> comp){
        ArrayList<Point> sortedPoints = new ArrayList<Point>();
        sortedPoints = points;

        Collections.sort(sortedPoints, comp);
        return sortedPoints;
    }

    public static ArrayList<Point> moveAllPointsAccordingToStartingPoint(ArrayList<Point> sortedPoints) {
        double x = 0 - sortedPoints.get(0).getX();
        double y = 0 - sortedPoints.get(0).getY();

        for(Point p : sortedPoints) {
            p.setX(p.getX()+x);
            p.setY(p.getY()+y);
            p.recalculateFi();
        }
        return sortedPoints;
    }
}
