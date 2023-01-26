package fr.minesales.imtjavapoo1;

import fr.minesales.imtjavapoo1.view.DrawGeometryView;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class DrawGeometryApp extends Application {
    private DrawGeometryView drawGeometryView;
    private Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {


        Group root = new Group();
        Scene scene = new Scene(root, 1000, 800, Color.WHITE);
        this.primaryStage = stage;
        this.drawGeometryView = new DrawGeometryView();
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
            button.setOnAction((EventHandler) event -> {
                final Stage dialog = new Stage();
                dialog.setTitle("Créer un " + button.getText());
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(this.primaryStage);
                TextField coordP1 = new TextField();
                TextField coordP2 = new TextField();
                TextField coordP3 = new TextField();
                TextField coordP4 = new TextField();
                ChoiceBox color = new ChoiceBox(FXCollections.observableArrayList("Vert", "Bleu", "Rouge", "Jaune", "Noir", "Gris", "Orange", "Rose", "Violet"));
                Button validButton = new Button("Valider");
                this.drawGeometryView.drawPopups(button.getText(), coordP1, coordP2, coordP3, coordP4, color,validButton);
                Scene dialogScene = new Scene(this.drawGeometryView.getPopupVbox(), 400, 400);
                validButton.setOnAction((EventHandler) event1 -> this.handleUserinput(coordP1, coordP2, coordP3, coordP4, color, button.getText()));
                dialog.setScene(dialogScene);
                dialog.show();
            });

        }

        this.drawGeometryView.manageButton(carre, cerfVolant, losange, parallelogramme, rectangle, trapeze, quadrilatere);
    }

    public void handleUserinput(TextField coordP1, TextField coordP2, TextField coordP3, TextField coordP4, ChoiceBox color, String figure){
        System.out.println(figure + " de coordonnées des points : " + coordP1.getText() + ", " + coordP2.getText() + ", " + coordP3.getText() + ", " + coordP4.getText() + " et couleur : " + color.getValue());
    }
}