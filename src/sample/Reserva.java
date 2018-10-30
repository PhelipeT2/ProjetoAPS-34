package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Reserva implements Initializable {
    @FXML
    private Text Ttotal;

    double x,y;
    Stage stage = null;
    @FXML
    void dragedMenu(MouseEvent event) {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    void pressedMenu(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }
    @FXML
    void min(MouseEvent event) {
         stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
         stage.setIconified(true);
    }

    @FXML
    void close(MouseEvent event) {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void setTtotal(String value){
        this.Ttotal.setText(value);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
