package fr.minesales.imtjavapoo1;

import fr.minesales.imtjavapoo1.view.DrawGeometryView;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class DrawGeometryApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        Group root = new Group();
        Scene scene = new Scene(root, 1000, 800, Color.WHITE);

        DrawGeometryView drawGeometryView = new DrawGeometryView();

        root.getChildren().add(drawGeometryView.getBorderPane());

        stage.setTitle("Dessin de figure géométrique");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}