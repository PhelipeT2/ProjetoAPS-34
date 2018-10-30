package sample;

import Banco.Conexao;
import com.jfoenix.controls.JFXComboBox;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private JFXComboBox<String> cbx_Origem;

    @FXML
    private JFXComboBox<String> cbx_Destino;

    @FXML
    private JFXComboBox<Integer> cbx_Adulto;

    @FXML
    private JFXComboBox<Integer> cbx_Crianca;
    double x,y;
    Stage stage = null;

    Conexao conexao = new Conexao();

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
    public void closeIcon(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
    public void handleButtonAction(ActionEvent event) throws Exception {

         FXMLLoader loader = new FXMLLoader(getClass().getResource("Reserva.fxml"));
         Parent root = loader.load();
         Reserva secondController = loader.getController();
         secondController.setTtotal("Teste"); // metodo para passar valor.
         Scene home_scene = new Scene(root);
         Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         app_stage.setScene(home_scene);
         app_stage.show();
//        System.out.println("Proxima cena");
//        Parent parent = FXMLLoader.load(getClass().getResource("Reserva.fxml"));
//        Scene home_scene = new Scene(parent);
//        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        app_stage.setScene(home_scene);
//        app_stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            ResultSet rs = null;
            Statement statement = null;
            conexao.connect();

            for (int i = 1; i < 10; i++) {
                cbx_Adulto.getItems().add(i);
                cbx_Crianca.getItems().add(i);
            }

            statement = conexao.createStatement();
            rs = statement.executeQuery("Select Nome from Paises");

            while(rs.next()){
            cbx_Origem.getItems().add(rs.getString("Nome"));
            cbx_Destino.getItems().add(rs.getString("Nome"));
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
}
