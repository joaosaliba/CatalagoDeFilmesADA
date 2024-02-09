package catalago.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class DatabaseConnection {
    public static Connection conexao = null;

    public static Connection getConnection() {
        if (Objects.isNull(conexao)) {

            try {
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://localhost:5432/catalagoFilme?currentSchema=catalago";
                String user = "catalagoFilmeADA";
                String pass = "catalagoFilmeADA";
                conexao = DriverManager.getConnection(url, user, pass);

                System.out.println("Conexão bem-sucedida!");

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        return conexao;
    }

}
