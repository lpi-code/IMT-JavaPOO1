package fr.minesales.imtjavapoo1.model.geometrie;

public class Rectangle extends Parallelogramme{
    public Rectangle( Point p1, Point p3){
        super();
        this.p1 = p1;
        this.p3 = p3;

        //Get the equation of the line between p1 and p3
        double a = (p3.getY() - p1.getY()) / (p3.getX() - p1.getX());
        double b = p1.getY();
        double b2 = p3.getY();

        System.out.println("a = " + a + " b = " + b + " b2 = " + b2);


        double r1 = Math.sqrt(a*a + 1);
        double theta1 = Math.atan(a) + Math.toRadians(-45);
        double a_new1 = Math.tan(theta1);
        double b_new1 = b;

        System.out.println("a_new1 = " + a_new1 + " b_new1 = " + b_new1);

        double r2 = Math.sqrt(a*a + 1);
        double theta2 = Math.atan(a) + Math.toRadians(45);
        double a_new2 = Math.tan(theta2);
        double b_new2 = b2;

        double r3 = Math.sqrt(a*a + 1);
        double theta3 = Math.atan(a) + Math.toRadians(45);
        double a_new3 = Math.tan(theta3);
        double b_new3 = b;

        double r4 = Math.sqrt(a*a + 1);
        double theta4 = Math.atan(a) + Math.toRadians(-45);
        double a_new4 = Math.tan(theta4);
        double b_new4 = b2;

        double x2 = (b_new2 - b_new1) / (a_new1 - a_new2);
        double y2 = a_new1 * x2 + b_new1;

        double x4 = (b_new4 - b_new3) / (a_new3 - a_new4);
        double y4 = a_new3 * x4 + b_new3;

        this.p2 = new Point(Math.round(x2), Math.round(y2));
        this.p4 = new Point(Math.round(x4), Math.round(y4));
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

    @Override
    public void affiche() {
        super.affiche();
    }


    public static void main(String[] args) {
        Point p1 = new Point(1,1);
        Point p3 = new Point(5,5);
        Rectangle r = new Rectangle(p1, p3);

        r.affiche();
    }
}
