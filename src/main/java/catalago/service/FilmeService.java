package catalago.service;

import catalago.database.DatabaseConnectionSingleton;
import catalago.models.Filme;
import catalago.repository.AtorDB;
import catalago.repository.DiretorDB;
import catalago.repository.FilmeDB;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FilmeService {
    private FilmeDB repostiryFilme;

    public FilmeService(FilmeDB repostiryFilme) {
        this.repostiryFilme = repostiryFilme;
    }

    public void cadastrarFilme(Scanner scanner) {
        try {
            System.out.print("Digite o nome do Filme : ");
            String nome = scanner.nextLine();

            System.out.print("Digite a data de lançamento (dd/mm/aaa)  do Filme : ");
            String dataLancamentoStr = scanner.nextLine();
            String[] partesData = dataLancamentoStr.split("/");

            int dia = Integer.parseInt(partesData[0]);
            int mes = Integer.parseInt(partesData[1]);
            int ano = Integer.parseInt(partesData[2]);

            LocalDate dataLancamento = LocalDate.of(ano, mes, dia);

            System.out.print("Digite o orçamento  do Filme : R$");
            BigDecimal oracamento = BigDecimal.valueOf(scanner.nextDouble());
            scanner.nextLine();
            System.out.print("Digite a descrição do Filme : ");
            String descricao = scanner.nextLine();

            Filme filme = new Filme(nome, dataLancamento, oracamento, descricao);

            this.repostiryFilme.insert(filme);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void listarFilmes() {

        try {

            List<Filme> filmes = this.repostiryFilme.getAll();
            for(Filme filme :filmes){
                filme.setDiretores( new DiretorDB(new DatabaseConnectionSingleton().getConnection()).getByFilmeId(filme.getId()));
                filme.setAtores( new AtorDB(new DatabaseConnectionSingleton().getConnection()).getByFilmeId(filme.getId()));
            }
            System.out.println("====================================");
            System.out.println("Filmes cadastrados");
            for (Filme filme : filmes) {
                filme.showInformations();
            }
            System.out.println("====================================");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void buscarFilmesPorNome(Scanner scanner) {

        try {

            System.out.print("Digite o nome do Filme a procurar  : ");
            String nome = scanner.nextLine().trim();

            List<Filme> filmes = this.repostiryFilme.getByName(nome);
            for(Filme filme :filmes){
                filme.setDiretores( new DiretorDB(new DatabaseConnectionSingleton().getConnection()).getByFilmeId(filme.getId()));
                filme.setAtores( new AtorDB(new DatabaseConnectionSingleton().getConnection()).getByFilmeId(filme.getId()));
            }
            System.out.println("====================================");
            System.out.println("Filmes encontrados");
            for (Filme filme : filmes) {
                filme.showInformations();
            }
            System.out.println("====================================");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void buscarFilmePorId(Scanner scanner) {
        try {

            System.out.print("Digite o Id do Filme a procurar  : ");
            Integer ID = Integer.parseInt(scanner.nextLine().trim());

            Filme filme = this.repostiryFilme.getByID(ID);
            filme.setDiretores( new DiretorDB(new DatabaseConnectionSingleton().getConnection()).getByFilmeId(ID));
            filme.setAtores( new AtorDB(new DatabaseConnectionSingleton().getConnection()).getByFilmeId(ID));
            System.out.println("====================================");
            System.out.println("Filmes encontrado");
            filme.showInformations();
            System.out.println("====================================");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void associarFilmeAtores(Scanner scanner) {
        try {


            System.out.print("Digite o Id do Filme a vincular  : ");
            Integer filmeID = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Digite o Id do Atorea vincular  : ");
            Integer atoreID = Integer.parseInt(scanner.nextLine().trim());
            repostiryFilme.associateFilmeAndAtor(filmeID, atoreID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void associarFilmeDiretores(Scanner scanner) {
        try {

            System.out.print("Digite o Id do Filme a vincular  : ");
            Integer filmeID = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Digite o Id do Diretor a vincular  : ");
            Integer diretorID = Integer.parseInt(scanner.nextLine().trim());
            repostiryFilme.associateFilmeAndDiretor(filmeID, diretorID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
