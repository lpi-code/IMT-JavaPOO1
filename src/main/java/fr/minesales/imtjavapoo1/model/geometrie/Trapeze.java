package fr.minesales.imtjavapoo1.model.geometrie;

/*
 * This is the class for trapeze.
 * Author: @Piernas Loïc, Jaubert Nicolas
 */
public class Trapeze extends Quadrilatere {


    public Trapeze() {
        super();
    }

    public Trapeze(InterPoint p1, InterPoint p2, InterPoint p3, InterPoint InterPoint) {
        super();
        this.updateFigure(p1, p2, p3, InterPoint);
    }


    @Override
    public void updateFigure(InterPoint p1, InterPoint p2, InterPoint p3, InterPoint p4)
    {
        //Check if those InterPoints make a trapeze
        if (!Trapeze.isTrapeze(p1, p2, p3, p4)) {
            throw new IllegalArgumentException("Ces InterPoints ne forment pas un trapèze");
        }
        super.updateFigure(p1, p2, p3, p4);
    }

    @Override
    public String type() {
        return "Trapeze";
    }

    public static boolean isTrapeze(InterPoint p1, InterPoint p2, InterPoint p3, InterPoint p4) {
        // Calculer les vecteurs formés par les côtés
        double v1x = p2.getX() - p1.getX();
        double v1y = p2.getY() - p1.getY();
        double v2x = p3.getX() - p2.getX();
        double v2y = p3.getY() - p2.getY();
        double v3x = p4.getX() - p3.getX();
        double v3y = p4.getY() - p3.getY();
        double v4x = p1.getX() - p4.getX();
        double v4y = p1.getY() - p4.getY();

        // Vérifier que les côtés opposés sont parallèles
        if ((v1x * v3y != v1y * v3x) || (v2x * v4y != v2y * v4x)) {
            return false;
        }

        // Vérifier que les angles droits sont égaux
        if ((v1x * v2x + v1y * v2y != 0) || (v2x * v3x + v2y * v3y != 0)
                || (v3x * v4x + v3y * v4y != 0) || (v4x * v1x + v4y * v1y != 0)) {
            return false;
        }

        // Vérifier que les côtés opposés ont la même longueur
        return (Math.sqrt(v1x * v1x + v1y * v1y) == Math.sqrt(v3x * v3x + v3y * v3y)) &&
                (Math.sqrt(v2x * v2x + v2y * v2y) == Math.sqrt(v4x * v4x + v4y * v4y));
    }
    @Override
    public void propriete() {
        super.propriete();
        System.out.println("Je aussi suis un trapeze\nJe possède 2 côtés parallèles");
    }

    public static void main(String[] args) {
        InterPoint p1 = FabriquePoint.create(0,0, "Point");
        InterPoint p2 = FabriquePoint.create(0,1, "Point");
        InterPoint p3 = FabriquePoint.create(1,1, "Point");
        InterPoint p4 = FabriquePoint.create(1,0, "Point");
        InterPoint p5 = FabriquePoint.create(100, 100, "Point");
        Trapeze r = new Trapeze();
        try{
            r.updateFigure(p1, p2, p3, p5);
            throw new AssertionError("This should have thrown an exception");
        } catch (IllegalArgumentException e){
            System.out.println("Unable to update figure ... this is the expected behavior");
        }
        r.updateFigure(p1,p2,p3,p4);
        r.propriete();
    }
}
