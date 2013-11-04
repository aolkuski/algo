package algo.pointdependency;

import java.util.ArrayList;

import datastructures.matrix.Matrix;
import datastructures.matrix.MatrixDet;
import datastructures.points.Point;


public class ListPredicate {

    ArrayList<Point> right = new ArrayList<Point>();
    ArrayList<Point> left = new ArrayList<Point>();
    ArrayList<Point> inline = new ArrayList<Point>();

    ArrayList<Point> pointsToAssert = new ArrayList<Point>();

    Point a = new Point();
    Point b = new Point();

    public ListPredicate(Point pA, Point pB) {
        this.a = pA;
        this.b = pB;
    }

    public void assertList(ArrayList<Point> pts) {

        for(Point d : pts) {
            Matrix matr = new Matrix(a, b, d);
            double det = MatrixDet.count(matr);
            if (det < 0) {
                right.add(d);
            } else if (det > 0) {
                left.add(d);
            } else {
                inline.add(d);
            }
        }
    }
    
    public void assertList(Point... pts) {

        for(Point p : pts) {
            pointsToAssert.add(p);
        }

        for(Point d : pointsToAssert) {
            Matrix matr = new Matrix(a, b, d);
            double det = MatrixDet.count(matr);
            if (det < 0) {
                right.add(d);
            } else if (det > 0) {
                left.add(d);
            } else {
                inline.add(d);
            }
        }
    }

    public ArrayList<Point> getRight() {
        return this.right;
    }

    public ArrayList<Point> getLeft() {
        return this.left;
    }

    public ArrayList<Point> getInline() {
        return this.inline;
    }

    public void printResults() {

        System.out.println("Points on the left: ");
        for(Point p : left) {
            System.out.println(p);
        }

        System.out.println("Points on the right: ");
        for(Point p : right) {
            System.out.println(p);
        }

        System.out.println("Points inline: ");
        for(Point p : inline) {
            System.out.println(p);
        }
    }
}
