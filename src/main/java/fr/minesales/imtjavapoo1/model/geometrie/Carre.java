package fr.minesales.imtjavapoo1.model.geometrie;

/*
 * This is the main class for square.
 * Author: @Piernas Loïc, Jaubert Nicolas
 */
public class Carre extends Rectangle {

    public Carre() {
        super();
    }

    public Carre(InterPoint p1, InterPoint p2, InterPoint p3, InterPoint p4) {
        super();
        this.updateFigure(p1, p2, p3, p4);
    }

    public void updateFigure(InterPoint p1, InterPoint p2, InterPoint p3, InterPoint p4){

        double dist12 = Math.sqrt(Math.pow(p2.getX() - p1.getX(),2) + Math.pow(p2.getY() - p1.getY(),2));
        double dist23 = Math.sqrt(Math.pow(p3.getX() - p2.getX(),2) + Math.pow(p3.getY() - p2.getY(),2));
        double dist34 = Math.sqrt(Math.pow(p4.getX() - p3.getX(),2) + Math.pow(p4.getY() - p3.getY(),2));
        double dist41 = Math.sqrt(Math.pow(p1.getX() - p4.getX(),2) + Math.pow(p1.getY() - p4.getY(),2));

        if(dist12 != dist23)
            throw new IllegalArgumentException("Ces InterPoints ne permettent pas de faire un carré");

        super.updateFigure(p1, p2, p3, p4);
    }

    public String type() {
        return "Carre";
    }

    public void propriete() {
        super.propriete();
        System.out.println("Je suis aussi un carré\nJe possède 4 côtés de même longueur");
    }

}
