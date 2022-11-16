package Frames;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class NotedFrame {
    mainPane mainPane = new mainPane();

    public void start(Stage primaryStage) {
        Scene scene = new Scene(mainPane, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Noted");
        primaryStage.getIcons().add(new Image("imgs/clipboard.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}