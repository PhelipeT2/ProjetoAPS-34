package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {

    public void closeIcon(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
    public void handleButtonAction(ActionEvent event) throws Exception {
        System.out.println("Proxima cena");
        Parent parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene home_scene = new Scene(parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene);
        app_stage.show();
    }
}
