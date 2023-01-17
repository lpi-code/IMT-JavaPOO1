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

}

