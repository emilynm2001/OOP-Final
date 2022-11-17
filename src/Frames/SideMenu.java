package Frames;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SideMenu extends VBox {
    SideMenu() {
        setStyles();
    }

    public void setStyles() {
        setStyle("-fx-background-color: white; -fx-border-color: black;");
        setMinSize(200, 600);
    }

    public void addHBox(String fileName) {
        HBox note = new HBox();
        Label filename = new Label();
        filename.setText(fileName);
        note.getChildren().add(filename);
        getChildren().add(note);
    }
}
