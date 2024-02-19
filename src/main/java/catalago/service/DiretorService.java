package catalago.service;

import catalago.models.Diretor;
import catalago.repository.DiretorDB;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class DiretorService {
    private DiretorDB repostiryDiretor;

    public DiretorService(DiretorDB repostiryDiretor) {
        this.repostiryDiretor = repostiryDiretor;
    }

    public void cadastrarDiretor(Scanner scanner) throws SQLException {
        System.out.print("Digite o nome do Diretor: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a data de nascimento (dd/mm/aaa)  do Diretor : ");
        String dataNascimentoStr = scanner.nextLine();
        String[] partesData = dataNascimentoStr.split("/");

        int dia = Integer.parseInt(partesData[0]);

        int mes = Integer.parseInt(partesData[1]);
        int ano = Integer.parseInt(partesData[2]);

        LocalDate dataNascimento = LocalDate.of(ano, mes, dia);


        System.out.print("Digite a nacionalidade do Diretor : ");
        String nacionalidade = scanner.nextLine();

        Diretor diretor = new Diretor(nome, dataNascimento, nacionalidade);

        this.repostiryDiretor.insert(diretor);

    }


    public void listarDiretores() throws SQLException {


        List<Diretor> filmes = this.repostiryDiretor.getAll();
        System.out.println("====================================");
        System.out.println("Diretores cadastrados");
        for (Diretor diretor : filmes) {
            diretor.showInformations();
        }
        System.out.println("====================================");

    }


    public void buscarDiretoresPorNome(Scanner scanner) throws SQLException {

        System.out.print("Digite o nome do Diretor a procurar  : ");
        String nome = scanner.nextLine().trim();

        List<Diretor> filmes = this.repostiryDiretor.getByName(nome);
        System.out.println("====================================");
        System.out.println("Diretores cadastrados");
        for (Diretor diretor : filmes) {
            diretor.showInformations();
        }
        System.out.println("====================================");

    }
    public void buscarDiretorPorId(Scanner scanner) throws SQLException {

        System.out.print("Digite o Id do Diretor a procurar  : ");
        Integer ID = Integer.parseInt(scanner.nextLine().trim());

        Diretor diretor = this.repostiryDiretor.getByID(ID);
        System.out.println("====================================");
        System.out.println("Diretors encontrado");
        diretor.showInformations();
        System.out.println("====================================");

    }
}
