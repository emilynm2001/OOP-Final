package Views;

import Frames.NotedFrame;
import NoteCreation.CreateNote;
import NoteCreation.DeleteNote;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class ViewNote extends AnchorPane {
    private AnchorPane mainContainer, bottomContainer;
    private HBox mainBox, promptBox, defaultBox;
    private Button editButton, cancelButton, deleteNoteButton;
    private Label defaultLbl, titleLbl, promptLbl;
    private TextArea noteTA;
    private String currKey, currNote;
    private CreateNote cNote;
    private DeleteNote deleteNote;

    public ViewNote() {
        bottomContainer = new AnchorPane();
        mainContainer = new AnchorPane();
        cancelButton = new Button();
        editButton = new Button();
        deleteNoteButton = new Button();
        defaultBox = new HBox();
        defaultLbl = new Label();
        mainBox = new HBox();
        titleLbl = new Label();
        noteTA = new TextArea();
        promptLbl = new Label();
        promptBox = new HBox();

        // welcome = new Label("VIEW PAGE");
        defaultMessage();
        getChildren().addAll(mainContainer, bottom());

    }

    private void mainContainer() {
        setTopAnchor(mainContainer, 0.0);
        setBottomAnchor(mainContainer, 0.0);
        setRightAnchor(mainContainer, 0.0);
        setLeftAnchor(mainContainer, 0.0);
        mainContainer.setStyle("-fx-background-color: #FFEFD4;");
    }

    private void defaultMessage() {
        reset();

        defaultLbl.setText("You have no Notes!");
        defaultLbl.setStyle(
                "-fx-font-size: 40px; -fx-font-family: monospace; -fx-text-fill: gray;");
        defaultBox.getChildren().add(defaultLbl);
        defaultBox.setAlignment(Pos.CENTER);
        mainContainer.getChildren().add(defaultBox);
        AnchorPane.setTopAnchor(defaultBox, 250.0);
        AnchorPane.setBottomAnchor(defaultBox, 600.0);
        AnchorPane.setRightAnchor(defaultBox, 10.0);
        AnchorPane.setLeftAnchor(defaultBox, 10.0);
        mainContainer();
    }

    public void noteSelectPrompt() {
        reset();
        promptLbl.setText("Select a note!");
        promptLbl.setStyle(
                "-fx-font-size: 40px; -fx-font-family: monospace; -fx-text-fill: gray;");
        promptBox.getChildren().add(promptLbl);
        promptBox.setAlignment(Pos.CENTER);
        mainContainer.getChildren().add(promptBox);
        AnchorPane.setTopAnchor(promptBox, 250.0);
        AnchorPane.setBottomAnchor(promptBox, 600.0);
        AnchorPane.setRightAnchor(promptBox, 10.0);
        AnchorPane.setLeftAnchor(promptBox, 10.0);
        mainContainer();
    }

    public void noteSpecifier(String key, CreateNote cNote) {
        this.cNote = cNote;
        addNoteToView(key, cNote.getHashMap().get(key));
    }

    private void addNoteToView(String key, String note) {
        reset();
        this.currKey = key;
        this.currNote = note;
        titleLbl.setText(key);
        titleLbl.setStyle("-fx-font-size: 20px; -fx-text-fill: gray;");
        mainBox.setAlignment(Pos.CENTER_LEFT);
        mainBox.getChildren().add(titleLbl);
        mainBox.setStyle("");
        noteTA.setEditable(false);
        noteTA.setText(note);
        noteTA.setWrapText(true);
        noteTA.setStyle(" -fx-focus-color: transparent; -fx-control-inner-background: #FFEFD4; -fx-border: gone;");
        noteTA.setFocusTraversable(false);
        mainContainer.getChildren().addAll(mainBox, noteTA);
        AnchorPane.setTopAnchor(mainBox, 0.0);
        AnchorPane.setBottomAnchor(mainBox, 900.0);
        AnchorPane.setRightAnchor(mainBox, 10.0);
        AnchorPane.setLeftAnchor(mainBox, 10.0);

        AnchorPane.setTopAnchor(noteTA, 100.0);
        AnchorPane.setBottomAnchor(noteTA, 500.0);
        AnchorPane.setRightAnchor(noteTA, 10.0);
        AnchorPane.setLeftAnchor(noteTA, 10.0);

        mainContainer();
    }

    private void reset() {
        mainContainer.getChildren().remove(mainBox);
        mainContainer.getChildren().remove(noteTA);
        mainContainer.getChildren().remove(defaultBox);
        mainContainer.getChildren().remove(promptBox);

        mainBox.getChildren().remove(titleLbl);
        noteTA.setText("");
        promptBox.getChildren().remove(promptLbl);
        defaultBox.getChildren().remove(defaultLbl);

    }

    private AnchorPane bottom() {
        bottomContainer.setStyle("-fx-background-color: #85A1A0;");
        setTopAnchor(bottomContainer, 600.0);
        setBottomAnchor(bottomContainer, 0.0);
        setRightAnchor(bottomContainer, 0.0);
        setLeftAnchor(bottomContainer, 0.0);

        editButton.setMinSize(100, 30);
        editButton.setText("Edit");
        cancelButton.setMinSize(100, 30);
        cancelButton.setText("Cancel");
        deleteNoteButton.setMinSize(100, 30);
        deleteNoteButton.setText("Delete");

        AnchorPane.setTopAnchor(editButton, 20.0);
        AnchorPane.setBottomAnchor(editButton, 400.0);
        AnchorPane.setLeftAnchor(editButton, 75.0);

        AnchorPane.setTopAnchor(cancelButton, 20.0);
        AnchorPane.setBottomAnchor(cancelButton, 400.0);
        AnchorPane.setLeftAnchor(cancelButton, editButton.getMinWidth() + cancelButton.getMinWidth() + 75 + 40);

        AnchorPane.setTopAnchor(deleteNoteButton, 20.0);
        AnchorPane.setBottomAnchor(deleteNoteButton, 400.0);
        AnchorPane.setLeftAnchor(deleteNoteButton, editButton.getMinWidth() + 75 + 20);
        bottomContainer.getChildren().add(cancelButton);
        editButton.setStyle("-fx-background-color: #EED7AE;-fx-text-fill: #3D5453;");
        editButton.setOnMouseEntered(e -> {
            editButton.setStyle("-fx-background-color: #FFEFD4;-fx-text-fill: #3D5453;");
        });
        editButton.setOnMouseExited(e -> {
            editButton.setStyle("-fx-background-color: #EED7AE;-fx-text-fill: #3D5453;");
        });
        editButton.setOnMouseClicked(e -> {
            NotedFrame.getMainPane().getState(3);
        });
        cancelButton.setStyle("-fx-background-color: #EED7AE;-fx-text-fill: #3D5453;");
        cancelButton.setOnMouseEntered(e -> {
            cancelButton.setStyle("-fx-background-color: #FFEFD4; -fx-text-fill: #3D5453;");
        });
        cancelButton.setOnMouseExited(e -> {
            cancelButton.setStyle("-fx-background-color: #EED7AE;-fx-text-fill: #3D5453;");
        });
        cancelButton.setOnMouseClicked(e -> {
            NotedFrame.getMainPane().getState(0);
        });
        deleteNoteButton.setStyle("-fx-background-color: #EED7AE;-fx-text-fill: #3D5453;");
        deleteNoteButton.setOnMouseEntered(e -> {
            deleteNoteButton.setStyle("-fx-background-color: #FFEFD4;-fx-text-fill: #3D5453;");
        });
        deleteNoteButton.setOnMouseExited(e -> {
            deleteNoteButton.setStyle("-fx-background-color: #EED7AE;-fx-text-fill: #3D5453;");
        });
        deleteNoteButton.setOnMouseClicked(e -> {
            System.out.println("DELETE NOTE");
            deleteNote = new DeleteNote(currKey, currNote, cNote);
            NotedFrame.getMainPane().getState(0);
            NotedFrame.getMainPane().getSideMenu().removeHbox(NotedFrame.getMainPane().getNoteNames(), currKey);
        });
        return bottomContainer;

    }

    public String getKey() {
        return this.currKey;
    }

    public String getNote() {
        return this.currNote;
    }

    public CreateNote getCreateNote() {
        return this.cNote;
    }

    public void addEditAndDelete() {
        bottomContainer.getChildren().remove(editButton);
        bottomContainer.getChildren().remove(deleteNoteButton);
        bottomContainer.getChildren().addAll(editButton, deleteNoteButton);
    }
}
