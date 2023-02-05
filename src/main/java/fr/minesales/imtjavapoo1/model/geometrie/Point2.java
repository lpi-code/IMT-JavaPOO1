package fr.minesales.imtjavapoo1.model.geometrie;

/*
 * This is the class for Point2.
 * Author: @Piernas Loïc, Jaubert Nicolas
 */
public class Point2 implements InterPoint {
    private double r;
    private double theta;
    public Point2(double r, double theta) {
        this.r = r;
        this.theta = theta;
    }

    public Point2() {
        this(0, 0);
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public double distance(InterPoint p) {
        return Math.sqrt(Math.pow(p.getX() - this.getX(), 2) + Math.pow(p.getY() - this.getY(), 2));
    }

    public double distance(double x, double y) {
        return Math.sqrt(Math.pow(x - this.getX(), 2) + Math.pow(y - this.getY(), 2));
    }

    public double getX() {
        return this.r * Math.cos(this.theta);
    }

    public double getY() {
        return this.r * Math.sin(this.theta);
    }
}
