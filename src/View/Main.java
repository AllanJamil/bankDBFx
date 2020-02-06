package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("logIn.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1200, 500));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public Stage getWindow() {
        return window;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
