package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("TestThread.fxml"));
        primaryStage.setTitle("Indians Airlines");
//        Parent root2 = FXMLLoader.load(getClass().getResource("Lugares.fxml"));
//        primaryStage.setTitle("Indias Airlines");

        Scene scene = new Scene(root);
        scene.getStylesheets().addAll("css/style.css");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        //primaryStage.setResizable(false);
        primaryStage.show();
        ///

    }

    public static void main(String[] args) {
        launch(args);
    }
}
