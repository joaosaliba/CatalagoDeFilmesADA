package catalago.service;

import catalago.models.Ator;
import catalago.repository.AtorDB;
import catalago.utils.ScannerSingleton;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AtorService {
    private AtorDB repostiryAtor;

    public AtorService(AtorDB repostiryAtor) {
        this.repostiryAtor = repostiryAtor;
    }

    public void cadastrarAtor(Ator ator) {
       Scanner scanner = ScannerSingleton.instance().getScanner();

        try {
            //TODO Fazer validções

            this.repostiryAtor.insert(ator);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public List<Ator> listarAtores() {
        try {
            //TODO Fazer validções

            return this.repostiryAtor.getAll();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Ator> buscarAtoresPorNome(String nome) {
       Scanner scanner = ScannerSingleton.instance().getScanner();

        try {

            //TODO Fazer validções


            return this.repostiryAtor.getByName(nome);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Ator buscarAtorPorId(Integer id) {

        try {
            //TODO Fazer validções

         return this.repostiryAtor.getByID(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
