package catalago.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class DatabaseConnectionSingleton {
    private static Connection conexao = null;
    private final String url = "jdbc:postgresql://localhost:5432/catalagoFilme?currentSchema=catalago";
    private final String user = "catalagoFilmeADA";
    private final String pass = "catalagoFilmeADA";

   static  {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                closeConnection();
            }
        });
    }
   private static final DatabaseConnectionSingleton INSTANCE = new DatabaseConnectionSingleton();
    private DatabaseConnectionSingleton() {
        conexao = makeConnection();
    }

    private Connection makeConnection()  {

        try {
            Class.forName("org.postgresql.Driver");

            conexao = DriverManager.getConnection(url, user, pass);
            conexao.setAutoCommit(false);
            System.out.println("Conexão aberta.");


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return conexao;
    }

    public static void closeConnection() {
        try {
            if (Objects.nonNull(conexao) && !conexao.isClosed()) {
                conexao.close();
                System.out.println("Conexão fechada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static DatabaseConnectionSingleton INSTANCE() {
        return INSTANCE;
    }

    public  Connection getConexao() {
        return conexao;
    }
}
