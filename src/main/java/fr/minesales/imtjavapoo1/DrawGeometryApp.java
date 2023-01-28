package fr.minesales.imtjavapoo1;

import fr.minesales.imtjavapoo1.model.DrawGeometryModel;
import fr.minesales.imtjavapoo1.view.DrawGeometryView;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private DrawGeometryModel drawGeometryModel;
    private Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {


        Group root = new Group();
        Scene scene = new Scene(root, 1000, 800, Color.WHITE);
        this.primaryStage = stage;
        this.drawGeometryView = new DrawGeometryView(this);
        this.drawGeometryModel = new DrawGeometryModel();
        /*this.drawGeometryView.DrawPolygon(
                new ArrayList<>(Arrays.asList(
                        new ArrayList<>(Arrays.asList(100.0, 100.0)),
                        new ArrayList<>(Arrays.asList(200.0, 100.0)),
                        new ArrayList<>(Arrays.asList(200.0, 200.0)),
                        new ArrayList<>(Arrays.asList(100.0, 200.0))
                ))
        );*/
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
                this.drawGeometryView.drawPopups(button.getText());
                Scene dialogScene = new Scene(this.drawGeometryView.getPopupVbox(), 400, 400);
                dialog.setScene(dialogScene);
                dialog.show();
            });

        }

        this.drawGeometryView.manageButton(carre, cerfVolant, losange, parallelogramme, rectangle, trapeze, quadrilatere);
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