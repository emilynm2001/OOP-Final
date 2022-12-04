package Views;

import NoteCreation.*;
import java.util.ArrayList;

import Frames.NotedFrame;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
// import javafx.scene.layout.HBox;
// import Frames.*;

public class AddNote extends AnchorPane {
    AnchorPane enterFileNameAP = new AnchorPane();
    final TextField fileNameTF = new TextField();
    Label titlelbl = new Label();
    private CreateNote newNote;
    // NotesHash hash = new NotesHash();
    public static ArrayList<String> NoteNames = new ArrayList<>();

    AnchorPane noteTextAP = new AnchorPane();
    final TextArea noteTF = new TextArea();
    Button saveButton = new Button();
    Button cancelButton = new Button();

    public AddNote() {
        filenameHbox();
        noteText();
        getChildren().addAll(enterFileNameAP, noteTextAP);
    }

    void filenameHbox() {
        fileNameTF.setPromptText("Enter note title: ");
        enterFileNameAP.getChildren().addAll(titlelbl, fileNameTF);
        titlelbl.setAlignment(Pos.TOP_LEFT);
        titlelbl.setText("New Note: ");
        titlelbl.setStyle(
                "-fx-font-size: 20px; -fx-text-fill: #FFEFD4; -fx-font-weight: bold; -fx-font-family: monospace");
        fileNameTF.setAlignment(Pos.CENTER_LEFT);
        fileNameTF.setStyle(" -fx-focus-color: gray; -fx-background-color: #FFEFD4; -fx-border: gone; ");

        AnchorPane.setTopAnchor(titlelbl, 100 - (100 / 3) * 2.0);
        AnchorPane.setLeftAnchor(titlelbl, 10.0);
        AnchorPane.setTopAnchor(fileNameTF, 100 - (100.0 / 3));
        AnchorPane.setLeftAnchor(fileNameTF, 10.0);
        enterFileNameAP.setStyle("-fx-background-color: #85A1A0;");
        setStyle("-fx-background-color: #85A1A0;");
        setTopAnchor(enterFileNameAP, 0.0);
        setBottomAnchor(enterFileNameAP, 600.0);
        setRightAnchor(enterFileNameAP, 0.0);
        setLeftAnchor(enterFileNameAP, 0.0);

    }

    void noteText() {
        noteTextAP.getChildren().addAll(saveButton, cancelButton, noteTF);
        noteTextAP.setStyle("-fx-background-color: #85A1A0;");
        setTopAnchor(noteTextAP, 100.0);
        setBottomAnchor(noteTextAP, 0.0);
        setRightAnchor(noteTextAP, 0.0);
        setLeftAnchor(noteTextAP, 0.0);
        // noteTF.setAlignment(Pos.TOP_LEFT);
        noteTF.setWrapText(true);
        noteTF.setPromptText("Start Note...");
        noteTF.setStyle(" -fx-focus-color: gray; -fx-control-inner-background: #FFEFD4;  -fx-border: gone; ");
        AnchorPane.setTopAnchor(noteTF, 10.0);
        AnchorPane.setRightAnchor(noteTF, 10.0);
        AnchorPane.setLeftAnchor(noteTF, 10.0);
        AnchorPane.setBottomAnchor(noteTF, 100.0);

        saveButton.setMinSize(100, 30);
        saveButton.setText("Save");
        saveButton.setStyle("-fx-background-color: #EED7AE;-fx-text-fill: #3D5453;");

        saveButton.setOnMouseEntered(e -> {
            saveButton.setStyle("-fx-background-color: #FFEFD4; -fx-text-fill: #3D5453;");
        });
        saveButton.setOnMouseExited(e -> {
            saveButton.setStyle("-fx-background-color: #EED7AE;-fx-text-fill: #3D5453;");
        });
        saveButton.setOnMouseClicked(e -> {
            if (!newNote.fileExists) {
                NotedFrame.getMainPane().getState(0);
            }
        });

        cancelButton.setMinSize(100, 30);
        cancelButton.setText("Cancel");
        cancelButton.setStyle("-fx-background-color: #EED7AE;-fx-text-fill: #3D5453;");
        cancelButton.setOnMouseEntered(e -> {
            cancelButton.setStyle("-fx-background-color: #FFEFD4; -fx-text-fill: #3D5453;");
        });
        cancelButton.setOnMouseExited(e -> {
            cancelButton.setStyle("-fx-background-color: #EED7AE;-fx-text-fill: #3D5453;");
        });

        AnchorPane.setTopAnchor(saveButton, 535.0);
        AnchorPane.setLeftAnchor(saveButton, 230.0);

        AnchorPane.setTopAnchor(cancelButton, 535.0);
        AnchorPane.setLeftAnchor(cancelButton, 370.0);
        cancelButton.setOnMouseReleased(e -> {
            NotedFrame.getMainPane().getState(0);
        });
    }

    public boolean containsFile() {
        return NoteNames.contains(this.getFileName());
    }

    public void onClick() {
        if (!this.getFileName().equals("")) {
            newNote = new CreateNote(this.getFileName(), this.getNoteText());
            if (newNote.isSuccessful())
                NoteNames.add(this.getFileName());
            for (int i = 0; i < NoteNames.size(); i++) {
                System.out.println("ArrayList: " + i + NoteNames.get(i));
            }
            System.out.println("ADDNOTE");
        }

    }

    public String getFileName() {
        return fileNameTF.getText();
    }

    public CreateNote getCreateNote() {
        return this.newNote;
    }

    public ArrayList<String> getNoteNames() {
        return NoteNames;
    }

    public String getNoteText() {
        return noteTF.getText();
    }

    public Button getSaveButton() {
        return this.saveButton;
    }

    public void clearTxtFields() {
        fileNameTF.clear();
        noteTF.clear();
    }

    public Button getCancelButton() {
        return cancelButton;
    }

}
