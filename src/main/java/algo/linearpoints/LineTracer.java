/**
 * 
 */
package algo.linearpoints;

import java.util.ArrayList;
import java.util.Collections;

import algo.convexhull.FindConvex;

import com.sun.org.apache.bcel.internal.generic.PUTSTATIC;

import datastructures.points.Point;
import datastructures.points.PointsListsHelper;
import datastructures.points.PointsOrder;
import datastructures.points.PolarComparator;


/**
 * @author aolkuski
 * 
 */
public class LineTracer {
    
    // znajdz punkty brzegowe
    // znajdz ten punkt w liscie wszystkich punktow
    // 
    // dla kazdego z punktow brzegowych
    /*
     * przesun punkty do 0,0 wzgldem znalezionego wczesniej punktu
     * posortuj liste po fi
     * usun pojedyncze wystapienia punktow (unikatowe fi)
     * dla punktow o tym samym fi:
     *      utworz nowa liste
     *      dodaj punkty
     *      posortuj po ID
     *      sprawdz, czy istnieje to ju¿ w zbiorze, jesli nie --> dodaj do zbioru
     * 
     */
    // posortuj liste po dlugosci list w srodku
    /**
     * 
     * @param points list of all poits
     * @return
     */
    public static ArrayList<ArrayList<Point>> findAllUniqueLines(final ArrayList<Point> points, double accuracy){
        
        // list of all lists of linear points
        ArrayList<ArrayList<Point>> result = new ArrayList<ArrayList<Point>>();
        // list of String, which are representation of all unique line sets;
        ArrayList<String> resultIds = new ArrayList<String>();
        
                
        @SuppressWarnings("unchecked")
		ArrayList<Point> boundaryPoints = (ArrayList<Point>) points.clone();
        
        
        for(Point p: boundaryPoints){
            @SuppressWarnings("unchecked")
            ArrayList<Point> tempPoints = (ArrayList<Point>) points.clone(); 
            int pos = findPointPositionById(p, points);
            
            Point startingPoint = tempPoints.remove(pos);
            tempPoints.add(0, startingPoint);
            ArrayList<Point> movedPoints = PointsOrder.moveAllPointsAccordingToStartingPoint(points);
            ArrayList<Point> sortedPoints = PointsOrder.sortByPolarCoordinates(movedPoints);
            Point tmpStartingPoint = sortedPoints.remove(0);
            for(int i=0; i<sortedPoints.size(); i++){
                Point p1 = tempPoints.get(i);
                ArrayList<Point> newLine = findPointsWithSameFi(sortedPoints, p1, accuracy);
                newLine.add(0, tmpStartingPoint);
                    boolean flag = true;
                    ArrayList<Point> sortedNewLine = PointsOrder.sortById(newLine);
                    String ident = PointsListsHelper.getListIdsAsString(sortedNewLine);
                    System.out.println(ident);
                    for(int k = 0; k<resultIds.size(); k++){
                        if (resultIds.get(k).contains(ident)){
                            flag = false;
                        }
                    }
                    
                    if(flag){
                        result.add(newLine);
                        resultIds.add(ident);
                    }
                    
            }
        }
        
        return result;
    }

    private static ArrayList<Point> findPointsWithSameFi(ArrayList<Point> sortedPoints, Point p, double accuracy){
        ArrayList<Point> res = new ArrayList<Point>();
        res.add(sortedPoints.get(0));
        double fi = p.getFi();
        for(int j = 1; j<sortedPoints.size(); j++){
            if((fi - sortedPoints.get(j).getFi()) < accuracy){
            	if((fi - sortedPoints.get(j).getFi()) > (-1.0*accuracy)){
            		res.add(sortedPoints.get(j));
            	} else {
            		break;
            	}
            }
        }
        return res;
    }
    
    private static int findPointPositionById(Point p, ArrayList<Point> points){
        int position = 0;
        for(int i=0;i<points.size();i++){
            if(points.get(i).getId().equals(p.getId())){
                position = i;
                break;
            }
        }
        return position;
    }
    
    private static ArrayList<Point> sortByFi(ArrayList<Point> points) {
        ArrayList<Point> sortedPoints = PointsOrder.sortFromLeftBottom(points);
        sortedPoints = PointsOrder.moveAllPointsAccordingToStartingPoint(sortedPoints);
        Point startPoint = sortedPoints.remove(0);
        sortedPoints = PointsOrder.sortByPolarCoordinates(sortedPoints);
        sortedPoints.add(0, startPoint);
        return sortedPoints;
    }
    
    public static ArrayList<Point> getBoundaryPoints(ArrayList<Point> sortedPoints) {
        return removePointsWithSameFi(sortedPoints);
    }
    
    private static ArrayList<Point> removePointsWithSameFi(ArrayList<Point> points) {
        ArrayList<Point> cleared = points;

        for(int i = 0; i < cleared.size() - 1; i++) {
            Point p1 = cleared.get(i);
            Point p2 = cleared.get(i + 1);

            if (p1.getFi() == p2.getFi()) {
                if (p1.getR() > p2.getR()) {
                    cleared.remove(i + 1);
                } else {
                    cleared.remove(i);
                }
                i = i - 1;
            }
        }
        return cleared;
    }
    
    public static ArrayList<Point> determineLongestList(ArrayList<ArrayList<Point>> lists){
        ArrayList<Point> longest = new ArrayList<Point>();
        for(ArrayList<Point> list:lists){
        	System.out.println(list.size());
            if(longest.size() < list.size()){
                longest = list;
            }
        }
        return longest;
    }
}
