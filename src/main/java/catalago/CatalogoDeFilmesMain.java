package catalago;

import catalago.service.MenuService;

import java.sql.SQLException;

public class CatalogoDeFilmesMain {
    public static void main(String[] args) throws SQLException {
        MenuService menu = new MenuService();
        menu.menuPrincipal();
    }


}



