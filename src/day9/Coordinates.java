package day9;

import java.awt.geom.Point2D;

public class Coordinates {
    private  int x;
    private  int y;
    private  Coordinates head;

    public Coordinates(int x, int y, Coordinates head){
        this.x = x;
        this.y = y;
        this.head = head;
    }

    public boolean isStepPossible(){
        double distance = Point2D.distance(this.x, this.y, this.head.x, this.head.y);
        return !(distance <= 1.4142135623730951);

    }

    public double findDirection(){
        int xHead = head.getX();
        int yHead = head.getY();
        double pi = Math.atan2(yHead - this.y, xHead - this.x);
        return pi * 180 / Math.PI;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinates getHead() {
        return head;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHeadX(int x) {
        this.head.setX(x);
    }

    public void setHeadY(int y) {
        this.head.setY(y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.getX() &&
                y == that.getY();
    }

    public static void main(String[] args) {
        System.out.println(Point2D.distance(10, 10, 11, 11));
    }
}
