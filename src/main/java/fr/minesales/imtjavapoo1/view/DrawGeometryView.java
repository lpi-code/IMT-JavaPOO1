package fr.minesales.imtjavapoo1.view;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class DrawGeometryView {
    private Canvas canvas;
    private GraphicsContext gc;
    private BorderPane borderPane;
    private ToolBar toolBar;
    public DrawGeometryView() {
        this.borderPane = new BorderPane();

        this.canvas = new Canvas(800,600);
        this.gc = this.canvas.getGraphicsContext2D();
        this.drawGeometryToolBar();

        this.borderPane.setCenter(this.canvas);
        this.borderPane.setTop(this.toolBar);

        this.gc.setFill(Color.BLUE);
        this.gc.fillRect(75,75,100,100);
    }

    public void drawGeometryToolBar() {
        this.manageButton();
        this.toolBar.setBackground(new Background(new BackgroundFill(Color.rgb(150, 150, 150), CornerRadii.EMPTY, Insets.EMPTY)));

    }

    private void manageButton(){
        Button carre = new Button("Carre");
        Button cerfVolant = new Button("Cerf Volant");
        Button losange = new Button("Losange");
        Button parallelogramme = new Button("Parallelogramme");
        Button rectangle = new Button("Rectangle");
        Button trapeze = new Button("Trapeze");
        Button quadrilatere = new Button("Quadrilatere");
        this.toolBar = new ToolBar(carre, cerfVolant, losange, parallelogramme, rectangle, trapeze, quadrilatere);
    }

    public BorderPane getBorderPane() {
        return this.borderPane;
    }

}
