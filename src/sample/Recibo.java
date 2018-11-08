package sample;

import Banco.Conexao;
import Model.ModelRecibo;
import Model.ModelReserva;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Recibo implements Initializable{
    private ModelRecibo mRecibo;
    public Label l_Name, l_Doc, l_Email, l_Age, l_Tel,l_qtdAdulto, l_qtdCrianca, l_SomaQtd, l_SomaValor, l_bandeira, l_Parc, l_Origem, l_Destino, l_ida, l_posição;
    Integer qtdDisponivel;

    Stage stage = null;

    public void setmRecibo(ModelRecibo value) {
        this.mRecibo = value;
        l_Name.setText(value.getName());
        l_Doc.setText(value.getDoc());
        l_Email.setText(value.getEmail());
        l_Age.setText(value.getAge());
        l_Tel.setText(value.getTel());
        l_qtdAdulto.setText(value.getQtdAdulto());
        l_qtdCrianca.setText(value.getQtdCrianca());
        l_SomaQtd.setText(value.getSomaQtd());
        l_SomaValor.setText(value.getSomaValor());
        l_bandeira.setText(value.getBandeira());
        l_Parc.setText(value.getParc());
        l_Origem.setText(value.getOrigem());
        l_Destino.setText(value.getDestino());
        l_ida.setText(value.getIda());
        l_posição.setText(value.getPosicao());

        try {
            if (this.mRecibo != null) {
                Conexao conexao = new Conexao();
                ResultSet rs = null;
                Statement statement = null;
                conexao.connect();
                statement = conexao.createStatement();
                rs = statement.executeQuery("select Pes.Nome from Pessoa where Nome = \'" + l_Name.getText() + "\'"); // Para testar se o nome aparece na tela recibo. NÃO FUNCIONA

                System.out.println("Teste");
                statement.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
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
