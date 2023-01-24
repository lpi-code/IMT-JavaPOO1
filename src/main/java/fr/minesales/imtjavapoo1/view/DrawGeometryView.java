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


        this.borderPane.setCenter(this.canvas);


        this.gc.setFill(Color.BLUE);
        this.gc.fillRect(75,75,100,100);
    }

    public void drawGeometryToolBar() {
        this.toolBar.setBackground(new Background(new BackgroundFill(Color.rgb(150, 150, 150), CornerRadii.EMPTY, Insets.EMPTY)));

    }

    public void manageButton(Button carre, Button cerfVolant, Button losange, Button parallelogramme, Button rectangle, Button trapeze, Button quadrilatere) {
        this.toolBar = new ToolBar(carre, cerfVolant, losange, parallelogramme, rectangle, trapeze, quadrilatere);
        this.drawGeometryToolBar();
        this.borderPane.setTop(this.toolBar);
    }

    public BorderPane getBorderPane() {
        return this.borderPane;
    }

    public ToolBar getToolBar() {
        return this.toolBar;
    }
}
