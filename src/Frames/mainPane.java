package Frames;

import javafx.scene.layout.BorderPane;

public class mainPane extends BorderPane {
    SideMenu sideMenu = new SideMenu();
    Content content = new Content();

    public mainPane() {
        setStyles();
        setLeft(sideMenu);
        setCenter(content.getContent());
        // content.getContent().setAlign
    }

    void setStyles() {
        setStyle("-fx-background-color: gray; -fx-border-color: black;");
    }

}
