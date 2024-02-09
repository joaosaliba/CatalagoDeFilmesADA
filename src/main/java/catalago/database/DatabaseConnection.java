package catalago.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class DatabaseConnection {
    public static Connection conexao = null;
    private final static String url = "jdbc:postgresql://localhost:5432/catalagoFilme?currentSchema=catalago";
    private final static String user = "catalagoFilmeADA";
    private final static String pass = "catalagoFilmeADA";

    public static Connection getConnection() throws SQLException {
        if (Objects.isNull(conexao) || conexao.isClosed()) {

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
        }

        return conexao;
    }


}
