package fr.minesales.imtjavapoo1.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class DrawGeometryView {
    private Canvas canvas;
    private GraphicsContext gc;
    private BorderPane borderPane;
    private ToolBar toolBar;
    private VBox popupVbox;
    public DrawGeometryView() {
        this.borderPane = new BorderPane();

        this.canvas = new Canvas(800,600);
        this.gc = this.canvas.getGraphicsContext2D();


        this.borderPane.setCenter(this.canvas);


        this.gc.setFill(Color.BLUE);
        this.gc.fillRect(75,75,100,100);
    }

    public void drawGeometryToolBar() {
        this.toolBar.setBackground(new Background(new BackgroundFill(Color.rgb(150, 150, 150), CornerRadii.EMPTY, Insets.EMPTY)));

    }

    public void drawPopups(String message) {
        this.popupVbox = new VBox(15);
        this.popupVbox.setAlignment(Pos.CENTER);
        this.popupVbox.getChildren().add(new Text("Nouveau " +  message));
        Label label1 = new Label("Coordonnées P1");
        Label label2 = new Label("Coordonnées P2");
        Label label3 = new Label("Coordonnées P3");
        Label label4 = new Label("Coordonnées P4");
        TextField coordP1 = new TextField ();
        TextField coordP2 = new TextField ();
        TextField coordP3 = new TextField ();
        TextField coordP4 = new TextField ();
        Button validButton = new Button("Valider");
        this.popupVbox.getChildren().addAll(label1, coordP1, label2, coordP2, label3, coordP3, label4, coordP4, validButton);

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
