package sample;

import Banco.Conexao;
import Model.ModelCadastro;
import Model.ModelReserva;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
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
    public JFXTextField Name, SName, Doc, Age, Addr, Numb, Zip, City, Stt, Email, Tel, KidName, KidSName, KidAge, KidDoc;
    public JFXButton next;
    public JFXComboBox <String> cbx_Doc, cbx_KidDoc;

    private Stage stage = null;

    public void setModelCadastro(ModelCadastro value){
        this.mCadastro = value;
        Name.setText(value.getName());
        SName.setText(value.getSName());
        Doc.setText(value.getDoc());
        Addr.setText(value.getAdd());
        City.setText(value.getCity());
        Stt.setText(value.getStt());
        Email.setText(value.getEmail());
        KidName.setText(value.getKidName());
        KidSName.setText(value.getKidSName());
        KidDoc.setText(value.getKidDoc());
        Age.setText(value.getAge());
        KidAge.setText(value.getKidAge());


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
            SName.clear();
            Doc.clear();
            Age.clear();
            Addr.clear();
            Numb.clear();
            Zip.clear();
            City.clear();
            Stt.clear();
            Email.clear();
            Tel.clear();
            KidName.clear();
            KidSName.clear();
            KidAge.clear();
            KidDoc.clear();
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
        if(Name.getText() != null && SName.getText() != null && cbx_Doc.getSelectionModel().getSelectedItem() != null &&
        Doc.getText() != null && Age.getText() != null && Addr.getText() != null && Numb.getText() != null &&
        Zip.getText() != null && City.getText() != null && Stt.getText() != null && Email.getText() != null &&
        Tel.getText() != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Pagamento.fxml"));
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
        SName.getValidators().add(validator);
        SName.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                SName.validate();
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
        Addr.getValidators().add(validator);
        Addr.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                Addr.validate();
        });
        Numb.getValidators().add(validator);
        Numb.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                Numb.validate();
        });
        Zip.getValidators().add(validator);
        Zip.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                Zip.validate();
        });
        City.getValidators().add(validator);
        City.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                City.validate();
        });
        Stt.getValidators().add(validator);
        Stt.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                Stt.validate();
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
        KidName.getValidators().add(validator);
        KidName.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                KidName.validate();
        });
        KidSName.getValidators().add(validator);
        KidSName.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                KidSName.validate();
        });
        KidDoc.getValidators().add(validator);
        KidDoc.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                KidDoc.validate();
        });
        KidAge.getValidators().add(validator);
        KidAge.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                KidAge.validate();
        });
        try{
            Conexao conexao = new Conexao();
            ResultSet rs = null;
            Statement statement = null;
            conexao.connect();

            //Testando!! Inserindo infos do TextField para o DB.
            rs = statement.executeQuery("Select pes.Nome as Name, pes.Sobrenome as SName, pes.Data_Nascimento as Age, pes.Documento as Doc," +
                    " pes.Telefone as Tel, c.Email as Email, e.Endereço as Addr, e.Número as Numb, e.CEP as Zip, e.Cidade as City, e.UF as Stt, d.id " +
                    "from Pessoa p " +
                    "INNER JOIN Cliente c (on c.Email = p.Documento)" +
                    "INNER JOIN Dependente d(on d.id = p.Documento) " +
                    "INNER JOIN Endereço e (on e.id = p.Documento)");
            //Testando!! Inserindo infos do TextField para o DB.

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public void prev(MouseEvent mouseEvent) throws Exception {
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader1.load();
        Scene home_scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene);
        app_stage.show();
    }

    public void opt1(MouseEvent mouseEvent) {
        cbx_Doc.getItems().addAll("Passaporte", "CPF");
    }

    public void opt2(MouseEvent mouseEvent) {
        cbx_KidDoc.getItems().addAll("Passaporte", "CPF");
    }
}