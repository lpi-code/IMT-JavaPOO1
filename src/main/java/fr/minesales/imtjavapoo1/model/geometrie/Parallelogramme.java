package fr.minesales.imtjavapoo1.model.geometrie;

public class Parallelogramme extends Trapeze {
    @Override
    public String type() {
        return "Parallélogramme";
    }

    public Parallelogramme(Point p1, Point p2, Point p3){
        super(p1, p2, p3, new Point(p1.getX() + p3.getX() - p2.getX(), p1.getY() + p3.getY() - p2.getY()));
    }

    @Override
    public void propriete() {
        super.propriete();
        System.out.println("Je suis un parallélogramme\nJe possède 4 côtés parallèles deux à deux");
    }

    public static void main(String[] args) {
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,1);
        Point p3 = new Point(1,0);
        Parallelogramme r = new Parallelogramme(p1,p2,p3);
        r.propriete();
    }
}

