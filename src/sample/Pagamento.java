package sample;

import Banco.Conexao;
import Model.ModelPagamento;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
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
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import static javax.swing.JOptionPane.YES_OPTION;

public class Pagamento implements Initializable {
    private ModelPagamento mPagamento;
    public JFXComboBox <String> cbx_Parc, cbx_ParcDeb;
    public JFXTextField NCard, Valid, Tit, Doc;
    public JFXPasswordField pass;
    public JFXRadioButton visa, master, deb, cred;

    Stage stage = null;

    public void setModelPagamento(ModelPagamento value) {
        this.mPagamento = value;
        NCard.setText(value.getNCard());
        Valid.setText(value.getValid());
        Tit.setText(value.getTit());
        Doc.setText(value.getDoc());
        pass.setText(value.getpass());
    }

    @FXML
    void close(MouseEvent event) {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage("Campo Necessário!");

        NCard.getValidators().add(validator);
        NCard.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                NCard.validate();
        });
        Valid.getValidators().add(validator);
        Valid.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                Valid.validate();
        });
        Doc.getValidators().add(validator);
        Doc.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                Doc.validate();
        });
        Tit.getValidators().add(validator);
        Tit.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                Tit.validate();
        });
        pass.getValidators().add(validator);
        pass.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue)
                pass.validate();
        });

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

    public void prev(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("cadastro.fxml"));
        Parent root = loader1.load();
        Scene home_scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene);
        app_stage.show();
    }

    public void min(MouseEvent event) {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    public void optParc(MouseEvent mouseEvent) { cbx_Parc.getItems().addAll("1x", "2x", "3x"); }

    @FXML
    void next(MouseEvent event) throws Exception {
        if(NCard.getText() != null && Valid.getText() != null && Doc.getText() != null && Tit.getText() != null
                && pass.getText() != null && cbx_Parc.getSelectionModel().getSelectedItem() != null
                || cbx_ParcDeb.getSelectionModel().getSelectedItem() != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Recibo.fxml"));
            Parent root = loader.load();
            Scene home_scene = new Scene(root);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(home_scene);
            app_stage.show();
            }else{
            System.out.println("Preencha os campos!");
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
            NCard.clear();
            Valid.clear();
            Doc.clear();
            Tit.clear();
            pass.clear();
        }else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Pagamento.fxml"));
        }
    }

    public void optParcDeb(MouseEvent mouseEvent) { cbx_ParcDeb.getItems().addAll("À vista"); }
}
