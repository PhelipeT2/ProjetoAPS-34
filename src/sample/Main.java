package sample;

import Banco.Conexao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.ResultSet;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Conexao conexao = new Conexao();
        ResultSet rs;

        rs = conexao.displayUsers();

        Parent root = FXMLLoader.load(getClass().getResource("Ordenar.fxml"));
        primaryStage.setTitle("Indians Airlines");
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        //primaryStage.setResizable(false);
        primaryStage.show();

    }
    //
    public static void main(String[] args) {
        launch(args);
    }
}
