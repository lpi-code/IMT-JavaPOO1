package fr.minesales.imtjavapoo1.model.geometrie;

public class Parallelogramme extends Trapeze {

    public Parallelogramme() {
        super();
    }
    @Override
    public String type() {
        return "Parallélogramme";
    }


    @Override
    public void updateFigure(Point p1, Point p2, Point p3, Point p4) {

        double dist12 = Math.sqrt(Math.pow(p2.getX() - p1.getX(),2) + Math.pow(p2.getY() - p1.getY(),2));
        double dist23 = Math.sqrt(Math.pow(p3.getX() - p2.getX(),2) + Math.pow(p3.getY() - p2.getY(),2));
        double dist34 = Math.sqrt(Math.pow(p4.getX() - p3.getX(),2) + Math.pow(p4.getY() - p3.getY(),2));
        double dist41 = Math.sqrt(Math.pow(p1.getX() - p4.getX(),2) + Math.pow(p1.getY() - p4.getY(),2));

        if(! (dist12 == dist34 && dist23 == dist41))
            throw new IllegalArgumentException("Ces points ne permettent pas de faire un parallélogramme");

        super.updateFigure(p1, p2, p3, p4);
    }
}

