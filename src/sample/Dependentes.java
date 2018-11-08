package sample;

import Banco.Conexao;
import Model.ModelDependentes;
import Model.ModelReserva;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static javax.swing.JOptionPane.YES_OPTION;

public class Dependentes implements Initializable {
    private ModelDependentes mDependentes;
    @FXML
    private GridPane GridPane,GP2;
    @FXML
    private ScrollPane contentScrollPane;
    public JFXTextField DepName, DepDoc, DepAge;
    public JFXTextField DepName2, DepDoc2, DepAge2;
    private Stage stage = null;

    public void setmReserva(ModelReserva mReserva) {
        this.mReserva = mReserva;
        try{
            ObservableList<Node> childrens = GridPane.getChildren();
            //GridPane.setGridLinesVisible(true);
            int quantidade;
            int j = 0;
            ScrollPane sp = new ScrollPane(GridPane);
            sp.setFitToWidth(true);
            GP2.add(sp,0,1);
            javafx.scene.layout.GridPane.setVgrow(sp,Priority.ALWAYS);
            quantidade = this.mReserva.getQtdAdulto()+this.mReserva.getQtdCrianca();
            for(int i =0;i<quantidade-1;i++ ){

                GridPane.addRow(j,new Label("Nome Completo"),new JFXTextField());
                GridPane.getRowConstraints().add(j++, new RowConstraints(30,50,50));

                GridPane.addRow(j,new Label("Documento"),new JFXTextField());
                GridPane.getRowConstraints().add(j++, new RowConstraints(30,50,50));

                GridPane.addRow(j,new Label("Data Nascimento"),new JFXTextField());
                GridPane.getRowConstraints().add(j++, new RowConstraints(30,50,50));
            }
//        Label nomeCompleto = new Label("Nome Completa");
//        nomeCompleto.setStyle("-fx-text-fill: grey");
//        Label documento = new Label("Documento");
//        Label dataNascimento = new Label("Data Nascimento");
//        JFXTextField txt_nomeC = new JFXTextField();
//        txt_nomeC.setStyle("-jfx-focus-color: WHITE; -jfx-unfocus-color: WHITE; -fx-padding: 0px 5px 0px 5px; -fx-text-inner-color: #C0C0C0");
//        JFXTextField txt_doc = new JFXTextField();
//        txt_doc.setStyle("-jfx-focus-color: WHITE; -jfx-unfocus-color: WHITE; -fx-padding: 0px 5px 0px 5px; -fx-text-inner-color: #C0C0C0");
//        JFXTextField txt_dataN = new JFXTextField();
//        txt_dataN.setStyle("-jfx-focus-color: WHITE; -jfx-unfocus-color: WHITE; -fx-padding: 0px 5px 0px 5px; -fx-text-inner-color: #C0C0C0");
//            GridPane.add(nomeCompleto, 0 , 0);
//            GridPane.add(txt_nomeC, 1 , 0);
//            GridPane.add(documento, 0,1);
//            GridPane.add(txt_doc,  1,1);
//            GridPane.add(dataNascimento, 0 , 2);
//            GridPane.add(txt_dataN, 1, 2);
//            GridPane.addRow(3,new Label("Proximo Depedente"),new Label("Proximo Depedente"));
//
//            GridPane.addRow(4,new Label("Proximo Depedente"),new Label("Proximo Depedente"));
//            GridPane.addRow(5,new Label("Proximo Depedente"),new Label("Proximo Depedente"));
//            GridPane.addRow(6,new Label("Proximo Depedente"),new Label("Proximo Depedente"));
//            GridPane.addRow(7,new Label("Proximo Depedente"),new Label("Proximo Depedente"));
//            GridPane.addRow(8,new Label("Proximo Depedente"),new Label("Proximo Depedente"));
//            GridPane.addRow(9,new Label("Proximo Depedente"),new Label("Proximo Depedente"));
//            GridPane.addRow(10,new Label("Proximo Depedente"),new Label("Proximo Depedente"));
//            GridPane.addRow(11,new Label("Proximo Depedente"),new Label("Proximo Depedente"));
//            GridPane.addRow(12,new Label("Proximo Depedente"),new Label("Proximo Depedente"));
//            GridPane.addRow(13,new Label("Proximo Depedente"),new Label("Proximo Depedente"));
//            GridPane.addRow(14,new Label("Proximo Depedente"),new Label("Proximo Depedente"));
//        GridPane.getRowConstraints().add(3, new RowConstraints(30,50,50));
//        GridPane.getRowConstraints().add(4, new RowConstraints(30,50,50));
//        GridPane.getRowConstraints().add(5, new RowConstraints(30,50,50));
//        GridPane.getRowConstraints().add(6, new RowConstraints(30,50,50));
//        GridPane.getRowConstraints().add(7, new RowConstraints(30,50,50));
//        GridPane.getRowConstraints().add(8, new RowConstraints(30,50,50));
//        GridPane.getRowConstraints().add(9, new RowConstraints(30,50,50));
//        GridPane.getRowConstraints().add(10, new RowConstraints(30,50,50));
//        GridPane.getRowConstraints().add(11, new RowConstraints(30,50,50));
//        GridPane.getRowConstraints().add(12, new RowConstraints(30,50,50));

            for(Node node: childrens){
                System.out.println(node.getTypeSelector());
                if(node.getTypeSelector().equals("Label")){
                    node.setStyle("-fx-font-size: 13pt; -fx-text-fill: WHITE");
                }else if(node.getTypeSelector().equals("JFXTextField")){
                    node.setStyle("-jfx-focus-color: WHITE; -jfx-unfocus-color: WHITE; -fx-padding: 0px 5px 0px 5px; -fx-text-inner-color: #C0C0C0");
                }
            }



        }catch (Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    private ModelReserva mReserva;

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
    public void next(MouseEvent event) {
        try {
            // precisa adicionar checagem dos componentes para verificar se estão vazios
            List<ModelDependentes> lmd = new ArrayList<>();
            ObservableList<Node> childrens = GridPane.getChildren();
            int i=0;
            String nomeCompleto = null,documento = null ,DataNascimento= null;
            for(Node node: childrens) {
               if(node.getTypeSelector().equals("JFXTextField")){
                    if(i==0){
                        nomeCompleto = ((JFXTextField)node).getText();
                        i++;
                    }else if(i==1){
                        documento = ((JFXTextField)node).getText();
                        i++;
                    }else if(i==2){
                        DataNascimento = ((JFXTextField)node).getText();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        lmd.add(new ModelDependentes(nomeCompleto,LocalDate.parse(DataNascimento,formatter),documento));
                        i=0;
                    }
                }
            }
            if(mReserva!= null){
                mReserva.setDependentes(lmd);
                System.out.println("Add lista de depedentes");
            }else{
                throw new Exception("Reserva vazia!");
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Pagamento.fxml"));
            Parent root = loader.load();
            Pagamento secondController = loader.getController();
            secondController.setmReserva(this.mReserva); // metodo para passar valor.
            Scene home_scene = new Scene(root);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(home_scene);
            app_stage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage());
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
