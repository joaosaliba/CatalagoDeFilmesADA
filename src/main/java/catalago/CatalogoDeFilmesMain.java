package catalago;

import catalago.service.AtorService;
import catalago.service.DiretorService;
import catalago.service.FilmeService;
import catalago.service.MenuService;

import java.sql.SQLException;
import java.util.Scanner;

public class CatalogoDeFilmesMain {
    public static void main(String[] args) throws SQLException {
        MenuService menu = new MenuService();
        menu.menuPrincipal();
    }


}



