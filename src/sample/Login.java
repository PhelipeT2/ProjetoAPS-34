package sample;

import Banco.Conexao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton botaoLogin;

    @FXML
    private JFXTextField textCpf;

    @FXML
    private Label lblCPF;

    @FXML
    private Label lblSenha;

    @FXML
    private Label lblNaoTemCadastro;

    @FXML
    private Label lblEsqueceu;

    @FXML
    private JFXPasswordField textSenha;

    @FXML
    private RadioButton radioLembrar;

    @FXML
    private ImageView imgAviao;

    @FXML
    private Label lblLogin;

    Stage stage = null;

    Conexao conexao = new Conexao();

    @FXML
    void acaoBotaoLogin(ActionEvent event) throws IOException {

        /*if(textCpf == null || textSenha == null){
            JOptionPane.showMessageDialog(null, "Preencha os campos");
        }
        else {
            System.out.println("Encaminhando para fazer a reserva apos o login efetuado com sucesso");
            Parent parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene home_scene = new Scene(parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(home_scene);
            app_stage.show();
        }*/
    }

    @FXML
    void close(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void esqueceuSenha(MouseEvent event) {
    }

    @FXML
    void min(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void naoTemCadastro(MouseEvent event) throws IOException {
        System.out.println("Encaminhando para fazer o cadastro");
        Parent parent = FXMLLoader.load(getClass().getResource("cadastro.fxml"));
        Scene home_scene = new Scene(parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene);
        app_stage.show();
    }

    @FXML
    void initialize() {
        assert botaoLogin != null : "fx:id=\"botaoLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert textCpf != null : "fx:id=\"textCpf\" was not injected: check your FXML file 'Login.fxml'.";
        assert lblCPF != null : "fx:id=\"lblCPF\" was not injected: check your FXML file 'Login.fxml'.";
        assert lblSenha != null : "fx:id=\"lblSenha\" was not injected: check your FXML file 'Login.fxml'.";
        assert lblNaoTemCadastro != null : "fx:id=\"lblNaoTemCadastro\" was not injected: check your FXML file 'Login.fxml'.";
        assert lblEsqueceu != null : "fx:id=\"lblEsqueceu\" was not injected: check your FXML file 'Login.fxml'.";
        assert textSenha != null : "fx:id=\"textSenha\" was not injected: check your FXML file 'Login.fxml'.";
        assert radioLembrar != null : "fx:id=\"radioLembrar\" was not injected: check your FXML file 'Login.fxml'.";
        assert imgAviao != null : "fx:id=\"imgAviao\" was not injected: check your FXML file 'Login.fxml'.";
        assert lblLogin != null : "fx:id=\"lblLogin\" was not injected: check your FXML file 'Login.fxml'.";

    }
}


