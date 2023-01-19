package fr.minesales.imtjavapoo1.model.geometrie;

import java.text.DecimalFormat;

import static fr.minesales.imtjavapoo1.model.geometrie.Point.angle;
import static java.lang.Math.pow;

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
        // Info sur l'axe de symétrie
        if (this.p1.getX() == this.p2.getX() && this.p3.getX() == this.p4.getX()) {
            System.out.println("Mon axe de symétrie est entre p1 et p3");
        } else{
            System.out.println("Mon axe de symétrie est entre p2 et p4");
        }

    }

    public void updateFigure(Point p1, Point p2, Point p3, Point p4) throws IllegalArgumentException {
        double d1 = p1.distance(p2);
        double d2 = p2.distance(p3);
        double d3 = p3.distance(p4);
        double d4 = p4.distance(p1);

        if (d1 == d2 && d3 == d4 || d2 == d3 && d4 == d1) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
            this.p4 = p4;
        } else {
            throw new IllegalArgumentException("Points do not form a kite");
        }

        // Check if diagonals cross forming a right angle
        // Get equation of line between p1 and p3
        double a1 = (p3.getY() - p1.getY()) / (p3.getX() - p1.getX());
        double b1 = p1.getY() - a1 * p1.getX();

        // Get equation of line between p2 and p4
        double a2 = (p4.getY() - p2.getY()) / (p4.getX() - p2.getX());
        double b2 = p2.getY() - a2 * p2.getX();

        // Check if lines are parallel
        if (a1 == a2) {
            throw new IllegalArgumentException("Points do not form a kite");
        }

        // Get intersection point
        double x = (b2 - b1) / (a1 - a2);
        double y = a1 * x + b1;
        Point p = new Point(x, y);
        // Pythagore and rounding to three decimals
        if (Math.round(pow(p1.distance(p2),2) * 1000) != Math.round((pow(p.distance(p1),2) + pow(p.distance(p2),2))*1000)){
            throw new IllegalArgumentException("Points do not form a kite");
        }
        super.updateFigure(p1, p2, p3, p4);

    }


    public static void main(String[] args) {
        Point p1 = new Point(-5,7);
        Point p2 = new Point(2,6);
        Point p3 = new Point(5,-3);
        Point p4 = new Point(-4,0);
        CerfVolant r = new CerfVolant(p1,p2,p3,p4);

        Point p5 = new Point(0,0);
        Point p6 = new Point(0,1);
        Point p7 = new Point(10,0);
        Point p8 = new Point(1,2);
        // assert exception
        try {
            r.updateFigure(p5,p6,p7,p8);
            throw new AssertionError("Should have thrown an exception");
        } catch (IllegalArgumentException e) {
            System.out.println("Ces points ne permettent pas de faire un cerf-volant... Et c'est bien normal !");
        }
        // Now this should work
        r.updateFigure(p1,p2,p3,p4);
        r.propriete();
    }
}

