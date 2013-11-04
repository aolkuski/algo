package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import datastructures.Matrix;
import datastructures.Point;

import algo.pointdependency.MatrixDet;
import algo.pointdependency.Predicate;


public class PointsDependencyTest {

    @Test
    public void pointsDependency(){
        
        Point A = new Point(-2.0, 0.0);
        Point B = new Point(2.0, 0.0);
        Point C = new Point(-1.0, -1.0);
        Point D = new Point(3.0, -1.0);
        Point E = new Point(0.0, 0.0);
        Point F = new Point(1.0, 1.0);
        
        assertEquals("inline", Predicate.determine(MatrixDet.count(new Matrix(A, B, E))));
        assertEquals("inline", Predicate.determine(MatrixDet.count(new Matrix(B, A, E))));
        assertEquals("inline", Predicate.determine(MatrixDet.count(new Matrix(A, E, B))));
        assertEquals("inline", Predicate.determine(MatrixDet.count(new Matrix(E, B, A))));
        assertEquals("right", Predicate.determine(MatrixDet.count(new Matrix(A, B, C))));
        assertEquals("right", Predicate.determine(MatrixDet.count(new Matrix(A, B, D))));
        assertEquals("left", Predicate.determine(MatrixDet.count(new Matrix(C, B, A))));
        assertEquals("left", Predicate.determine(MatrixDet.count(new Matrix(E, F, A))));
        assertEquals("right", Predicate.determine(MatrixDet.count(new Matrix(F, E, A))));
    }
}
