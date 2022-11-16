package Frames;

import javafx.scene.layout.AnchorPane;

import java.io.ObjectInputStream.GetField;

import NoteCreation.*;
import Views.AddNote;

public class Content {
    CreateNote createNote = new CreateNote("sd");
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

            return addNoteView;
        }

        return addNoteView;
    }

    void addStyles() {
    }
}
