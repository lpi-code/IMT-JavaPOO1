package fr.minesales.imtjavapoo1.model.geometrie;

public class FabriquePoint {
   public static InterPoint create(double x, double y, String type) {
       if (type.equals("Point")) {
           return new Point(x, y);
       } else if (type.equals("Point2")) {
           return new Point2(x, y);
       } else {
           throw new IllegalArgumentException("Type inconnu");
       }
   }
}
