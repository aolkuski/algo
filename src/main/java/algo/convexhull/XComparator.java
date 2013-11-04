package algo.convexhull;

import java.util.Comparator;

import datastructures.Point;

public class XComparator implements Comparator<Point>{

    public int compare(Point o1, Point o2) {
        
        return (int) (o1.getX() - o2.getX());
    }

}
