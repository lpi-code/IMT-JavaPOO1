package fr.minesales.imtjavapoo1.model.geometrie;

public class Rectangle extends Parallelogramme{
    public Rectangle( Point p1, Point p3){
        super();
        this.p1 = p1;
        this.p3 = p3;

        //Get the equation of the line between p1 and p3
        double a = (p3.getY() - p1.getY()) / (p3.getX() - p1.getX());
        double b = p1.getY() - a * p1.getX();

        //Get the equation from p1 that is at 45° of the line
        double a2 = -1 / a;
        double b2 = p1.getY() - a2 * p1.getX();

        //Get the equation from p3 that is at -45° of the line
        double a3 = -1 / a;
        double b3 = p3.getY() - a3 * p3.getX();

        //Get the intersection of the two lines
        double x2 = (b3 - b2) / (a2 - a3);
        double y2 = a2 * x2 + b2;



        //Get the equation from p1 that is at -45° of the line
        double a4 = -1 / a;
        double b4 = p1.getY() - a4 * p1.getX();


        //Get the equation from p3 that is at 45° of the line
        double a5 = -1 / a;
        double b5 = p3.getY() - a5 * p3.getX();

        //Get the intersection of the two lines
        double x4 = (b5 - b4) / (a4 - a5);
        double y4 = a4 * x4 + b4;

        //Create the points
        this.p2 = new Point(x2, y2);
        this.p4 = new Point(x4, y4);
    }

    public Rectangle( Point p1, double longX, double longY){
        super();
        this.p1 = p1;
        this.p2 = new Point(p1.getX() + longX, p1.getY());
        this.p3 = new Point(p1.getX(), p1.getY() + longY);
        this.p4 = new Point(p1.getX() + longX, p1.getY() + longY);
    }

    public Rectangle(){
        super();
    }

    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        super();
        this.updateFigure(p1, p2, p3, p4);
    }
    @Override
    public void updateFigure(Point p1, Point p2, Point p3, Point p4){

        double dist12 = Math.sqrt(Math.pow(p2.getX() - p1.getX(),2) + Math.pow(p2.getY() - p1.getY(),2));
        double dist34 = Math.sqrt(Math.pow(p4.getX() - p3.getX(),2) + Math.pow(p4.getY() - p3.getY(),2));
        double dist41 = Math.sqrt(Math.pow(p1.getX() - p4.getX(),2) + Math.pow(p1.getY() - p4.getY(),2));

        double dist13 = Math.sqrt(Math.pow(p3.getX() - p1.getX(),2) + Math.pow(p3.getY() - p1.getY(),2));
        double dist24 = Math.sqrt(Math.pow(p4.getX() - p2.getX(),2) + Math.pow(p4.getY() - p2.getY(),2));

        if(Math.sqrt(Math.pow(dist12, 2) + Math.pow(dist41, 2)) != dist13)
            throw new IllegalArgumentException("Ces points ne permettent pas de faire un rectangle");

        if(Math.sqrt(Math.pow(dist41, 2) + Math.pow(dist34, 2)) != dist24)
            throw new IllegalArgumentException("Ces points ne permettent pas de faire un rectangle");

        super.updateFigure(p1, p2, p3, p4);
    }

    @Override
    public String type() {
        return "Rectangle";
    }

    @Override
    public void propriete() {
        super.propriete();
        System.out.println("Je suis un rectangle");
    }


    public static void main(String[] args) {
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,1);
        Point p3 = new Point(1,0);
        Point p4 = new Point(1,1);
        Rectangle r = new Rectangle(p1,p4);
        r.propriete();
    }
}
