package Views;

import Frames.NotedFrame;
import NoteCreation.CreateNote;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class ViewNote extends AnchorPane {
    private AnchorPane mainContainer, bottomContainer;
    // private HBox mainBox, bottomBox, defaultBox;
    private HBox defaultBox;
    private Button editButton, cancelButton, deleteNoteButton;
    private Label defaultLbl;

    public ViewNote() {
        bottomContainer = new AnchorPane();
        mainContainer = new AnchorPane();
        cancelButton = new Button();
        editButton = new Button();
        deleteNoteButton = new Button();
        defaultBox = new HBox();
        defaultLbl = new Label();

        // welcome = new Label("VIEW PAGE");
        mainContainer();
        getChildren().addAll(mainContainer, bottom());

    }

    private void mainContainer() {
        defaultMessage();
        setTopAnchor(mainContainer, 0.0);
        setBottomAnchor(mainContainer, 0.0);
        setRightAnchor(mainContainer, 0.0);
        setLeftAnchor(mainContainer, 0.0);
        mainContainer.setStyle("-fx-background-color: #FFEFD4;");
    }

    private void defaultMessage() {
        defaultLbl.setText("You have no Notes!");
        defaultLbl.setStyle(
                "-fx-font-size: 40px; -fx-font-family: monospace; -fx-text-fill: gray;");

        defaultBox.getChildren().add(defaultLbl);
        defaultBox.setAlignment(Pos.CENTER);
        getChildren().add(defaultBox);
        mainContainer.getChildren().add(defaultBox);
        AnchorPane.setTopAnchor(defaultBox, 250.0);
        AnchorPane.setBottomAnchor(defaultBox, 600.0);
        AnchorPane.setRightAnchor(defaultBox, 10.0);
        AnchorPane.setLeftAnchor(defaultBox, 10.0);
    }

    public void noteSpecifier(String key, CreateNote cNote) {
        // welcome = new Label(key);
        // mainBox.getChildren().add(welcome);
        // getChildren().add(mainBox);
        // cNote.getHashMap().get(key);
        addNoteToView(key, cNote.getHashMap().get(key));
    }

    private void addNoteToView(String key, String note) {
        // mainBox
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

        bottomContainer.getChildren().addAll(editButton, cancelButton, deleteNoteButton);
        editButton.setStyle("-fx-background-color: #EED7AE;-fx-text-fill: #3D5453;");
        editButton.setOnMouseEntered(e -> {
            editButton.setStyle("-fx-background-color: #FFEFD4;-fx-text-fill: #3D5453;");
        });
        editButton.setOnMouseExited(e -> {
            editButton.setStyle("-fx-background-color: #EED7AE;-fx-text-fill: #3D5453;");
        });
        editButton.setOnMouseClicked(e -> {
            System.out.println("EDIT NOTE");
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
        });
        return bottomContainer;

    }
}
