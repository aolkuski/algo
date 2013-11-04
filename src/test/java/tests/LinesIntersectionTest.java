package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import algo.linesdependency.LinesIntersection;
import datastructures.Point;
import datastructures.Section;


public class LinesIntersectionTest {

        @Test
        public void test(){
            
//            System.out.println("Crossing lines");
            Point ax = new Point(-1.0, 0.0);
            Point ay = new Point(1.0, 0.0);
            Point bx = new Point(0.0, -1.0);
            Point by = new Point(0.0, 1.0);
            Section sgmA = new Section(ax, ay);
            Section sgmB = new Section(bx, by);
            assertEquals(1,LinesIntersection.isIntersected(sgmA, sgmB));
//            System.out.println(LinesIntersection.isIntersected(sgmA, sgmB));
            
//            System.out.println("Inline lines");
            ax = new Point(-2.0, 0.0);
            ay = new Point(2.0, 0.0);
            bx = new Point(-1.0, 0.0);
            by = new Point(1.0, 0.0);
            sgmA = new Section(ax, ay);
            sgmB = new Section(bx, by);
            assertEquals(0,LinesIntersection.isIntersected(sgmA, sgmB));
//            System.out.println(LinesIntersection.isIntersected(sgmA, sgmB));
            
//            System.out.println("Same lines");
            ax = new Point(-2.0, 0.0);
            ay = new Point(2.0, 0.0);
            bx = new Point(-2.0, 0.0);
            by = new Point(2.0, 0.0);
            sgmA = new Section(ax, ay);
            sgmB = new Section(bx, by);
            assertEquals(0,LinesIntersection.isIntersected(sgmA, sgmB));
//            System.out.println(LinesIntersection.isIntersected(sgmA, sgmB));
            
//            System.out.println("Sticked in 1 point lines, perpendicular __|__");
            ax = new Point(-2.0, 0.0);
            ay = new Point(2.0, 0.0);
            bx = new Point(0.0, 0.0);
            by = new Point(1.0, 0.0);
            sgmA = new Section(ax, ay);
            sgmB = new Section(bx, by);
            assertEquals(0,LinesIntersection.isIntersected(sgmA, sgmB));
//            System.out.println(LinesIntersection.isIntersected(sgmA, sgmB));
            
//            System.out.println("Sticked in 1 point lines, not perpendicular _\\__");
            ax = new Point(-2.0, 0.0);
            ay = new Point(2.0, 0.0);
            bx = new Point(-3.0, 3.0);
            by = new Point(0.0, 0.0);
            sgmA = new Section(ax, ay);
            sgmB = new Section(bx, by);
            assertEquals(0,LinesIntersection.isIntersected(sgmA, sgmB));
//            System.out.println(LinesIntersection.isIntersected(sgmA, sgmB));
            
//            System.out.println("half line common, inline");
            ax = new Point(-2.0, 0.0);
            ay = new Point(2.0, 0.0);
            bx = new Point(0.0, 0.0);
            by = new Point(3.0, 0.0);
            sgmA = new Section(ax, ay);
            sgmB = new Section(bx, by);
            assertEquals(0,LinesIntersection.isIntersected(sgmA, sgmB));
//            System.out.println(LinesIntersection.isIntersected(sgmA, sgmB));
            
//            System.out.println("Inline, no points common");
            ax = new Point(-2.0, 0.0);
            ay = new Point(0.0, 0.0);
            bx = new Point(1.0, 0.0);
            by = new Point(3.0, 0.0);
            sgmA = new Section(ax, ay);
            sgmB = new Section(bx, by);
            assertEquals(0,LinesIntersection.isIntersected(sgmA, sgmB));
//            System.out.println(LinesIntersection.isIntersected(sgmA, sgmB));
            
//            System.out.println("perpendicular, no points common");
            ax = new Point(-2.0, 0.0);
            ay = new Point(2.0, 0.0);
            bx = new Point(0.0, 1.0);
            by = new Point(0.0, 3.0);
            sgmA = new Section(ax, ay);
            sgmB = new Section(bx, by);
            assertEquals(0,LinesIntersection.isIntersected(sgmA, sgmB));
//            System.out.println(LinesIntersection.isIntersected(sgmA, sgmB));
        }
}
