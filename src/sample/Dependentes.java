package sample;

import Banco.Conexao;
import Model.ModelDependentes;
import Model.ModelReserva;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import static javax.swing.JOptionPane.YES_OPTION;

public class Dependentes implements Initializable {
    private ModelDependentes mDependentes;

    public JFXTextField DepName, DepDoc, DepAge;
    public JFXTextField DepName2, DepDoc2, DepAge2;

    private Stage stage = null;

    public void close(MouseEvent event) {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void min(MouseEvent event) {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    //Limpar dados Tela Dependentes
    public void clear(MouseEvent event) {
        int opcao = JOptionPane.showConfirmDialog(null,
                "Deseja realmente limpar os dados ?",
                "Limpar Dados",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(opcao == YES_OPTION) {
            DepName.clear();
            DepDoc.clear();
            DepAge.clear();
        }else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dependentes.fxml"));
        }
    }
    //Limpar dados Tela Dependentes

    //Limpar dados Tela Dependentes 2
    public void clearDep2(MouseEvent event) {
        int opcao = JOptionPane.showConfirmDialog(null,
                "Deseja realmente limpar os dados ?",
                "Limpar Dados",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(opcao == YES_OPTION) {
            DepName.clear();
            DepDoc.clear();
            DepAge.clear();

            DepName2.clear();
            DepDoc2.clear();
            DepAge2.clear();
        }else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dependentes2.fxml"));
        }
    }
    //Limpar dados Tela Dependentes 2

    //Proxima tela de Dependentes
    public void next(MouseEvent event) throws IOException {
        if(DepName.getText() != null && DepDoc.getText() != null && DepAge.getText() != null) {
            try {
                Conexao conexao = new Conexao();
                ResultSet rs = null;
                Statement statement = null;
                conexao.connect();
                statement = conexao.createStatement();
                //statement.executeUpdate("insert into Dependentes(id, sequencia, id_Assento, Nome, Documento, Data_Nasc) " +
                //        "values id = 1 \' select (MAX(sequencia) from assento where id = '1')) \' id_Assento = 1 \'Nome = \'"+DepName.getText()+"\' and Documento = \'"+DepDoc.getText()+"\' " +
                //        "and Data_Nasc = \'"+DepAge.getText()+" \'");

            }catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
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
    //Proxima tela de Dependentes

    //Proxima tela de Dependentes 2
    public void nextDep2(MouseEvent event) throws IOException {
        if(DepName.getText() != null && DepDoc.getText() != null && DepAge.getText() != null
        && DepName2.getText() != null && DepDoc2.getText() != null && DepAge2.getText() != null) {
            try {
                Conexao conexao = new Conexao();
                ResultSet rs = null;
                Statement statement = null;
                conexao.connect();
                statement = conexao.createStatement();
                //statement.executeUpdate("insert into Dependentes(id, sequencia, id_Assento, Nome, Documento, Data_Nasc) " +
                //        "values id = 1 \' select (MAX(sequencia) from assento where id = '1')) \' id_Assento = 1 \'Nome = \'"+Name.getText()+"\' and Data_Nascimento = \'"+Age.getText()+"\' " +
                //        "and Documento = \'"+Doc.getText()+"\' and Telefone = \'"+Tel.getText()+" \'");

                statement = conexao.createStatement();
                //statement.executeUpdate("insert into Dependentes(id, sequencia, id_Assento, Nome, Documento, Data_Nasc) " +
                //        "values id = 1 \' select (MAX(sequencia) from assento where id = '1')) \' id_Assento = 1 \'Nome = \'"+DepName2.getText()+"\' and Documento = \'"+DepDoc2.getText()+"\' " +
                //        "and Data_Nasc = \'"+DepAge2.getText()+" \'");

            }catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
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
    //Proxima tela de Dependentes 2

    public void prev(MouseEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("cadastro.fxml"));
        Parent root = loader1.load();
        Scene home_scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene);
        app_stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
