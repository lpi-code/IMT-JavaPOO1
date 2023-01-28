package fr.minesales.imtjavapoo1.view;

import fr.minesales.imtjavapoo1.DrawGeometryApp;
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

    public void DrawPolygon(ArrayList<ArrayList<Double>> points){
        this.gc.setFill(Color.BLUE);
        this.gc.fillPolygon(
                points.stream().mapToDouble(i -> i.get(0)).toArray(),
                points.stream().mapToDouble(i -> i.get(1)).toArray(),
                points.size()
        );

    }

    public void drawGeometryToolBar() {
        this.toolBar.setBackground(new Background(new BackgroundFill(Color.rgb(150, 150, 150), CornerRadii.EMPTY, Insets.EMPTY)));

    }

    public void drawPopups(String message) {
        this.popupVbox = new VBox(15);
        this.popupVbox.setAlignment(Pos.CENTER);
        this.popupVbox.getChildren().add(new Text("Nouveau " +  message));
        ArrayList<TextField> coordsText = new ArrayList<>();
        ArrayList<Label> labels = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            labels.add(new Label("Coordonnées " + (i+1)));
            coordsText.add(new TextField());
            this.popupVbox.getChildren().add(labels.get(i));
            this.popupVbox.getChildren().add(coordsText.get(i));
        }
        Button validButton = new Button("Valider");
        Label errorLabel = new Label();
        this.popupVbox.getChildren().add(validButton);
        this.popupVbox.getChildren().add(errorLabel);
        validButton.setOnAction(e -> {
            ArrayList<ArrayList<Double>> points = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                try {
                    Double x = Double.parseDouble(coordsText.get(i).getText().split(",")[0]);
                    Double y = Double.parseDouble(coordsText.get(i).getText().split(",")[1]);
                    points.add(new ArrayList<>(Arrays.asList(x, y)));
                } catch (Exception exception) {
                    errorLabel.setText("Erreur de saisie");
                    return;
                }
            }
            if (!this.mainController.tryCreateQuad(points, message)){

                errorLabel.setText("Les coordonées ne permettent pas de : " + message);
            } else {
                errorLabel.setText("");
                //close popup
                this.borderPane.getChildren().remove(this.popupVbox);
            }
        });
    }

    public void manageButton(Button carre, Button cerfVolant, Button losange, Button parallelogramme, Button rectangle, Button trapeze, Button quadrilatere) {
        this.toolBar = new ToolBar(carre, cerfVolant, losange, parallelogramme, rectangle, trapeze, quadrilatere);
        this.drawGeometryToolBar();
        this.borderPane.setTop(this.toolBar);
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
