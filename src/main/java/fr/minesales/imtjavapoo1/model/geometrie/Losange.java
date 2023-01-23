package fr.minesales.imtjavapoo1.model.geometrie;

public class Losange extends Parallelogramme{


    public Losange( InterPoint p1, double longX, double longY){
        super();
        this.p1 = p1;
        this.p2 = new Point(p1.getX() + longX, p1.getY());
        this.p3 = new Point(p1.getX(), p1.getY() + longY);
        this.p4 = new Point(p1.getX() + longX, p1.getY() + longY);
    }

    public Losange(){
        super();
    }

    public Losange(InterPoint p1, InterPoint p3){
        super();
        this.p1 = p1;
        this.p2 = new Point(p1.getX() + p3.getX() - p1.getX(), p1.getY());
        this.p3 = p3;
        this.p4 = new Point(p1.getX() + p3.getX() - p1.getX(), p1.getY() + p3.getY() - p1.getY());
    }

    public Losange(InterPoint p1, InterPoint p2, InterPoint p3, InterPoint p4) {
        super();
        this.updateFigure(p1, p2, p3, p4);
    }

    @Override
    public void updateFigure(InterPoint p1, InterPoint p2, InterPoint p3, InterPoint p4){

        double dist12 = p1.distance(p2);
        double dist23 = p2.distance(p3);
        double dist34 = p3.distance(p4);
        double dist41 = p4.distance(p1);
        if (!(dist12 == dist34 && dist23 == dist41)){
            throw new IllegalArgumentException("The InterPoints do not form a losange");
        }
        super.updateFigure(p1, p2, p3, p4);
    }

    @Override
    public String type() {
        return "Rectangle";
    }

    public static void main(String[] args) {
        InterPoint p1 = new Point(0,0);
        InterPoint p2 = new Point(0,1);
        InterPoint p3 = new Point(1,0);
        InterPoint p4 = new Point(1,1);
        Losange r = new Losange(p1,p4);

        InterPoint p5 = new Point(10,100); // Obviously wont work
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
