package fr.minesales.imtjavapoo1.model.geometrie;

/*
 * This is an interface which is used by two different class of point.
 * Author: @Piernas Loïc, Jaubert Nicolas
 */
public interface InterPoint {
    public double distance(InterPoint p);
    public double distance(double x, double y);
    public double getX();
    public double getY();

}
