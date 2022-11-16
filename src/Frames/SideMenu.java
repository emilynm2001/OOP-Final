package Frames;

import javafx.scene.layout.VBox;

public class SideMenu extends VBox {
    SideMenu() {
        setStyles();
    }

    public void setStyles() {
        setStyle("-fx-background-color: yellow; -fx-border-color: black;");
        setMinSize(200, 600);
    }
}
