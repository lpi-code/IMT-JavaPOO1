package fr.minesales.imtjavapoo1.model.geometrie;

public class Carre extends Rectangle {

    public Carre() {
        super();
    }

    public void updateFigure(Point p1, Point p2, Point p3, Point p4){
        super.updateFigure(p1, p2, p3, p4);
    }

    public String type() {
        return "Carre";
    }
}
