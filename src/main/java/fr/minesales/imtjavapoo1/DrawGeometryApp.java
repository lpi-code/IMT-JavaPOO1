package fr.minesales.imtjavapoo1;

import fr.minesales.imtjavapoo1.view.DrawGeometryView;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collection;

public class DrawGeometryApp extends Application {
    private DrawGeometryView drawGeometryView;
    @Override
    public void start(Stage stage) throws IOException {


        Group root = new Group();
        Scene scene = new Scene(root, 1000, 800, Color.WHITE);

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
        this.drawGeometryView.manageButton(carre, cerfVolant, losange, parallelogramme, rectangle, trapeze, quadrilatere);
    }
}