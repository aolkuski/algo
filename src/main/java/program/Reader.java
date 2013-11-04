package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import datastructures.Point;


public class Reader {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static Point readPoint() throws IOException {

        Point pt = new Point();
        System.out.println("\r\tEnter x coordinante");
        String line = in.readLine();
        pt.setX(Double.valueOf(line));
        System.out.println("\r\tEnter y coordinante");
        line = in.readLine();
        pt.setY(Double.valueOf(line));

        return pt;
    }

    public static ArrayList<Point> readPoints(int numberOfPoints) throws IOException {
        ArrayList<Point> points = new ArrayList<Point>();
        for(int i=1;i<=numberOfPoints; i++){
            System.out.println("Point no. "+i);
            points.add(readPoint());
        }
        System.out.println("Reading finished.");
        
        return points;
    }
    
}
