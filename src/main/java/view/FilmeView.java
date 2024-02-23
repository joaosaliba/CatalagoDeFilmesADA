package view;

import catalago.database.DatabaseConnectionSingleton;
import catalago.models.Filme;
import catalago.repository.AtorDB;
import catalago.repository.DiretorDB;
import catalago.service.FilmeService;
import catalago.utils.ScannerSingleton;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FilmeView {
    private FilmeService filmeService;

    public FilmeView(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    public void cadastrarFilme() {
        Scanner scanner = ScannerSingleton.instance().getScanner();

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

            this.filmeService.cadastrarFilme(filme);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }


    }


    public void listarFilmes() {

        try {

            List<Filme> filmes = this.filmeService.listarFilmes();

            System.out.println("====================================");
            System.out.println("Filmes cadastrados");
            for (Filme filme : filmes) {
                filme.showInformations();
            }
            System.out.println("====================================");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }




    public void buscarFilmesPorNome() {
        Scanner scanner = ScannerSingleton.instance().getScanner();


        try {

            System.out.print("Digite o nome do Filme a procurar  : ");
            String nome = scanner.nextLine().trim();

            List<Filme> filmes = this.filmeService.buscarFilmesPorNome(nome);

            System.out.println("====================================");
            System.out.println("Filmes encontrados");
            for (Filme filme : filmes) {
                filme.showInformations();
            }
            System.out.println("====================================");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    public void buscarFilmePorId() {
        Scanner scanner = ScannerSingleton.instance().getScanner();

        try {

            System.out.print("Digite o Id do Filme a procurar  : ");
            Integer ID = Integer.parseInt(scanner.nextLine().trim());

            Filme filme = this.filmeService.buscarFilmePorId(ID);

            System.out.println("====================================");
            System.out.println("Filmes encontrado");
            filme.showInformations();
            System.out.println("====================================");

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void associarFilmeAtores() {
        Scanner scanner = ScannerSingleton.instance().getScanner();

        try {


            System.out.print("Digite o Id do Filme a vincular  : ");
            Integer filmeID = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Digite o Id do Atorea vincular  : ");
            Integer atoreID = Integer.parseInt(scanner.nextLine().trim());
            filmeService.associarFilmeAtores(filmeID, atoreID);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void associarFilmeDiretores() {
        Scanner scanner = ScannerSingleton.instance().getScanner();

        try {

            System.out.print("Digite o Id do Filme a vincular  : ");
            Integer filmeID = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Digite o Id do Diretor a vincular  : ");
            Integer diretorID = Integer.parseInt(scanner.nextLine().trim());
            filmeService.associarFilmeDiretores(filmeID, diretorID);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
