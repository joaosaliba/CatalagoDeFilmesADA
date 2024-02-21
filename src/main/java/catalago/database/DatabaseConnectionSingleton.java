package catalago.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class DatabaseConnectionSingleton {
    private Connection conexao = null;
    private final String url = "jdbc:postgresql://localhost:5432/catalagoFilme?currentSchema=catalago";
    private final String user = "catalagoFilmeADA";
    private final String pass = "catalagoFilmeADA";

    public Connection getConnection()  {

        try {
            Class.forName("org.postgresql.Driver");
            if (Objects.nonNull(conexao) && !conexao.isClosed()) {
                conexao.close();
            }
            conexao = DriverManager.getConnection(url, user, pass);
            conexao.setAutoCommit(false);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return conexao;
    }

    public void closeConnection() {
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
}
