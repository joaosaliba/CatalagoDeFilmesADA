package catalago;

import catalago.database.DatabaseConnectionSingleton;
import catalago.repository.AtorDB;
import catalago.repository.DiretorDB;
import catalago.repository.FilmeDB;
import catalago.service.AtorService;
import catalago.service.DiretorService;
import catalago.service.FilmeService;
import catalago.service.MenuService;

import java.sql.Connection;
import java.sql.SQLException;

public class CatalogoDeFilmesMain {
    public static void main(String[] args) throws SQLException {
        Connection connection = new DatabaseConnectionSingleton().getConnection();
        MenuService menu = new MenuService(new FilmeService(new FilmeDB(connection)),
                                           new AtorService(new AtorDB(connection)),
                                           new DiretorService(new DiretorDB(connection)));
        menu.menuPrincipal();
    }


}



