package fr.minesales.imtjavapoo1.model.geometrie;

public class Losange extends Parallelogramme{


    public Losange( InterPoint p1, double longX, double longY){
        super();
        this.p1 = p1;
        this.p2 = FabriquePoint.create(p1.getX() + longX, p1.getY(), "Point");
        this.p3 = FabriquePoint.create(p1.getX(), p1.getY() + longY, "Point");
        this.p4 = FabriquePoint.create(p1.getX() + longX, p1.getY() + longY, "Point");
    }

    public Losange(){
        super();
    }

    public Losange(InterPoint p1, InterPoint p3){
        super();
        this.p1 = p1;
        this.p2 = FabriquePoint.create(p1.getX() + p3.getX() - p1.getX(), p1.getY(), "Point");
        this.p3 = p3;
        this.p4 = FabriquePoint.create(p1.getX() + p3.getX() - p1.getX(), p1.getY() + p3.getY() - p1.getY(), "Point");
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
        InterPoint p1 = FabriquePoint.create(0,0, "Point");
        InterPoint p2 = FabriquePoint.create(0,1, "Point");
        InterPoint p3 = FabriquePoint.create(1,0, "Point");
        InterPoint p4 = FabriquePoint.create(1,1, "Point");
        Losange r = new Losange(p1,p4);

        InterPoint p5 = FabriquePoint.create(10,100, "Point"); // Obviously wont work
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
