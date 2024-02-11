package catalago.service;

import catalago.models.Filme;
import catalago.repository.FilmeDB;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FilmeService {
    private FilmeDB repostiryFilme;

    public FilmeService() throws SQLException {
        this.repostiryFilme = new FilmeDB();
    }

    public void cadastrarFilme(Scanner scanner) throws SQLException {
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

    }


    public void listarFilmes() throws SQLException {


        List<Filme> filmes = this.repostiryFilme.getAll();
        System.out.println("====================================");
        System.out.println("Filmes cadastrados");
        for (Filme filme : filmes) {
            filme.showInformations();
        }
        System.out.println("====================================");

    }


    public void buscarFilmesPorNome(Scanner scanner) throws SQLException {

        System.out.print("Digite o nome do Filme a procurar  : ");
        String nome = scanner.nextLine().trim();

        List<Filme> filmes = this.repostiryFilme.getByName(nome);
        System.out.println("====================================");
        System.out.println("Filmes encontrados");
        for (Filme filme : filmes) {
            filme.showInformations();
        }
        System.out.println("====================================");

    }
    public void buscarFilmePorId(Scanner scanner) throws SQLException {

        System.out.print("Digite o Id do Filme a procurar  : ");
        Integer ID = Integer.parseInt(scanner.nextLine().trim());

        Filme filme = this.repostiryFilme.getByID(ID);
        System.out.println("====================================");
        System.out.println("Filmes encontrado");
        filme.showInformations();
        System.out.println("====================================");

    }

    public void associarFilmeAtores(Scanner scanner) throws SQLException {

        System.out.print("Digite o Id do Filme a vincular  : ");
        Integer filmeID = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Digite o Id do Atorea vincular  : ");
        Integer atoreID = Integer.parseInt(scanner.nextLine().trim());
        repostiryFilme.associateFilmeAndAtor(filmeID,atoreID);
    }

    public void associarFilmeDiretores(Scanner scanner) throws SQLException {
        System.out.print("Digite o Id do Filme a vincular  : ");
        Integer filmeID = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Digite o Id do Diretor a vincular  : ");
        Integer diretorID = Integer.parseInt(scanner.nextLine().trim());
        repostiryFilme.associateFilmeAndDiretor(filmeID,diretorID);
    }
}
