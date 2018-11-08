package sample;

import Banco.Conexao;
import Model.ModelDependentes;
import Model.ModelPagamento;
import Model.ModelReserva;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static javax.swing.JOptionPane.YES_OPTION;

public class Pagamento implements Initializable {
    private ModelPagamento mPagamento;
    public JFXComboBox <String> cbx_Parc, cbx_Band;
    public JFXTextField NCard, Valid, Tit, Doc;
    public JFXPasswordField pass;

    public void setmReserva(ModelReserva mReserva) {
        this.mReserva = mReserva;
        int i =1;
        int idVoo = 0;
        int idAssentoCliente = 0;
        int idDepedente = 0;
        int idCliente = 0;
        boolean existe = false;
        String docDepe = null;
        List<Integer> assentos = new ArrayList<>();
        Conexao conexao = new Conexao();
        ResultSet rs = null;
        Statement statement = null;
        conexao.connect();
        statement = conexao.createStatement();
        if(mReserva.getDependentes() != null){
            try {
                // A data está indo errado nessa parte.
                //Insert Voo
                rs=statement.executeQuery("select * from voo where id_POrigem = (select id from paises where nome='"+mReserva.getOrigem()+"') and id_PDestino = (select id from paises where nome='"+mReserva.getDestino()+"') and DataPartida= '"+mReserva.getIda()+"'");
                while (rs.next()) {
                    existe = true;
                    idVoo = rs.getInt("id");
                }
                if(!existe){
                    statement.executeUpdate("insert into Voo(id_aviao,id_POrigem,id_PDestino,DataPartida) values('1',(select id from paises where nome='"+mReserva.getOrigem()+"'),(select id from paises where nome='"+mReserva.getDestino()+"'),"+mReserva.getIda()+")");
                    rs=statement.executeQuery("select * from voo where id_POrigem = (select id from paises where nome='"+mReserva.getOrigem()+"') and id_PDestino = (select id from paises where nome='"+mReserva.getDestino()+"') and DataPartida= '"+mReserva.getIda()+"'");
                    while (rs.next()) {
                        idVoo = rs.getInt("id");
                    }
                }
                for(Integer item: mReserva.getListaAssentos()){
                    statement.executeUpdate("insert into Assento(id_Voo,num_Assento) values('"+idVoo+"','"+item+"')");
                    rs = statement.executeQuery("select id from Assento where id_Voo = '"+idVoo+"' and num_Assento = '"+item+"'");
                    while (rs.next()){
                        if(i == 1){
                            idAssentoCliente = rs.getInt("id");
                            i++;
                        }else{
                            assentos.add(rs.getInt("id"));
                        }
                    }
                }
                i = 1;
                int j =0;
                for(ModelDependentes item: mReserva.getDependentes()) {
                    //Insert Depedentes
                    statement.executeUpdate("insert into Depedente(sequencia,id_Assento,RG,Nome,DataNascimento) values('"+i+"','"+assentos.get(j++)+"','"+item.getDepDoc()+"','"+item.getDepName()+"','"+item.getDepAge()+"')");
                    i++;
                    docDepe = item.getDepDoc();
                }
                //select id depedentes
                rs = statement.executeQuery("select id from depedente where RG = '"+docDepe+"'");
                while (rs.next()){
                    idDepedente = rs.getInt("id");
                }

                rs = statement.executeQuery("Select id from Pessoa where CPF = '"+mReserva.getCPF()+"'");
                while (rs.next())
                    idCliente = rs.getInt("id");
                //Insert Carrinho
                if(idDepedente == 0)
                statement.executeUpdate("insert into Carrinho(id_cliente,id_voo,id_depedente,id_assento) values('"+idCliente+"','"+idVoo+"','null','"+idAssentoCliente+"')");
                else{
                    statement.executeUpdate("insert into Carrinho(id_cliente,id_voo,id_depedente,id_assento) values('"+idCliente+"','"+idVoo+"','"+idDepedente+"','"+idAssentoCliente+"')");
                }
                statement.close();
                } catch (Exception e) {
                System.out.println(e.getMessage());
                }

        }else{

        }

    }

    private ModelReserva mReserva;

    Stage stage = null;

    public void setModelPagamento(ModelPagamento value) {
        this.mPagamento = value;
        NCard.setText(value.getNCard());
        Valid.setText(value.getValid());
        Tit.setText(value.getTit());
        Doc.setText(value.getDoc());
        pass.setText(value.getPass());
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

//        try {
//            Conexao conexao = new Conexao();
//            ResultSet rs = null;
//            Statement statement = null;
//            conexao.connect();
//
//            statement = conexao.createStatement();
//            rs = statement.executeQuery("Select Tipo_Parcelamento from Parcelamento");
//            while(rs.next()){
//                cbx_Parc.getItems().add(rs.getString("Tipo_Parcelamento"));
//            }
//            statement = conexao.createStatement();
//            rs = statement.executeQuery("Select Tipo_Bandeira from Bandeira");
//            while(rs.next()){
//                cbx_Band.getItems().add(rs.getString("Tipo_Bandeira"));
//            }
//            statement.close();
//        }catch (Exception e){
//            JOptionPane.showMessageDialog(null,e.getMessage());
//        }
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

    @FXML
    void next(MouseEvent event) throws Exception {
        if(NCard.getText() != null && Valid.getText() != null && Doc.getText() != null && Tit.getText() != null
                && pass.getText() != null && cbx_Parc.getSelectionModel().getSelectedItem() != null
                || cbx_Band.getSelectionModel().getSelectedItem() != null) {
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
}
