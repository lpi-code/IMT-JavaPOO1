package fr.minesales.imtjavapoo1.model.geometrie;

public class CerfVolant extends Quadrilatere {
    @Override
    public String type() {
        return "CerfVolant";
    }

    public CerfVolant(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }
    @Override
    public void propriete() {
        super.propriete();
        System.out.println("Je suis aussi un cerf-volant\nJe possède un axe de symétrie");
    }

    public static void main(String[] args) {
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,1);
        Point p3 = new Point(1,0);
        Point p4 = new Point(1,1);
        CerfVolant r = new CerfVolant(p1,p2,p3,p4);
        r.propriete();
    }
}

