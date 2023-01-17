package fr.minesales.imtjavapoo1.model.geometrie;

public class Trapeze extends Quadrilatere {

    protected Trapeze(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }


    @Override
    public String type() {
        return "Trapeze";
    }

    @Override
    public void propriete() {
        super.propriete();
        System.out.println("Je aussi suis un trapeze\nJe possède 2 côtés parallèles");
    }

    w
}
