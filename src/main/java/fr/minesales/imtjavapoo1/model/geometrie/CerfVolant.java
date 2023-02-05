package fr.minesales.imtjavapoo1.model.geometrie;


import static java.lang.Math.pow;

/*
 * This is the class for kite.
 * Author: @Piernas Loïc, Jaubert Nicolas
 */
public class CerfVolant extends Quadrilatere {
    @Override
    public String type() {
        return "CerfVolant";
    }

    public CerfVolant(InterPoint p1, InterPoint p2, InterPoint p3, InterPoint p4) {
        super();
        this.updateFigure(p1, p2, p3, p4);
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

    public void updateFigure(InterPoint p1, InterPoint p2, InterPoint p3, InterPoint p4) throws IllegalArgumentException {
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
            throw new IllegalArgumentException("InterPoints do not form a kite");
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
            throw new IllegalArgumentException("InterPoints do not form a kite");
        }

        // Get intersection InterPoint
        double x = (b2 - b1) / (a1 - a2);
        double y = a1 * x + b1;
        InterPoint p = new Point(x, y);
        // Pythagore and rounding to three decimals
        if (Math.round(pow(p1.distance(p2),2) * 1000) != Math.round((pow(p.distance(p1),2) + pow(p.distance(p2),2))*1000)){
            throw new IllegalArgumentException("InterPoints do not form a kite");
        }
        super.updateFigure(p1, p2, p3, p4);

    }


    public static void main(String[] args) {
        InterPoint p1 = FabriquePoint.create(-5,7, "Point2");
        InterPoint p2 = FabriquePoint.create(2,6, "Point2");
        InterPoint p3 = FabriquePoint.create(5,-3, "Point2");
        InterPoint p4 = FabriquePoint.create(-4,0, "Point2");
        CerfVolant r = new CerfVolant(p1,p2,p3,p4);
        InterPoint p5 = FabriquePoint.create(0,0, "Point2");
        InterPoint p6 = FabriquePoint.create(0,1, "Point2");
        InterPoint p7 = FabriquePoint.create(10,0, "Point2");
        InterPoint p8 = FabriquePoint.create(1,2, "Point2");
        // assert exception
        try {
            r.updateFigure(p5,p6,p7,p8);
            throw new AssertionError("Should have thrown an exception");
        } catch (IllegalArgumentException e) {
            System.out.println("Ces InterPoints ne permettent pas de faire un cerf-volant... Et c'est bien normal !");
        }
        // Now this should work
        r.updateFigure(p1,p2,p3,p4);
        r.propriete();
    }
}

