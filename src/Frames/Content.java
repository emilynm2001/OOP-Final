package Frames;

import javafx.scene.layout.AnchorPane;

import Views.AddNote;

public class Content {
    AnchorPane addNoteView = new AddNote();
    // String state = "List_View";
    String state = "AddNote_View";

    public Content() {
    }

    // void setStyles() {
    // setStyle("-fx-background-color: lightblue; -fx-border-color: black;");
    // }

    public AnchorPane getContent() {
        if (state.equals("AddNote_View")) {
            ((AddNote) addNoteView).onClick();
            return addNoteView;
        }

        return addNoteView;
    }

    void addStyles() {
    }

}
