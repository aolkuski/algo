package algo.linesdependency;

import datastructures.matrix.Matrix;
import datastructures.matrix.MatrixDet;
import datastructures.sections.Section;


public class LinesIntersection {

    public static Double[] pointsDependency(Section lineA, Section lineB) {
        double val1, val2, val3, val4;

        // line A with 'b' point from line B
        Matrix matr = new Matrix();
        matr.setA(lineA.getA());
        matr.setB(lineA.getB());
        matr.setC(lineB.getA());
        val1 = MatrixDet.count(matr);
        
        // line A with 'a' point from line B
        matr.setC(lineB.getB());
        val2 = MatrixDet.count(matr);

        // line B with 'a' point from line B
        matr.setA(lineB.getA());
        matr.setB(lineB.getB());
        matr.setC(lineA.getA());
        val3 = MatrixDet.count(matr);

        // line B with 'b' point from line B
        matr.setC(lineA.getB());
        val4 = MatrixDet.count(matr);
        
        return new Double[]{val1, val2, val3, val4};
    }

    
    public static int isIntersected(Section lineA, Section lineB){
        int val = check(pointsDependency(lineA, lineB));
        // debug mode: crossing lines (8 times more...)
//        if(val == 1){
//            System.out.println("{\n\t"+lineA+"\n\t"+lineB+"\n}");
//        }
        return val;
    }
    
    private static int check(Double[] linesDependency){
        
        
        if((linesDependency[0] * linesDependency[1] < 0) && (linesDependency[2] * linesDependency[3] < 0)){
            return 1;
        }
        
        if((linesDependency[0] * linesDependency[1] > 0) && (linesDependency[2] * linesDependency[3] > 0)){
            return -1;
        }
       
        return 0;
    }
}
