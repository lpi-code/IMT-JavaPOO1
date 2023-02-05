package fr.minesales.imtjavapoo1;

import fr.minesales.imtjavapoo1.model.geometrie.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * This is a class that test the creation of a collection of quadrilaterals.
 * Author: @Piernas Loïc, Jaubert Nicolas
 */
public class CollectionQuadrilatere {

    private List<Quadrilatere> quadCollection;

    public static void main(String[] args) {
        CollectionQuadrilatere collection = new CollectionQuadrilatere();
        System.out.println("Création d'une collection de quadrilatères de différents types");
        collection.createQuadCollection();
        System.out.println("Affichage des propriétés de tous les quadrilatères");
        collection.displayQuadCollection();

    }

    public void createQuadCollection(){
        this.quadCollection = new ArrayList<>();
        this.quadCollection.add(
                new Quadrilatere(new Point(0,0), new Point(0,4), new Point(4,4), new Point(4,0)));
        this.quadCollection.add(
                new Parallelogramme(new Point(1,5), new Point(6,5), new Point(6,10), new Point(1,10)));
        this.quadCollection.add(
                new Rectangle(new Point(2,2), new Point(2,10), new Point(10,10), new Point(10,2)));
        this.quadCollection.add(
                new Carre(new Point(1,1), new Point(1,11), new Point(11,11), new Point(11,1)));
        this.quadCollection.add(
                new Trapeze(new Point(0,0), new Point(0,1), new Point(1,1), new Point(1,0)));
        this.quadCollection.add(
                new Losange(new Point(10,10), new Point(10,30), new Point(30,30), new Point(30,10)));
        return;
    }

    public void displayQuadCollection(){
        Iterator<Quadrilatere> itr = this.quadCollection.listIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
