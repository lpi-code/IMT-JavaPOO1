package fr.minesales.imtjavapoo1.view;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

/*
 * This is the view of the application.
 * Author: @Piernas Loïc, Jaubert Nicolas
 */
public class DrawGeometryView {
    private Canvas canvas;
    private GraphicsContext gc;
    private BorderPane borderPane;
    private ToolBar toolBar;
    private HBox buttonsContainer;
    private VBox popupVbox;

    public DrawGeometryView(Stage stage) {
        this.borderPane = new BorderPane();
        this.borderPane.prefWidthProperty().bind(stage.widthProperty());

        this.canvas = new Canvas(1000,600);
        this.gc = this.canvas.getGraphicsContext2D();

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
        this.toolBar.prefWidthProperty().bind(this.borderPane.widthProperty());
        this.toolBar.setMinHeight(50);
        this.toolBar.setBackground(new Background(new BackgroundFill(Color.rgb(42, 73, 249), CornerRadii.EMPTY, Insets.EMPTY)));

    }

    public void drawPopups(Button validButton, Label errorLabel, ArrayList<Label> labels, ArrayList<TextField> coordsText, ChoiceBox<String> color) {
        this.popupVbox = new VBox(10);
        this.popupVbox.setAlignment(Pos.CENTER);
        for (int i = 0; i < 4; i++) {
            labels.get(i).setStyle("-fx-text-fill: #2a49f9");
            this.popupVbox.getChildren().add(labels.get(i));
            this.popupVbox.getChildren().add(coordsText.get(i));
        }
        color.setStyle("-fx-background-color: white; -fx-mark-color: #2a49f9;");
        validButton.setStyle("-fx-background-color: white; -fx-text-fill: #2a49f9;");
        errorLabel.setStyle("-fx-text-fill: #2a49f9;");
        this.popupVbox.getChildren().add(color);
        this.popupVbox.getChildren().add(validButton);
        this.popupVbox.getChildren().add(errorLabel);

    }

    public void manageButton(Button carre, Button cerfVolant, Button losange, Button parallelogramme, Button rectangle, Button trapeze, Button quadrilatere) {
        this.buttonsContainer = new HBox(15);
        this.buttonsContainer.minWidthProperty().bind(this.borderPane.widthProperty());
        buttonsContainer.setAlignment(Pos.CENTER);
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

}
