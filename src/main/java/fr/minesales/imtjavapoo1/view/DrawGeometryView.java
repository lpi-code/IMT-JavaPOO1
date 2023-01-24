package fr.minesales.imtjavapoo1.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;

public class DrawGeometryView {
    private Canvas canvas;
    private GraphicsContext gc;
    public DrawGeometryView() {
        this.canvas = new Canvas(800,600);
        this.gc = this.canvas.getGraphicsContext2D();


        this.gc.setFill(Color.BLUE);
        this.gc.fillRect(75,75,100,100);
    }


    public Canvas getCanvas() {
        return this.canvas;
    }

    public GraphicsContext getGraphicsContext() {
        return this.gc;
    }

}
