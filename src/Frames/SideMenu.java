package Frames;

import java.util.ArrayList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SideMenu extends ScrollPane {
    Button newNoteButton;
    ArrayList<String> names = new ArrayList<>();
    ArrayList<HBox> hBoxArray = new ArrayList<>();
    ArrayList<Separator> separators = new ArrayList<>();
    String hashKey = "";
    HBox defaultBox = new HBox();
    Label defaultLbl = new Label();
    VBox sidemenuBox = new VBox();

    public SideMenu() {
        setStyles();
        this.sidemenuBox.getChildren().addAll(topLabel());
        addDefault();
        getChildren().add(sidemenuBox);
        setContent(this.sidemenuBox);
        setPrefSize(200, 720);
    }

    public void setStyles() {
        this.sidemenuBox.setStyle("-fx-background-color: #B9EDED");
        this.sidemenuBox.setMinSize(200, 710);
        setFitToWidth(true);
        setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        setPannable(true);
    }

    private void addDefault() {
        defaultLbl.setText("Look's Empty!");
        defaultLbl.setStyle(
                "-fx-font-size: 15px; -fx-font-family: monospace; -fx-text-fill: gray;");
        defaultBox.getChildren().add(defaultLbl);
        defaultBox.setAlignment(Pos.CENTER);
        this.sidemenuBox.getChildren().addAll(getSeparator("h"), defaultBox);

    }

    private HBox topLabel() {
        HBox container = new HBox();
        Label n = new Label("Saved notes:");
        container.setStyle("");
        container.setAlignment(Pos.TOP_LEFT);
        n.setStyle(
                "-fx-font-size: 20px; -fx-padding: 5; -fx-font-family: monospace; -fx-font-weight: bold; -fx-text-fill: gray;");
        container.getChildren().add(n);
        return container;

    }

    public Separator getSeparator(String orientation) {
        Separator hSeparator = new Separator(Orientation.HORIZONTAL);
        Separator vSeparator = new Separator(Orientation.VERTICAL);
        if (orientation.equals("v"))
            return vSeparator;
        return hSeparator;
    }

    public void addHBox(ArrayList<String> noteNames) {
        for (int i = 0; i < noteNames.size(); i++) {
            if (noteNames.size() > this.names.size()) {
                if (i == (noteNames.size() - 1)) {
                    this.sidemenuBox.getChildren().remove(defaultBox);
                    this.names.add(noteNames.get(i));
                    System.out.print(noteNames.get(i));
                    String fn = noteNames.get(i);
                    HBox noteBox = new HBox();
                    Label filename = new Label();
                    Separator hboxSeparator = new Separator();
                    filename.setStyle(
                            "-fx-font-size: 15px;-fx-font-family: monospace; -fx-padding: 5; -fx-text-fill: white;");
                    noteBox.setAlignment(Pos.CENTER_LEFT);
                    noteBox.setStyle(
                            "-fx-border-outsets: 5px; -fx-background-color: #A5A1ED; -fx-border-width: 4; -fx-border-color: #B9EDED");
                    filename.setText(fn + ".txt");
                    noteBox.getChildren().add(filename);
                    hboxSeparator = getSeparator("h");
                    this.sidemenuBox.getChildren().addAll(noteBox, hboxSeparator);
                    sethBoxArray(noteBox);
                    separators.add(i, hboxSeparator);
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

    public void removeHbox(ArrayList<String> noteNames, String filename) {
        for (int i = 0; i < noteNames.size(); i++) {
            if (noteNames.get(i).equals(filename)) {
                noteNames.remove(i);
                names.remove(i);
                this.sidemenuBox.getChildren().remove(hBoxArray.get(i));
                this.sidemenuBox.getChildren().remove(separators.get(i));
                if (hBoxArray.size() == 1)
                    this.sidemenuBox.getChildren().add(defaultBox);
                hBoxArray.remove(i);
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
}
