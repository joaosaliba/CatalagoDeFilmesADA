package catalago.service;

import catalago.models.Ator;
import catalago.repository.AtorDB;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AtorService {
    private AtorDB repostiryAtor;

    public AtorService(AtorDB repostiryAtor) {
        this.repostiryAtor = repostiryAtor;
    }

    public void cadastrarAtor(Scanner scanner) {
        try {

            System.out.print("Digite o nome do Ator: ");
            String nome = scanner.nextLine();

            System.out.print("Digite a data de nascimento (dd/mm/aaa)  do Ator : ");
            String dataNascimentoStr = scanner.nextLine();
            String[] partesData = dataNascimentoStr.split("/");

            int dia = Integer.parseInt(partesData[0]);
            int mes = Integer.parseInt(partesData[1]);
            int ano = Integer.parseInt(partesData[2]);

            LocalDate dataNascimento = LocalDate.of(ano, mes, dia);


            System.out.print("Digite a nacionalidade do Ator : ");
            String nacionalidade = scanner.nextLine();

            Ator ator = new Ator(nome, dataNascimento, nacionalidade);

            this.repostiryAtor.insert(ator);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void listarAtores() {
        try {


            List<Ator> filmes = this.repostiryAtor.getAll();
            System.out.println("====================================");
            System.out.println("Atores cadastrados");
            for (Ator ator : filmes) {
                ator.showInformations();
            }
            System.out.println("====================================");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void buscarAtoresPorNome(Scanner scanner) {
        try {

            System.out.print("Digite o nome do Ator a procurar  : ");
            String nome = scanner.nextLine().trim();

            List<Ator> filmes = this.repostiryAtor.getByName(nome);
            System.out.println("====================================");
            System.out.println("Atores encontrados");
            for (Ator ator : filmes) {
                ator.showInformations();
            }
            System.out.println("====================================");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void buscarAtorPorId(Scanner scanner) {
        try {

            System.out.print("Digite o Id do Ator a procurar  : ");
            Integer ID = Integer.parseInt(scanner.nextLine().trim());

            Ator ator = this.repostiryAtor.getByID(ID);
            System.out.println("====================================");
            System.out.println("Ators encontrado");
            ator.showInformations();
            System.out.println("====================================");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
