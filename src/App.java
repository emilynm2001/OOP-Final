
import javafx.application.Application;
import javafx.stage.Stage;
import Frames.*;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        NotedFrame frame = new NotedFrame();
        frame.start(primaryStage);
    }

    public static void main(String[] args) throws Exception {
        launch();
    }
}