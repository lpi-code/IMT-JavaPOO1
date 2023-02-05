package fr.minesales.imtjavapoo1;

import fr.minesales.imtjavapoo1.model.geometrie.*;
/*
 * This is the class for the question D.
 * Author: @Piernas Loïc, Jaubert Nicolas
 */
public class TD1_QuestionDmain {
    public static void main(String[] args) {
        System.out.println("Création d'un quadrilatère quelconque");
        Quadrilatere q1 = new Quadrilatere(new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(0, 1));
        System.out.println("Affichage des propriétés du quadrilatère");
        q1.propriete();
        System.out.println("\n");
        // parallélogramme
        System.out.println("Création d'un parallélogramme");
        Parallelogramme p1 = new Parallelogramme(new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(0,1));
        System.out.println("Affichage des propriétés du parallélogramme");
        p1.propriete();
        System.out.println("\n");
        // rectangle
        System.out.println("Création d'un rectangle");
        Rectangle r1 = new Rectangle(new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(0, 1));
        System.out.println("Affichage des propriétés du rectangle");
        r1.propriete();
        System.out.println("\n");
        // carré
        System.out.println("Création d'un carré");
        Carre c1 = new Carre(new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(0, 1));
        System.out.println("Affichage des propriétés du carré");
        c1.propriete();
        System.out.println("\n");
        // trapeze
        System.out.println("Création d'un trapèze");
        Trapeze t1 = new Trapeze(new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(0, 1));
        System.out.println("Affichage des propriétés du trapèze");
        t1.propriete();
        System.out.println("\n");
        // losange
        System.out.println("Création d'un losange");
        Losange l1 = new Losange(new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(0, 1));
        System.out.println("Affichage des propriétés du losange");
        l1.propriete();


    }
}
