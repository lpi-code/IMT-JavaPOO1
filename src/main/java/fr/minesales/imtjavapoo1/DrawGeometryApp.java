package fr.minesales.imtjavapoo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;

public class DrawGeometryApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        Line line = new Line();

        //Setting the properties to a line
        line.setStartX(100.0);
        line.setStartY(150.0);
        line.setEndX(500.0);
        line.setEndY(150.0);

        //Creating a Group
        Group root = new Group(line);

        //Creating a Scene
        Scene scene = new Scene(root, 600, 300);

        stage.setTitle("Dessin de figure géométrique");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}