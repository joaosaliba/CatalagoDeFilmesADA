package catalago;

import catalago.database.DatabaseConnection;
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
        Connection connection =  new DatabaseConnection().getConexao();
        AtorDB atorDB = new AtorDB(connection);
        DiretorDB diretorDB = new DiretorDB(connection);
        MenuView menu = new MenuView(new FilmeView(new FilmeService(new FilmeDB(connection),diretorDB,atorDB)),
                                           new AtorView(new AtorService(atorDB)),
                                           new DiretorView(new DiretorService( diretorDB)));
        menu.menuPrincipal();
    }


}



