package sample;

import Banco.Conexao;
import Model.ModelCadastro;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
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

import static javax.swing.JOptionPane.YES_OPTION;

public class Cadastro implements Initializable{
    private ModelCadastro mCadastro;
    public JFXTextField Name, Doc, Age, Email, Tel;
    public JFXPasswordField Pwd;

    private Stage stage = null;

    public void setModelCadastro(ModelCadastro value) {
        this.mCadastro = value;
        Name.setText(value.getName());
        Doc.setText(value.getDoc());
        Email.setText(value.getEmail());
        Age.setText(String.valueOf(value.getAge()));
        Tel.setText(String.valueOf(value.getTel()));
        Pwd.setText(value.getPwd());

        try{
            if(this.mCadastro != null){
                Conexao conexao = new Conexao();
                ResultSet rs = null;
                Statement statement = null;
                conexao.connect();
                statement = conexao.createStatement();
                rs = statement.executeQuery("SELECT P.id as Pessoa, P.Nome as Pessoa, P.Sobrenome as Pessoa, P.Data_Nascimento as Pessoa, P.Documento as Pessoa," +
                        "P.Telefone as Pessoa, C.Email as Cliente, C.Senha as Cliente \n" +
                        "FROM Pessoa as P \n" +
                        "INNER JOIN Cliente as C ON P.Documento = C.id_Pessoa");

                System.out.println("Teste");
                statement.close();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void clear() {
        int opcao = JOptionPane.showConfirmDialog(null,
                "Deseja realmente limpar os dados ?",
                "Limpar Dados",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(opcao == YES_OPTION) {
            Name.clear();
            Doc.clear();
            Age.clear();
            Email.clear();
            Tel.clear();
            Pwd.clear();
        }else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cadastro.fxml"));
        }
    }

    @FXML
    void close(MouseEvent event) {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void min(MouseEvent event) {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void next(MouseEvent event) throws Exception {
        try {
            Conexao conexao = new Conexao();
            ResultSet rs = null;
            Statement statement = null;
            conexao.connect();
            statement = conexao.createStatement();
            statement.executeUpdate("insert into Pessoa(id, Nome, Data_Nascimento, Documento, Telefone) " +
                    "values Nome = \'"+Name.getText()+"\' and Data_Nascimento = \'"+Age.getText()+"\' " +
                    "and Documento = \'"+Doc.getText()+"\' and Telefone = \'"+Tel.getText()+" \'");
            statement.executeUpdate("insert into Cliente(CPF, Email, Senha) " +
                    "values CPF = \'"+Doc.getText()+"\' and Email = \'"+Email.getText()+"\' and Senha = \'"+Pwd.getText()+"\' ");

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        if(Name.getText() != null && Doc.getText() != null && Age.getText() != null
                && Email.getText() != null && Tel.getText() != null && Pwd.getText() !=null) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dependentes.fxml"));
            Parent root = loader.load();
            Scene home_scene = new Scene(root);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(home_scene);
            app_stage.show();
        }else{
            System.out.println("Preencha os campos!");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage("Campo Necessário!");

        Name.getValidators().add(validator);
        Name.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                Name.validate();
        });
        Doc.getValidators().add(validator);
        Doc.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                Doc.validate();
        });
        Age.getValidators().add(validator);
        Age.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                Age.validate();
        });
        Email.getValidators().add(validator);
        Email.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                Email.validate();
        });
        Tel.getValidators().add(validator);
        Tel.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                Tel.validate();
        });
    }

    public void prev(MouseEvent mouseEvent) throws Exception {
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader1.load();
        Scene home_scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene);
        app_stage.show();
    }
}