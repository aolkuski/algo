package algo.linesdependency;


import java.util.ArrayList;

import datastructures.points.Point;
import datastructures.sections.Section;


public class AllLinesIntersection {
    Point A, B, C, D = new Point();
    Section lineA, lineB = new Section();
    int counter = 0;
    
    
    public int pointIntersections(ArrayList<Point> points){
        for(int i=0;i<points.size();i++){
            for(int j=0;j<points.size();j++){
                if(points.get(i) == points.get(j))
                    continue;
                for(int k=0; k<points.size(); k++){
                    for(int l=0; l<points.size(); l++){
                        if(points.get(k) == points.get(l))
                            continue;
                        lineA = new Section(points.get(i), points.get(j));
                        lineB = new Section(points.get(k), points.get(l));
                        if(LinesIntersection.isIntersected(lineA, lineB) == 1){
                            counter++;
                        }
                    }
                }
                
            }
           
        }
        return counter/8;
    }
}
