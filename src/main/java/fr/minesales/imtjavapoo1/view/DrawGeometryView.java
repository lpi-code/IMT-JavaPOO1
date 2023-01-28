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
        this.toolBar.setBackground(new Background(new BackgroundFill(Color.rgb(150, 150, 150), CornerRadii.EMPTY, Insets.EMPTY)));

    }

    public void drawPopups(String message) {
        this.popupVbox = new VBox(10);
        this.popupVbox.setAlignment(Pos.CENTER);
        this.popupVbox.getChildren().add(new Text("Nouveau " +  message));
        ArrayList<TextField> coordsText = new ArrayList<>();
        ArrayList<Label> labels = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            labels.add(new Label("Coordonnées " + (i+1)));
            coordsText.add(new TextField());
            coordsText.get(i).setMaxWidth(100);
            this.popupVbox.getChildren().add(labels.get(i));
            this.popupVbox.getChildren().add(coordsText.get(i));
        }
        ChoiceBox color = new ChoiceBox(FXCollections.observableArrayList("Vert", "Bleu", "Rouge", "Jaune", "Noir", "Gris", "Orange", "Rose", "Violet"));
        color.setValue("Bleu");
        this.popupVbox.getChildren().add(color);
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
            String colorValue = color.getValue().toString();
            // Traduction depuis francais vers anglais
            switch (colorValue) {
                case "Vert":
                    colorValue = "Green";
                    break;
                case "Bleu":
                    colorValue = "Blue";
                    break;
                case "Rouge":
                    colorValue = "Red";
                    break;
                case "Jaune":
                    colorValue = "Yellow";
                    break;
                case "Noir":
                    colorValue = "Black";
                    break;
                case "Gris":
                    colorValue = "Grey";
                    break;
                case "Orange":
                    colorValue = "Orange";
                    break;
                case "Rose":
                    colorValue = "Pink";
                    break;
                case "Violet":
                    colorValue = "Purple";
                    break;
            }
            if (!this.mainController.tryCreateQuad(points, message, colorValue)) {

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
