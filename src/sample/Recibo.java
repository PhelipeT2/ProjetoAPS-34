package sample;

import Banco.Conexao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Recibo implements Initializable{
    Stage stage = null;

    @FXML
    void close(MouseEvent event) {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Conexao conexao = new Conexao();
            ResultSet rs = null;
            Statement statement = null;
            conexao.connect();

            statement = conexao.createStatement();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }

    public void min(MouseEvent event) {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }
//
}
