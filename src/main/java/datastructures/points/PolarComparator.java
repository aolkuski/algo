package datastructures.points;

import java.util.Comparator;


public class PolarComparator implements Comparator<Point> {

    public int compare(Point o1, Point o2) {
        if (o1.getFi() - o2.getFi() < 0) {
            return -1;
        } else if (o1.getFi() - o2.getFi() > 0) {
            return 1;
        }
        return 0;
    }

}
