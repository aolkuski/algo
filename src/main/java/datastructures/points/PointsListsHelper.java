package datastructures.points;


import java.util.ArrayList;

import exceptions.WrongDataFormatException;



public class PointsListsHelper {

    public static ArrayList<Point> createPointsList(Object... args) throws WrongDataFormatException {
        ArrayList<Point> points = new ArrayList<Point>();

        for(int i = 0; i < args.length-2; i += 3) {
            char id = '0';
            int intId = 0;
            double x = 0.0;
            double y = 0.0;
            if (args.length % 3 != 0) {
                throw new WrongDataFormatException("Each Point must consist of three values: Character (id), Double (x coordinate), Double (y coordinate)");
            }
            if (args[i] instanceof Character) {
                id = (Character) args[i];
            } else if(args[i] instanceof Integer){
                intId = (Integer)args[i];
            }else{
                throw new WrongDataFormatException("First in each triple must be Character object - id of a point to create.");
            }
            if (args[i + 1] instanceof Double) {
                x = (Double) args[i + 1];
            } else if(args[i + 1] instanceof Integer){
                x = Double.valueOf(String.valueOf(args[i + 1]));
            } else{
                throw new WrongDataFormatException("Second in each triple must be Double object - first coordinate of a point to create.");
            }
            if (args[i + 2] instanceof Double) {
                y = (Double) args[i + 2];
            } else if(args[i + 2] instanceof Integer){
                y = Double.valueOf(String.valueOf(args[i + 2]));
            } else{
                throw new WrongDataFormatException("Second in each triple must be Double object - first coordinate of a point to create.");
            }
            Point pt = null;
            if(id == '0'){
                pt = new Point(intId, x, y);
            } else {
                pt = new Point(id, x, y);
            }
            points.add(pt);
        }

        return points;
    }

    public static ArrayList<String> getPointsOrder(ArrayList<Point> points) {
        return getPointsIds(points);
    }

    public static boolean isTheSameOrder(ArrayList<Point> points, Object... chars) {
        if (points.size() != chars.length) {
            System.out.println(points.size()+" != "+chars.length);
            return false;
        }
        int i = 0;
        for(Point p : points) {
            if (!p.getId().equals(String.valueOf(chars[i]))) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static ArrayList<String> getPointsIds(ArrayList<Point> points) {
        ArrayList<String> ids = new ArrayList<String>();
        for(Point p : points) {
            ids.add(p.getId());
        }
        return ids;
    }

}
