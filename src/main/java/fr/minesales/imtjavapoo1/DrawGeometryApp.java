package fr.minesales.imtjavapoo1;

import fr.minesales.imtjavapoo1.model.DrawGeometryModel;
import fr.minesales.imtjavapoo1.view.DrawGeometryView;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


/*
    * This is the main class of the application.
    * Author: @Piernas Loïc, Jaubert Nicolas
 */
public class DrawGeometryApp extends Application {
    private DrawGeometryView drawGeometryView;
    private DrawGeometryModel drawGeometryModel;
    private Stage primaryStage;
    private Stage popupStage;
    @Override
    public void start(Stage stage) throws IOException {


        Group root = new Group();
        Scene scene = new Scene(root, 1000, 800, Color.WHITE);
        this.primaryStage = stage;
        this.drawGeometryView = new DrawGeometryView(stage);
        this.drawGeometryModel = new DrawGeometryModel();
        this.manageButton();

        root.getChildren().add(this.drawGeometryView.getBorderPane());

        stage.setTitle("Dessin de figure géométrique");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void manageButton(){
        Button carre = new Button("Carre");
        Button cerfVolant = new Button("Cerf Volant");
        Button losange = new Button("Losange");
        Button parallelogramme = new Button("Parallelogramme");
        Button rectangle = new Button("Rectangle");
        Button trapeze = new Button("Trapeze");
        Button quadrilatere = new Button("Quadrilatere");

        ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(carre, cerfVolant, losange, parallelogramme, rectangle, trapeze, quadrilatere));

        for ( Button button : buttons ) {
            button.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #2a49f9;");
            button.setOnAction((EventHandler) event -> {
                this.popupStage = new Stage();
                this.popupStage.setResizable(false);
                this.popupStage.setTitle("Créer un " + button.getText());
                this.popupStage.initModality(Modality.APPLICATION_MODAL);
                this.popupStage.initOwner(this.primaryStage);
                this.manageGeometryFigureCreation(button.getText());
                Scene dialogScene = new Scene(this.drawGeometryView.getPopupVbox(), 400, 400);
                this.popupStage.setScene(dialogScene);
                this.popupStage.show();
            });

        }
        this.drawGeometryView.manageButton(carre, cerfVolant, losange, parallelogramme, rectangle, trapeze, quadrilatere);
    }

    public void manageGeometryFigureCreation(String buttonText){

        ArrayList<TextField> coordsText = new ArrayList<>();
        ArrayList<Label> labels = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            labels.add(new Label("Coordonnées " + (i+1)));
            coordsText.add(new TextField());
            coordsText.get(i).setMaxWidth(100);
        }
        ChoiceBox color = new ChoiceBox(FXCollections.observableArrayList("Vert", "Bleu", "Rouge", "Jaune", "Noir", "Gris", "Orange", "Rose", "Violet"));
        color.setValue("Bleu");
        Button validButton = new Button("Valider");
        Label errorLabel = new Label();
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
            // Traduction depuis francais vers anglais
            String colorValue = switch (color.getValue().toString()) {
                case "Vert" -> "Green";
                case "Bleu" -> "Blue";
                case "Rouge" -> "Red";
                case "Jaune" -> "Yellow";
                case "Noir" -> "Black";
                case "Gris" -> "Grey";
                case "Orange" -> "Orange";
                case "Rose" -> "Pink";
                case "Violet" -> "Purple";
                default -> color.getValue().toString();

            };
            if (!this.tryCreateQuad(points, buttonText, colorValue)) {
                errorLabel.setText("Les coordonées ne permettent pas de : " + buttonText);
            } else {
                errorLabel.setText("");
                this.popupStage.close();
            }
        });
        this.drawGeometryView.drawPopups(validButton, errorLabel, labels, coordsText, color);
    }
    public boolean tryCreateQuad(ArrayList<ArrayList<Double>> coordinates, String type, String color){
        if (this.drawGeometryModel.tryCreateQuad(coordinates, type, color)){
            this.drawGeometryView.DrawPolygon(coordinates, color);
            return true;
        } else {
            return false;
        }
    }
}