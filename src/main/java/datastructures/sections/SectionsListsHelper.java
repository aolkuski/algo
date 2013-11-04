package datastructures.sections;


import java.util.ArrayList;

import datastructures.points.Point;
import datastructures.points.PointsListsHelper;
import exceptions.WrongDataFormatException;


public class SectionsListsHelper {

    public static ArrayList<Section> createSectionsList(Object... obj) throws WrongDataFormatException{
        ArrayList<Point> points = PointsListsHelper.createPointsList(obj);
        ArrayList<Section> sections = new ArrayList<Section>();
        if(points.size()%2 != 0){
            throw new WrongDataFormatException("Odd number of points. Cannot create Sections properly.");
        }
        
        for(int i=0; i<points.size()-1;i+=2){
            Section sect = new Section(points.get(i), points.get(i+1));
            sections.add(sect);
        }
        return sections;
    }
}
