package catalago;

import catalago.database.DatabaseConnectionSingleton;
import catalago.repository.AtorDB;
import catalago.repository.DiretorDB;
import catalago.repository.FilmeDB;
import catalago.service.AtorService;
import catalago.service.DiretorService;
import catalago.service.FilmeService;
import view.AtorView;
import view.DiretorView;
import view.FilmeView;
import view.MenuView;

import java.sql.Connection;

public class CatalogoDeFilmesMain {
    public static void main(String[] args)  {
        Connection connection =  DatabaseConnectionSingleton.INSTANCE().getConexao();
        MenuView menu = new MenuView(new FilmeView(new FilmeService(new FilmeDB(connection))),
                                           new AtorView(new AtorService(new AtorDB(connection))),
                                           new DiretorView(new DiretorService( new DiretorDB(connection))));
        menu.menuPrincipal();
    }


}



