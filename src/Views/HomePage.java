package Views;

import Frames.NotedFrame;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class HomePage extends AnchorPane {
        AnchorPane topContainer = new AnchorPane();
        AnchorPane bottomContainer = new AnchorPane();
        Label welcome = new Label();

        public HomePage() {
                topContainer();
                bottomContainer();
                getChildren().addAll(topContainer, bottomContainer);

        }

        private void topContainer() {
                HBox welcomeBox = new HBox();
                welcome.setText("Welcome to Noted!");
                welcome.setStyle(
                                "-fx-font-size: 40px; -fx-font-family: monospace; -fx-font-weight: bold; -fx-text-fill: #EED7AE;");
                welcomeBox.setAlignment(Pos.TOP_CENTER);
                welcomeBox.getChildren().add(welcome);
                topContainer.getChildren().add(welcomeBox);
                AnchorPane.setTopAnchor(welcomeBox, 250.0);
                AnchorPane.setBottomAnchor(welcomeBox, 600.0);
                AnchorPane.setRightAnchor(welcomeBox, 10.0);
                AnchorPane.setLeftAnchor(welcomeBox, 10.0);
                topContainer.setStyle("-fx-background-color: #85A1A0");
                setTopAnchor(topContainer, 0.0);
                setBottomAnchor(topContainer, 0.0);
                setRightAnchor(topContainer, 0.0);
                setLeftAnchor(topContainer, 0.0);
        }

        private void bottomContainer() {
                HBox button = createNewNoteButton();
                HBox button2 = viewNoteButton();

                bottomContainer.getChildren().addAll(button, button2);
                button.setAlignment(Pos.CENTER);
                button2.setAlignment(Pos.CENTER);

                bottomContainer.setStyle("-fx-background-color: #85A1A0");
                setTopAnchor(bottomContainer, 300.0);
                setBottomAnchor(bottomContainer, 0.0);
                setRightAnchor(bottomContainer, 0.0);
                setLeftAnchor(bottomContainer, 0.0);
                AnchorPane.setTopAnchor(button, 40.0);
                AnchorPane.setRightAnchor(button, 120.0);
                AnchorPane.setLeftAnchor(button, 120.0);
                AnchorPane.setBottomAnchor(button, 450.0);

                AnchorPane.setTopAnchor(button2, 190.0);
                AnchorPane.setRightAnchor(button2, 120.0);
                AnchorPane.setLeftAnchor(button2, 120.0);
                AnchorPane.setBottomAnchor(button2, 300.0);

        }

        private HBox createNewNoteButton() {
                HBox box = new HBox();
                Label buttonlbl = new Label("Create New Note!");
                buttonlbl.setStyle(
                                "-fx-font-size: 20px; -fx-font-family: monospace; -fx-font-weight: bold; -fx-text-fill: #EED7AE;");
                buttonlbl.setAlignment(Pos.CENTER);
                box.getChildren().add(buttonlbl);
                box.setAlignment(Pos.BOTTOM_CENTER);
                box.setStyle(
                                "-fx-background-color: #85A1A0; -fx-border-width: 4; -fx-border-radius: 10px; -fx-border-color: #EED7AE");
                box.setOnMouseEntered(e -> {
                        box.setStyle(
                                        "-fx-background-color: #6865A1; -fx-border-width: 4;  -fx-border-color: EED7AE");
                        buttonlbl.setStyle(
                                        "-fx-font-size: 20px; -fx-font-weight: bold;-fx-font-family: monospace; -fx-text-fill: EED7AE;");
                });
                box.setOnMouseExited(e -> {
                        box.setStyle(
                                        "-fx-background-color: #85A1A0; -fx-border-width: 4; -fx-border-radius: 10px; -fx-border-color: #EED7AE");
                        buttonlbl.setStyle(
                                        "-fx-font-size: 20px; -fx-font-weight: bold; -fx-font-family: monospace; -fx-text-fill: #EED7AE;");
                });
                box.setOnMouseClicked(e -> {
                        NotedFrame.getMainPane().getState(1);
                });
                return box;
        }

        private HBox viewNoteButton() {
                HBox box = new HBox();
                Label buttonlbl = new Label("View Notes");
                buttonlbl.setStyle(
                                "-fx-font-size: 20px; -fx-font-family: monospace; -fx-font-weight: bold; -fx-text-fill: #EED7AE;");
                buttonlbl.setAlignment(Pos.CENTER);
                box.getChildren().add(buttonlbl);
                box.setAlignment(Pos.BOTTOM_CENTER);
                box.setStyle(
                                "-fx-background-color: #85A1A0; -fx-border-width: 4; -fx-border-radius: 10px;-fx-border-color: #EED7AE");
                box.setOnMouseEntered(e -> {
                        box.setStyle(
                                        "-fx-background-color: #6865A1; -fx-border-width: 4; -fx-border-color: EED7AE");
                        buttonlbl.setStyle(
                                        "-fx-font-size: 20px; -fx-font-weight: bold;-fx-font-family: monospace; -fx-text-fill: EED7AE;");
                });
                box.setOnMouseExited(e -> {
                        box.setStyle(
                                        "-fx-background-color: #85A1A0; -fx-border-width: 4;-fx-border-radius: 10px; -fx-border-color: #EED7AE");
                        buttonlbl.setStyle(
                                        "-fx-font-size: 20px; -fx-font-weight: bold;-fx-font-family: monospace; -fx-text-fill: #EED7AE;");
                });
                box.setOnMouseClicked(e -> {
                        NotedFrame.getMainPane().getState(2);
                });
                return box;
        }
}
