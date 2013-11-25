package datastructures.points;

import java.util.Comparator;


public class IdComparator implements Comparator<Point> {

    public int compare(Point o1, Point o2) {
        if (Integer.valueOf(o1.getId()) - Integer.valueOf(o2.getId()) < 0) {
            return -1;
        } else if (Integer.valueOf(o1.getId()) - Integer.valueOf(o2.getId()) > 0) {
            return 1;
        }
        return 0;
    }

}
