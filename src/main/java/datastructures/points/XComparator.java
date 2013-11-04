package datastructures.points;

import java.util.Comparator;


public class XComparator implements Comparator<Point>{

    public int compare(Point o1, Point o2) {
        
        return (int) (o1.getX() - o2.getX());
    }

}
