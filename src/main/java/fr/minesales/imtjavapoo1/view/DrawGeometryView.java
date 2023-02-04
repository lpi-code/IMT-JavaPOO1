package fr.minesales.imtjavapoo1.view;

import fr.minesales.imtjavapoo1.DrawGeometryApp;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class DrawGeometryView {
    private Canvas canvas;
    private GraphicsContext gc;
    private BorderPane borderPane;
    private ToolBar toolBar;
    private VBox popupVbox;

    private DrawGeometryApp mainController;
    public DrawGeometryView(DrawGeometryApp mainController) {
        this.borderPane = new BorderPane();

        this.canvas = new Canvas(800,600);
        this.gc = this.canvas.getGraphicsContext2D();
        this.mainController = mainController;

        this.borderPane.setCenter(this.canvas);


        this.gc.setFill(Color.BLUE);
    }

    public void DrawPolygon(ArrayList<ArrayList<Double>> points, String color){
        this.gc.setFill(Color.valueOf(color));
        this.gc.fillPolygon(
                points.stream().mapToDouble(i -> i.get(0)).toArray(),
                points.stream().mapToDouble(i -> i.get(1)).toArray(),
                points.size()
        );

    }

    public void drawGeometryToolBar() {
        this.toolBar.setMinWidth(1000);
        this.toolBar.setMinHeight(50);
        this.toolBar.setBackground(new Background(new BackgroundFill(Color.rgb(8, 56, 8), CornerRadii.EMPTY, Insets.EMPTY)));

    }

    public void drawPopups(String message, Button validButton, Label errorLabel, ArrayList<Label> labels, ArrayList<TextField> coordsText, ChoiceBox<String> color) {
        this.popupVbox = new VBox(10);
        this.popupVbox.setAlignment(Pos.CENTER);
        this.popupVbox.getChildren().add(new Text("Nouveau " +  message));
        for (int i = 0; i < 4; i++) {
            this.popupVbox.getChildren().add(labels.get(i));
            this.popupVbox.getChildren().add(coordsText.get(i));
        }
        this.popupVbox.getChildren().add(color);
        this.popupVbox.getChildren().add(validButton);
        this.popupVbox.getChildren().add(errorLabel);

    }

    public void manageButton(Button carre, Button cerfVolant, Button losange, Button parallelogramme, Button rectangle, Button trapeze, Button quadrilatere) {
        HBox buttonsContainer = new HBox(15);
        buttonsContainer.setAlignment(Pos.CENTER);
        buttonsContainer.setMinWidth(1000);
        buttonsContainer.getChildren().addAll(carre, cerfVolant, losange, parallelogramme, rectangle, trapeze, quadrilatere);
        this.toolBar = new ToolBar(buttonsContainer);
        this.borderPane.setTop(this.toolBar);
        drawGeometryToolBar();
    }

    public BorderPane getBorderPane() {
        return this.borderPane;
    }

    public VBox getPopupVbox() {
        return this.popupVbox;
    }

    public ToolBar getToolBar() {
        return this.toolBar;
    }
}
