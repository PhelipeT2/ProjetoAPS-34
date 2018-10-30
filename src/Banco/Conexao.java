package Banco;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    Connection conexao = null;
    public void connect(){
        try{
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:banco.db";
            conexao = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    public void disconnect(){
        try{
            if(this.conexao.isClosed() == false){
                this.conexao.close();
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    private void getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:banco.db");
        //initialise();
        System.out.println("Conexao Configurada!");
    }
    public Statement createStatement(){
        try{
            return this.conexao.createStatement();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        }
    }
    public Connection getConexao(){
        return this.conexao;
    }
}
