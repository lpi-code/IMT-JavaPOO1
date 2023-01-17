package fr.minesales.imtjavapoo1.model.geometrie;

public class Quadrilatere {
    protected Point p1;
    protected Point p2;
    protected Point p3;
    protected Point p4;


    public void updateFigure(Point p1, Point p2, Point p3, Point p4){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public Quadrilatere() {
        super();
        this.p1 = new Point();
        this.p2 = new Point();
        this.p3 = new Point();
        this.p4 = new Point();
    }

    public Point getP1() {
        return p1;
    }

    protected void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    protected void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    protected void setP3(Point p3) {
        this.p3 = p3;
    }

    public Point getP4() {
        return p4;
    }

    protected void setP4(Point p4) {
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
        return "P1" + this.p1.toString() + "P2" + this.p2.toString() + "P3" + this.p3.toString() + "P4" + this.p4.toString();
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
                this.coordonnees();
    }

    public void affiche() {
        System.out.println(this.toString());
    }

    public void propriete() {
        System.out.println("Je suis un quadrilatère\nJe possède 4 côtés et 4 points");
    }


}
