package catalago.service;

import catalago.database.DatabaseConnectionSingleton;
import catalago.models.Filme;
import catalago.repository.AtorDB;
import catalago.repository.DiretorDB;
import catalago.repository.FilmeDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class FilmeService {
    private FilmeDB repostiryFilme;

    public FilmeService(FilmeDB repostiryFilme) {
        this.repostiryFilme = repostiryFilme;
    }

    private static Connection getConnection() {
        return new DatabaseConnectionSingleton().getConnection();
    }

    public void cadastrarFilme(Filme filme) {

        try {
            this.repostiryFilme.insert(filme);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public List<Filme> listarFilmes() {

        try {
            List<Filme> filmes = this.repostiryFilme.getAll();
            for (Filme filme : filmes) {
                filme.setDiretores(new DiretorDB(getConnection()).getByFilmeId(filme.getId()));
                filme.setAtores(new AtorDB(getConnection()).getByFilmeId(filme.getId()));
            }

            return filmes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public List<Filme> buscarFilmesPorNome(String nome) {
        try {
            List<Filme> filmes = this.repostiryFilme.getByName(nome);

            for (Filme filme : filmes) {
                filme.setDiretores(new DiretorDB(getConnection()).getByFilmeId(filme.getId()));
                filme.setAtores(new AtorDB(getConnection()).getByFilmeId(filme.getId()));
            }
            return filmes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Filme buscarFilmePorId(Integer ID) {

        try {
            Filme filme = this.repostiryFilme.getByID(ID);
            filme.setDiretores(new DiretorDB(getConnection()).getByFilmeId(ID));
            filme.setAtores(new AtorDB(getConnection()).getByFilmeId(ID));

            return filme;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void associarFilmeAtores(Integer filmeID, Integer atoreID) {
        try {
            repostiryFilme.associateFilmeAndAtor(filmeID, atoreID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void associarFilmeDiretores(Integer filmeID, Integer diretorID) {

        try {
            repostiryFilme.associateFilmeAndDiretor(filmeID, diretorID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
