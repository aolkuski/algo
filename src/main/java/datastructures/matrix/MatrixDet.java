package datastructures.matrix;



public class MatrixDet {
 
  public static double count(Matrix m){
    Double value = 1.0;
    value = 
        m.getA().getX() * (m.getB().getY() - m.getC().getY()) -
        m.getA().getY() * (m.getB().getX() - m.getC().getX()) + 
        (m.getB().getX() * m.getC().getY()) -
        (m.getC().getX() * m.getB().getY());
    
    return value;
  }
}
