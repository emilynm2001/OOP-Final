package Views;

import NoteCreation.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
// import javafx.scene.layout.HBox;
// import Frames.*;

public class AddNote extends AnchorPane {
    AnchorPane enterFileName = new AnchorPane();
    final TextField fileName = new TextField();
    Label titlelbl = new Label();

    AnchorPane noteText = new AnchorPane();
    final TextField note = new TextField();
    Button saveButton = new Button();
    Button cancelButton = new Button();

    public AddNote() {
        filenameHbox();
        noteText();
        getChildren().addAll(enterFileName, noteText);
    }

    void filenameHbox() {
        fileName.setPromptText("Enter note title: ");
        enterFileName.getChildren().addAll(titlelbl, fileName);
        titlelbl.setAlignment(Pos.TOP_LEFT);
        titlelbl.setText("Title: ");
        titlelbl.setStyle("-fx-font-size: 20px;");
        fileName.setAlignment(Pos.CENTER_LEFT);
        AnchorPane.setTopAnchor(titlelbl, 100 - (100 / 3) * 2.0);
        AnchorPane.setLeftAnchor(titlelbl, 10.0);
        AnchorPane.setTopAnchor(fileName, 100 - (100.0 / 3));
        AnchorPane.setLeftAnchor(fileName, 10.0);

        enterFileName.setStyle("-fx-background-color: white;");
        setStyle("-fx-background-color: black;");
        setTopAnchor(enterFileName, 0.0);
        setBottomAnchor(enterFileName, 600.0);
        setRightAnchor(enterFileName, 0.0);
        setLeftAnchor(enterFileName, 0.0);

    }

    public void onClick() {
        saveButton.setOnMouseReleased(event -> {
            CreateNote newNote = new CreateNote(this.getFileName(), this.getNoteText());
            addNoteToHash(newNote);
        });
    }

    public String getFileName() {
        return fileName.getText();
    }

    public void addNoteToHash(CreateNote note) {

    }

    public String getNoteText() {
        return note.getText();
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    void noteText() {
        noteText.getChildren().addAll(saveButton, cancelButton, note);
        noteText.setStyle("-fx-background-color: white;");
        setTopAnchor(noteText, 100.0);
        setBottomAnchor(noteText, 0.0);
        setRightAnchor(noteText, 0.0);
        setLeftAnchor(noteText, 0.0);
        note.setAlignment(Pos.TOP_LEFT);
        AnchorPane.setTopAnchor(note, 10.0);
        AnchorPane.setRightAnchor(note, 0.0);
        AnchorPane.setLeftAnchor(note, 0.0);
        AnchorPane.setBottomAnchor(note, 100.0);

        saveButton.setMinSize(100, 30);
        saveButton.setText("Save");
        cancelButton.setMinSize(100, 30);
        cancelButton.setText("Cancel");

        AnchorPane.setTopAnchor(saveButton, 535.0);
        AnchorPane.setLeftAnchor(saveButton, 230.0);

        AnchorPane.setTopAnchor(cancelButton, 535.0);
        AnchorPane.setLeftAnchor(cancelButton, 370.0);

    }
}
