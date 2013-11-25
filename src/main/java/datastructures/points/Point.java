package datastructures.points;


public class Point {

    private char id;

    public String getId() {
        if(this.getIntId() != 0) {
            return String.valueOf(this.getIntId());
        } else {
            return String.valueOf(id);
        }
    }

    public void setId(char id) {
        this.id = id;
    }

    private double x;
    private double y;
    private double r;
    private double fi;
    private int intId;


    
    public int getIntId() {
        return intId;
    }

    
    public void setIntId(int intId) {
        this.intId = intId;
    }

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
    
    public Point(int pId, Double pX, Double pY) {
        this.x = pX;
        this.y = pY;
        this.r = Math.sqrt(this.x * this.x + this.y * this.y);
        this.fi = countFi();
        this.intId = pId;
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
        return "ID: "+this.getId()+", x = " + this.getX() + ", y = " + this.getY() + ", r = " + this.getR() + ", fi = " + this.getFi();
    }
    
    public void recalculateFi(){
        this.fi = this.countFi();
    }

    private double countFi() {
        if (x > 0.0 && y >= 0.0) {
            return Math.atan(y / x);
        }
        if (x > 0.0 && y < 0.0) {
            return Math.atan(y / x) + 2.0 * Math.PI;
        }
        if (x < 0.0) {
            return Math.atan(y / x) + Math.PI;
        }
        if (x == 0.0 && y > 0.0) {
            return Math.PI / 2.0;
        }
        if (x == 0.0 && y < 0.0) {
            return Math.PI * 3.0 / 2.0;
        }
        return 0.0;

    }



}
