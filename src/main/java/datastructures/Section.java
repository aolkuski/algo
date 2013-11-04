package datastructures;


public class Section {
    private Point a;
    private Point b;
    
    public Section(double aX, double aY, double bX, double bY){
        this.a = new Point(aX, aY);
        this.b = new Point(bX, bY);
    }
    
    public Section(Point pA, Point pB){
        this.a = pA;
        this.b = pB;
    }
    
    public Section(){}
    
    public Point getA() {
        return a;
    }
    
    public void setA(Point a) {
        this.a = a;
    }
    
    public Point getB() {
        return b;
    }
    
    public void setB(Point b) {
        this.b = b;
    }
    
    public String toString(){
        return "Line has points A: "+this.a+" and B: "+this.b;
    }
}
