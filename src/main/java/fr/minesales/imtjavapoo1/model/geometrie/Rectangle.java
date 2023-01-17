package fr.minesales.imtjavapoo1.model.geometrie;

public class Rectangle extends Parallelogramme{
    public Rectangle( Point p1, Point p3){
        super();
        this.p1 = p1;
        this.p3 = p3;

        double middleX = (p1.getX() + p3.getX()) / 2;
        double middleY = (p1.getX() + p3.getX()) / 2;
        double distance = Math.sqrt(Math.pow(p3.getX() - p1.getX(),2) + Math.pow(p3.getY() - p1.getY(),2));
        this.p2 = new Point(middleX + distance/2, middleY +distance/2);
        this.p4 = new Point(middleX +distance/2, middleY + distance/2);

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

        if(Math.abs(p1.getX() - p2.getX()) != Math.abs(p3.getX() - p4.getX()))
            throw new IllegalArgumentException("Ces points ne permettent pas de faire un rectangle");

        if(Math.abs(p1.getY() - p2.getY()) != Math.abs(p3.getY() - p4.getY()))
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
