package fr.minesales.imtjavapoo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DrawGeometryAppController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}