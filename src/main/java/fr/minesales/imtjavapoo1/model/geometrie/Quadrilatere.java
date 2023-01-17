package fr.minesales.imtjavapoo1.model.geometrie;

public class Quadrilatere {
private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    public Quadrilatere(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    public Point getP4() {
        return p4;
    }

    public void setP4(Point p4) {
        this.p4 = p4;
    }

    public double perimetre() {
        return this.p1.distance(this.p2) + this.p2.distance(this.p3) + this.p3.distance(this.p4) + this.p4.distance(this.p1);
    }

    public double surface() {
        return this.p1.distance(this.p2) * this.p2.distance(this.p3);
    }

    public String type() {
        return "Quadrilatère quelconque";
    }

    public String coordonnees() {
        return "Coordonnées des sommets : (" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + "), (" + x3 + ", " + y3 + "), (" + x4 + ", " + y4 + ")";
    }

    @Override
    public String toString(){
        return this.type() +
                " de périmètre " +
                this.perimetre() +
                " et de surface " +
                this.surface() +
                " dont " +
                this.coordonnees() +
                "\n de points " +
                this.p1.toString() +
                ", " +
                this.p2.toString() +
                ", " +
                this.p3.toString() +
                ", " +
                this.p4.toString();
    }

    public void affiche() {
        System.out.println(this.toString());
    }



}
