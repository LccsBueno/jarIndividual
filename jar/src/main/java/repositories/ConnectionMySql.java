package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySql {

    private static final String URL = "jdbc:mysql://localhost:3306/cineguardian";
    private String user;
    private String password;

    public ConnectionMySql(){
        this.user = "admin";
        this.password = "admin";
    }

    public ConnectionMySql(String user, String password){
        this.user = user;
        this.password = password;
    }

    public Connection open() {
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, this.user, this.password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado");
            e.printStackTrace();
        } catch (SQLException e){
            System.out.println("Erro ao conectar ao banco de dados");
            e.printStackTrace();
        }
        return connection;
    }

    public void close(Connection connection){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão");
                e.printStackTrace();
            }
        }
    }

}
