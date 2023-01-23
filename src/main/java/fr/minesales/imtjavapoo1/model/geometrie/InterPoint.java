package fr.minesales.imtjavapoo1.model.geometrie;

public interface InterPoint {
    public double distance(InterPoint p);
    public double distance(double x, double y);
    public double getX();
    public double getY();

}
