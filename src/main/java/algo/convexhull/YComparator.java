package algo.convexhull;

import java.util.Comparator;

import datastructures.Point;

public class YComparator implements Comparator<Point>{

    public int compare(Point o1, Point o2) {
        
        return (int) (o1.getY() - o2.getY());
    }

}