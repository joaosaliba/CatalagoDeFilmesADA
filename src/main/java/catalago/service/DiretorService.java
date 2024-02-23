package catalago.service;

import catalago.models.Diretor;
import catalago.repository.DiretorDB;
import catalago.utils.ScannerSingleton;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class DiretorService {
    private DiretorDB repostiryDiretor;

    public DiretorService(DiretorDB repostiryDiretor) {
        this.repostiryDiretor = repostiryDiretor;
    }

    public void cadastrarDiretor(Diretor diretor) {
       Scanner scanner = ScannerSingleton.instance().getScanner();

        try {



            this.repostiryDiretor.insert(diretor);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public List<Diretor> listarDiretores() {
        try {


           return this.repostiryDiretor.getAll();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public List<Diretor> buscarDiretoresPorNome(String nome) {
       Scanner scanner = ScannerSingleton.instance().getScanner();

        try {



            return this.repostiryDiretor.getByName(nome);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Diretor buscarDiretorPorId(Integer ID) {
       Scanner scanner = ScannerSingleton.instance().getScanner();

        try {



            return this.repostiryDiretor.getByID(ID);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
