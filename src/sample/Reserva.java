package sample;

import Banco.Conexao;
import Model.ModelReserva;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Reserva implements Initializable {
    private ModelReserva mReserva;
    Integer qtdDisponivel;
    @FXML
    private Text l_Orig;

    @FXML
    private Text l_Dest;

    @FXML
    private Text l_qtdDis;

    double x,y;
    Stage stage = null;
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

    @FXML
    void chairClick(MouseEvent event) {

            // lugar já reservado.
            if (((Node) event.getSource()).getStyle().equals("-fx-fill: #949191;")) {
                JOptionPane.showMessageDialog(null, "Lugar já Reservado!1");
            } else {
                if (((Node) event.getSource()).getStyle().equals("-fx-fill: #a11616; -fx-cursor: Hand;")) {
                    ((Node) event.getSource()).setStyle("-fx-fill: #1fe05c; -fx-cursor: Hand;");
                    qtdDisponivel++;
                } else {
                    if(qtdDisponivel > 0) {
                    ((Node) event.getSource()).setStyle("-fx-fill: #a11616; -fx-cursor: Hand;");
                        qtdDisponivel--;
                    }else{
                        JOptionPane.showMessageDialog(null,"A quantidade maxima foi atingida!");
                    }
                }
        }
        l_qtdDis.setText(Integer.toString(qtdDisponivel));
    }

    public void setmReserva(ModelReserva value){
        this.mReserva = value;
        l_Orig.setText(value.getOrigem());
        l_Dest.setText(value.getDestino());
        qtdDisponivel = value.getQtdAdulto()+ value.getQtdCrianca();
        l_qtdDis.setText(Integer.toString(qtdDisponivel));
        try{
            if(this.mReserva != null){
                Conexao conexao = new Conexao();
                ResultSet rs = null;
                Statement statement = null;
                conexao.connect();
                statement = conexao.createStatement();
                rs = statement.executeQuery("select t2.Nome as Origem,t3.Nome as Destino,t4.num_Assento as Assento,t1.DataPartida from voo  t1 inner join Paises  t2 on t1.id_POrigem = t2.id inner join Paises  t3 on t1.id_PDestino = t3.id inner join Assento t4 on t1.id = t4.id_Voo where Origem = \'"+l_Orig.getText()+"\' and Destino = \'"+l_Dest.getText()+"\' and DataPartida = \'"+mReserva.getIda()+"\'");
                while(rs.next()){
                    //implementar logica para deixar os assentos cinzas.
                }
                System.out.println("Teste");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void handleButtonAction(ActionEvent event) throws Exception {
        System.out.println("Proxima cena");
        Parent parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene home_scene = new Scene(parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene);
        app_stage.show();
    }
}
