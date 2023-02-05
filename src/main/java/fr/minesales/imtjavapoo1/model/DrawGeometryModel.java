package fr.minesales.imtjavapoo1.model;

import fr.minesales.imtjavapoo1.model.geometrie.*;

import java.util.ArrayList;

/*
 * This is the main model class of the application.
 * Author: @Piernas Loïc, Jaubert Nicolas
 */
public class DrawGeometryModel {
    private ArrayList<Quadrilatere> quadCollection;
    private String pointMode;
    public DrawGeometryModel() {
        this.quadCollection = new ArrayList<>();
        this.pointMode = "Point";
    }
    private Quadrilatere FabriqueQuadrilatere(ArrayList<ArrayList<Double>> coordinates, String type, String color){
        ArrayList<InterPoint> points = new ArrayList<>();
        for (ArrayList<Double> coordinate : coordinates) {
            points.add(FabriquePoint.create(coordinate.get(0), coordinate.get(1), this.pointMode));
        }
        switch (type){
            case "Quadrilatere":
                return new Quadrilatere(points.get(0), points.get(1), points.get(2), points.get(3));
            case "Parallelogramme":
                return new Parallelogramme(points.get(0), points.get(1), points.get(2), points.get(3));
            case "Rectangle":
                return new Rectangle(points.get(0), points.get(1), points.get(2), points.get(3));
            case "Carre":
                return new Carre(points.get(0), points.get(1), points.get(2), points.get(3));
            case "Trapeze":
                return new Trapeze(points.get(0), points.get(1), points.get(2), points.get(3));
            case "Losange":
                return new Losange(points.get(0), points.get(1), points.get(2), points.get(3));
            default:
                return null;
        }
    }

    public boolean tryCreateQuad(ArrayList<ArrayList<Double>> coordinates, String type, String color){
        try {
            this.quadCollection.add(FabriqueQuadrilatere(coordinates, type, color));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
