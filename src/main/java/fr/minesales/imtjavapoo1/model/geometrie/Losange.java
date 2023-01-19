package fr.minesales.imtjavapoo1.model.geometrie;

public class Losange extends Parallelogramme{


    public Losange( Point p1, double longX, double longY){
        super();
        this.p1 = p1;
        this.p2 = new Point(p1.getX() + longX, p1.getY());
        this.p3 = new Point(p1.getX(), p1.getY() + longY);
        this.p4 = new Point(p1.getX() + longX, p1.getY() + longY);
    }

    public Losange(){
        super();
    }

    public Losange(Point p1, Point p3){
        super();
        this.p1 = p1;
        this.p2 = new Point(p1.getX() + p3.getX() - p1.getX(), p1.getY());
        this.p3 = p3;
        this.p4 = new Point(p1.getX() + p3.getX() - p1.getX(), p1.getY() + p3.getY() - p1.getY());
    }

    @Override
    public void updateFigure(Point p1, Point p2, Point p3, Point p4){

        double dist12 = Math.sqrt(Math.pow(p2.getX() - p1.getX(),2) + Math.pow(p2.getY() - p1.getY(),2));
        double dist13 = Math.sqrt(Math.pow(p3.getX() - p1.getX(),2) + Math.pow(p3.getY() - p1.getY(),2));
        double dist24 = Math.sqrt(Math.pow(p4.getX() - p2.getX(),2) + Math.pow(p4.getY() - p2.getY(),2));
        double dist34 = Math.sqrt(Math.pow(p4.getX() - p3.getX(),2) + Math.pow(p4.getY() - p3.getY(),2));
        if(!( dist12 == dist13 && dist13 == dist24 && dist24 == dist34))
            throw new IllegalArgumentException("Ces points ne permettent pas de faire un losange");

        super.updateFigure(p1, p2, p3, p4);
    }

    @Override
    public String type() {
        return "Rectangle";
    }

    public static void main(String[] args) {
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,1);
        Point p3 = new Point(1,0);
        Point p4 = new Point(1,1);
        Losange r = new Losange(p1,p4);

        Point p5 = new Point(10,100); // Obviously wont work
        try{
            r.updateFigure(p1, p2, p3, p5);
            throw new AssertionError("Should have thrown an exception");
        } catch (IllegalArgumentException e ){
            System.out.println("An error as been caught and it is the expected behavior");
        }
        r.updateFigure(p1, p2, p3, p4);
        r.propriete();
    }
}
