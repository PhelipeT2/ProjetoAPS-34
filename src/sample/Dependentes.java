package sample;

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
import java.util.ResourceBundle;
import static javax.swing.JOptionPane.YES_OPTION;

public class Dependentes implements Initializable {
    private ModelDependentes mDependentes;
    public Label l_qtdReservas;
    Integer qtdReservas;
    public JFXTextField DepName, DepSName, DepDoc, DepAge;

    private Stage stage = null;

    public void close(MouseEvent event) {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void min(MouseEvent event) {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    public void clear(MouseEvent event) {
        int opcao = JOptionPane.showConfirmDialog(null,
                "Deseja realmente limpar os dados ?",
                "Limpar Dados",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(opcao == YES_OPTION) {
            DepName.clear();
            DepSName.clear();
            DepDoc.clear();
            DepAge.clear();
        }else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dependentes.fxml"));
        }
    }

    public void next(MouseEvent event) throws IOException {
        if(DepName.getText() != null && DepSName.getText() != null && DepDoc.getText() != null && DepAge.getText() != null) {
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
