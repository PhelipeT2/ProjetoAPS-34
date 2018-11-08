package sample;

import Banco.Conexao;
import Model.ModelCadastro;
import Model.ModelReserva;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Login implements Initializable {

    private ModelReserva mReserva;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton botaoLogin;

    @FXML
    private JFXButton btnVoltarLogin;

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

    private ModelCadastro mLogin;
    Stage stage = null;

    public void setModelCadastro(ModelCadastro value) {
        this.mLogin = value;
        textCpf.setText(value.getName());
        //textSenha.setText(value.getSName());
    }

    @FXML
    void acaoBotaoLogin(ActionEvent event) {
        try {
            int id = 0;
            ResultSet rs = null;
            Statement statement = null;
            Conexao conexao = new Conexao();
            conexao.connect();
            statement = conexao.createStatement();
            // falta parte de conexão no banco.
            if (!textCpf.getText().equals("") && !textSenha.getText().equals("")) {

                rs = statement.executeQuery("Select id_User,CPF,Senha from Usuario where CPF = '"+textCpf.getText()+"' and Senha = '"+textSenha.getText()+"'");
                while(rs.next()){
                    id = rs.getInt("id_User");
                }
                mReserva.setCPF(textCpf.getText());
                if (mReserva != null && id != 0) {
                    if((mReserva.getQtdAdulto()+mReserva.getQtdCrianca()) > 1){
                        System.out.println("entrei depedentes");
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Dependentes.fxml"));
                        Parent root = loader.load();
                        Dependentes secondController = loader.getController();
                        secondController.setmReserva(this.mReserva); // metodo para passar valor.
                        Scene home_scene = new Scene(root);
                        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        app_stage.setScene(home_scene);
                        app_stage.show();

                    }else{
                        System.out.println("entrei Pagamento");
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pagamento.fxml"));
                        Parent root = loader.load();
                        Pagamento secondController = loader.getController();
                        secondController.setmReserva(this.mReserva); // metodo para passar valor.
                        Scene home_scene = new Scene(root);
                        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        app_stage.setScene(home_scene);
                        app_stage.show();
                    }
                }else{
                    throw new Exception("Reserva nula ou id = 0");
                }

            } else {
                throw new Exception("Preencha os campos!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    @FXML
    void acaoVoltarLogin(ActionEvent event) throws IOException {
        System.out.println("Voltando para tela inicial");
        Parent parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene home_scene = new Scene(parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene);
        app_stage.show();
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Cadastro.fxml"));
        Parent root = loader.load();
        Cadastro secondController = loader.getController();
        secondController.setmReserva(this.mReserva); // metodo para passar valor.
        Scene home_scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene);
        app_stage.show();
    }
    public void setmReserva(ModelReserva value){
        this.mReserva = value;
    }
    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage("Campo Necessário!");

        textCpf.getValidators().add(validator);
        textCpf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue)
                textCpf.validate();
        });
        textSenha.getValidators().add(validator);
        textSenha.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue)
                textSenha.validate();
        });

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


