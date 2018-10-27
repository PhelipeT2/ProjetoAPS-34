package Banco;

import java.sql.*;

public class Conexao {
    Connection conn = null;
    boolean hasData = false;
    public void connect(){
        try{
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite::memory";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public ResultSet displayUsers(){
        try {
            if (conn == null) {
                getConnection();
            }
            Statement state = conn.createStatement();
            ResultSet res = state.executeQuery("Select * from user");
            return res;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    private void getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:banco.db");
        //initialise();
        System.out.println("Conexao Configurada!");
    }
}
