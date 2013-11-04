package datastructures.matrix;

import datastructures.points.Point;


public class Matrix {
  private Point A, B, C;

  public Matrix(Point pA, Point pB, Point pC){
    this.A = pA;
    this.B = pB;
    this.C = pC;
  }
  
  public Matrix(){}
  
  
  public Point getA() {
    return A;
  }

  
  public void setA(Point a) {
    A = a;
  }

  
  public Point getB() {
    return B;
  }

  
  public void setB(Point b) {
    B = b;
  }

  
  public Point getC() {
    return C;
  }

  
  public void setC(Point c) {
    C = c;
  }

  

  
  
}
