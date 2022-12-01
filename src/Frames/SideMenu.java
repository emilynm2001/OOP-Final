package Frames;

import java.util.ArrayList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SideMenu extends VBox {
    Button newNoteButton;
    ArrayList<String> names = new ArrayList<>();
    ArrayList<HBox> hBoxArray = new ArrayList<>();
    String hashKey = "";
    HBox defaultBox = new HBox();
    Label defaultLbl = new Label();

    public SideMenu() {
        setStyles();
        getChildren().addAll(topLabel(), getSeparator("h"));
        addDefault();
    }

    public void setStyles() {
        setStyle("-fx-background-color: #B9EDED");
        setMinSize(200, 600);
    }

    private void addDefault() {
        defaultLbl.setText("Look's Empty!");
        defaultLbl.setStyle(
                "-fx-font-size: 15px; -fx-font-family: monospace; -fx-text-fill: gray;");

        defaultBox.getChildren().add(defaultLbl);
        defaultBox.setAlignment(Pos.CENTER);
        getChildren().add(defaultBox);
    }

    private HBox topLabel() {
        HBox container = new HBox();
        Label n = new Label("Saved notes:");
        container.setStyle("");
        container.setAlignment(Pos.TOP_LEFT);
        n.setStyle(
                "-fx-font-size: 20px; -fx-padding: 5; -fx-font-family: monospace; -fx-font-weight: bold; -fx-text-fill: gray;");
        container.getChildren().add(n);
        // getChildren().add(container);
        return container;

    }

    // public void addName(String name) {
    // this.names.add(Content.getName());
    // addHBox(names);
    // }
    public Separator getSeparator(String orientation) {
        Separator hSeparator = new Separator(Orientation.HORIZONTAL);
        // hSeparator.setStyle("-fx-background-color: #D8F2FC;");
        Separator vSeparator = new Separator(Orientation.VERTICAL);
        // vSeparator.setStyle("-fx-background-color: white;");
        if (orientation.equals("v"))
            return vSeparator;
        return hSeparator;

    }

    public void addHBox(ArrayList<String> noteNames) {
        // AddNote.NoteNames = noteNames;
        for (int i = 0; i < noteNames.size(); i++) {
            if (noteNames.size() > this.names.size()) {
                if (i == (noteNames.size() - 1)) {
                    getChildren().remove(defaultBox);
                    this.names.add(noteNames.get(i));
                    System.out.print(noteNames.get(i));
                    String fn = noteNames.get(i);
                    HBox noteBox = new HBox();
                    Label filename = new Label();
                    // noteBox.setStyle("-fx-background-color: #8AFD8A; -fx-border-color: white;");
                    filename.setStyle(
                            "-fx-font-size: 15px;-fx-font-family: monospace; -fx-padding: 5; -fx-text-fill: white;");
                    noteBox.setAlignment(Pos.CENTER_LEFT);
                    noteBox.setStyle(
                            "-fx-border-outsets: 5px; -fx-background-color: #A5A1ED; -fx-border-width: 4; -fx-border-color: #B9EDED");
                    filename.setText(fn + ".txt");
                    noteBox.getChildren().add(filename);
                    getChildren().addAll(noteBox, getSeparator("h"));
                    sethBoxArray(noteBox);
                    noteBox.setOnMouseEntered(e -> {
                        noteBox.setStyle(
                                "-fx-background-color: #6865A1; -fx-border-width: 4; -fx-border-color: #B9EDED");
                        filename.setStyle(
                                "-fx-font-size: 15px; -fx-font-family: monospace;-fx-padding: 5; -fx-text-fill: white;");

                    });
                    noteBox.setOnMouseExited(e -> {
                        noteBox.setStyle(
                                "-fx-border-outsets: 5px; -fx-background-color: #A5A1ED; -fx-border-width: 4; -fx-border-color: #B9EDED");
                        filename.setStyle(
                                "-fx-font-size: 15px; -fx-font-family: monospace; -fx-padding: 5; -fx-text-fill: white;");
                    });
                    noteBox.setOnMouseClicked(e -> {
                        setHashKey(fn);
                        NotedFrame.getMainPane().getState(2);
                    });
                }
            }
        }
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }

    public String getHashKey() {
        return this.hashKey;
    }

    public void sethBoxArray(HBox noteBox) {
        this.hBoxArray.add(noteBox);
    }

    public ArrayList<HBox> gethBoxArray() {
        return this.hBoxArray;
    }
}
