package fr.minesales.imtjavapoo1.model.geometrie;

public class Trapeze extends Quadrilatere {


    public Trapeze() {
        super();
    }

    @Override
    public void updateFigure(Point p1, Point p2, Point p3, Point p4)
    {
        super.updateFigure(p1, p2, p3, p4);
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
}
