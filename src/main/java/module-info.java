module fr.minesales.imtjavapoo1 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens fr.minesales.imtjavapoo1 to javafx.fxml;
    exports fr.minesales.imtjavapoo1;
}