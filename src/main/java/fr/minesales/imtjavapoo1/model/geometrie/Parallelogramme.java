package fr.minesales.imtjavapoo1.model.geometrie;

public class Parallelogramme extends Trapeze {

    public Parallelogramme() {
        super();
    }
    @Override
    public String type() {
        return "Parallélogramme";
    }

    public Parallelogramme(Point p1, Point p2, Point p3){
        super();
        this.updateFigure(p1,p2,p3,new Point(p1.getX() + p3.getX() - p2.getX(), p1.getY() + p3.getY() - p2.getY()));
    }

    @Override
    public void updateFigure(Point p1, Point p2, Point p3, Point p4) {

        double dist12 = p1.distance(p2);
        double dist23 = p2.distance(p3);
        double dist34 = p3.distance(p4);
        double dist41 =p4.distance(p1);

        if(! (dist12 == dist34 && dist23 == dist41))
            throw new IllegalArgumentException("Ces points ne permettent pas de faire un parallélogramme");

        super.updateFigure(p1, p2, p3, p4);
    }


    @Override
    public void propriete() {
        super.propriete();
        System.out.println("Je suis un parallélogramme\nJe possède 4 côtés parallèles deux à deux");
    }

    public static void main(String[] args) {
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,1);
        Point p3 = new Point(1,1);
        Parallelogramme r = new Parallelogramme(p1,p2,p3);
        r.propriete();
    }
}

