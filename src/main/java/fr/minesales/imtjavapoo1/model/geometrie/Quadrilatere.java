package fr.minesales.imtjavapoo1.model.geometrie;

public class Quadrilatere {
    protected InterPoint p1;
    protected InterPoint p2;
    protected InterPoint p3;
    protected InterPoint p4;


    public Quadrilatere(InterPoint p1, InterPoint p2, InterPoint p3, InterPoint p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public void updateFigure(InterPoint p1, InterPoint p2, InterPoint p3, InterPoint p4){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public Quadrilatere() {
        super();
        this.p1 = FabriquePoint.create(0,0, "Point");
        this.p2 = FabriquePoint.create(0,0, "Point");
        this.p3 = FabriquePoint.create(0,0, "Point");
        this.p4 = FabriquePoint.create(0,0, "Point");
    }

    public InterPoint getP1() {
        return p1;
    }

    protected void setP1(InterPoint p1) {
        this.p1 = p1;
    }

    public InterPoint getP2() {
        return p2;
    }

    protected void setP2(InterPoint p2) {
        this.p2 = p2;
    }

    public InterPoint getP3() {
        return p3;
    }

    protected void setP3(InterPoint p3) {
        this.p3 = p3;
    }

    public InterPoint getP4() {
        return p4;
    }

    protected void setP4(InterPoint p4) {
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
                "\n de InterPoints " +
                this.coordonnees();
    }

    public void affiche() {
        System.out.println(this.toString());
    }

    public void propriete() {
        System.out.println("Je suis un quadrilatère\nJe possède 4 côtés et 4 InterPoints");
        System.out.println("Mes InterPoints this sont " + this.p1.toString() + " " + this.p2.toString() + " " + this.p3.toString() + " " + this.p4.toString());
    }

    public static void main(String[] args) {
        Quadrilatere q = new Quadrilatere();
        q.updateFigure(FabriquePoint.create(0,1,"Point"), FabriquePoint.create(0, 1, "Point"), FabriquePoint.create(1, 1, "Point"), FabriquePoint.create(1, 0, "Point"));
        q.affiche();
        q.propriete();
    }


}
