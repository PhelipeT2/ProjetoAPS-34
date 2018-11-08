package sample;

import Banco.Conexao;
import Model.ModelReserva;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Reserva implements Initializable {
    private ModelReserva mReserva;
    Integer qtdDisponivel;
    ObservableList<Node> childrens;
    @FXML
    private Text l_Orig;
    @FXML
    private GridPane GP_lugares;
    @FXML
    private Text l_Dest;

    @FXML
    private Text l_qtdDis;

    double x, y;
    Stage stage = null;

    @FXML
    void dragedMenu(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void close(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void ProxScene(ActionEvent event) {
        try {
            //Conexao conexao = new Conexao();
            List<Integer> listaAssentos = new ArrayList<>();
            int posicao;
//            ResultSet rs = null;
//            Statement statement = null;
//            conexao.connect();
//            statement = conexao.createStatement();
            if (qtdDisponivel == 0) {
                childrens = GP_lugares.getChildren();
                for (Node node : childrens) {
                    if (node.getStyle().equals("-fx-fill: #a11616; -fx-cursor: Hand;")) {
                        posicao = childrens.indexOf(node);
                        listaAssentos.add(posicao);
                        System.out.println(posicao);
                    }
                }

//                childrens = GP_lugares.getChildren();
//                for (Node node : childrens) {
//                    if (node.getStyle().equals("-fx-fill: #a11616; -fx-cursor: Hand;")) {
//                        posicao = childrens.indexOf(node);
//                        System.out.println(posicao);
//                        statement.executeUpdate("insert into assento(id,sequencia,id_voo,num_Assento) values(1,(select MAX(sequencia) from assento where id = '1')+1,1,"+posicao+")");
//                    }
//                }
//                statement.close();
                mReserva.setListaAssentos(listaAssentos);

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
                Parent root = loader.load();
                Login secondController = loader.getController();
                secondController.setmReserva(this.mReserva); // metodo para passar valor.
                Scene home_scene = new Scene(root);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(home_scene);
                app_stage.show();

            } else {
                JOptionPane.showMessageDialog(null, "Quantidade maxima não atiginda.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void chairClick(MouseEvent event) {

        // lugar já reservado.
        if (((Node) event.getSource()).getStyle().equals("-fx-fill: #949191;")) {
            JOptionPane.showMessageDialog(null, "Lugar já Reservado!");
        } else {
            if (((Node) event.getSource()).getStyle().equals("-fx-fill: #a11616; -fx-cursor: Hand;")) {
                ((Node) event.getSource()).setStyle("-fx-fill: #1fe05c; -fx-cursor: Hand;");
                qtdDisponivel++;
            } else {
                if (qtdDisponivel > 0) {
                    ((Node) event.getSource()).setStyle("-fx-fill: #a11616; -fx-cursor: Hand;");
                    qtdDisponivel--;
                } else {
                    JOptionPane.showMessageDialog(null, "A quantidade maxima foi atingida!");
                }
            }
        }
        l_qtdDis.setText(Integer.toString(qtdDisponivel));
    }

    public void setmReserva(ModelReserva value) {
        this.mReserva = value;
        l_Orig.setText(value.getOrigem());
        l_Dest.setText(value.getDestino());
        qtdDisponivel = value.getQtdAdulto() + value.getQtdCrianca();
        l_qtdDis.setText(Integer.toString(qtdDisponivel));
        childrens = GP_lugares.getChildren();
        MaterialIconView miv = null;
        int posicao = 0;
        try {
            if (this.mReserva != null) {
                Conexao conexao = new Conexao();
                ResultSet rs = null;
                Statement statement = null;
                conexao.connect();
                statement = conexao.createStatement();
                rs = statement.executeQuery("select t2.Nome as Origem,t3.Nome as Destino,t4.num_Assento as Assento,t1.DataPartida from voo  t1 inner join Paises  t2 on t1.id_POrigem = t2.id inner join Paises  t3 on t1.id_PDestino = t3.id inner join Assento t4 on t1.id = t4.id_Voo where Origem = \'" + l_Orig.getText() + "\' and Destino = \'" + l_Dest.getText() + "\' and DataPartida = \'" + mReserva.getIda() + "\'");
                while (rs.next()) {
                    miv = (MaterialIconView) childrens.get(rs.getInt("Assento"));
                    miv.setStyle("-fx-fill: #949191;");
//                    for(Node node: childrens){
//                        if(posicao==rs.getInt("Assento")){
//                            System.out.println("s");
//                        }
//                        posicao++;
//                    }
                }
                System.out.println("Teste");
                statement.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleButtonAction(ActionEvent event) throws Exception {

        if (qtdDisponivel == 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();
            Reserva secondController = loader.getController();
            secondController.setmReserva(this.mReserva); // metodo para passar valor.
            Scene home_scene = new Scene(root);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(home_scene);
            app_stage.show();
        }

//        System.out.println("Proxima cena");
//        Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));
//        Scene home_scene = new Scene(parent);
//        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        app_stage.setScene(home_scene);
//        app_stage.show();
    }
}
