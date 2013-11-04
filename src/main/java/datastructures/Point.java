package datastructures;


public class Point {

    private char id;

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    private double x;
    private double y;
    private double r;
    private double fi;


    public double getR() {
        return r;
    }


    public void setR(double r) {
        this.r = r;
    }


    public double getFi() {
        if (this.fi == 0) this.fi = countFi();
        return this.fi;
    }


    public Point() {}

    public Point(Double pX, Double pY) {
        this.x = pX;
        this.y = pY;
        this.r = Math.sqrt(this.x * this.x + this.y * this.y);
        this.fi = countFi();
    }
    
    public Point(char pId, Double pX, Double pY) {
        this.x = pX;
        this.y = pY;
        this.r = Math.sqrt(this.x * this.x + this.y * this.y);
        this.fi = countFi();
        this.id = pId;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


    public String toString() {
        if (this.fi == 0) this.fi = countFi();
        return "ID: "+this.getId()+", x = " + this.getX() + ", y = " + this.getY() + ", r = " + this.getR() + ", fi = " + this.getFi();
    }
    
    public void recalculateFi(){
        this.fi = this.countFi();
    }

    private double countFi() {
        if (x > 0 && y >= 0) {
            return Math.atan(y / x);
        }
        if (x > 0 && y < 0) {
            return Math.atan(y / x) + 2 * Math.PI;
        }
        if (x < 0) {
            return Math.atan(y / x) + Math.PI;
        }
        if (x == 0 && y > 0) {
            return Math.PI / 2;
        }
        if (x == 0 && y < 0) {
            return Math.PI * 3 / 2;
        }
        return 0.0;

    }



}
