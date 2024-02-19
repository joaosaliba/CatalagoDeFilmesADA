package catalago.service;

import catalago.repository.AtorDB;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuService {

    private final FilmeService filmeService;
    private final AtorService atorService;
    private final DiretorService diretorService;

    public MenuService(FilmeService filmeService, AtorService atorService, DiretorService diretorService) {
        this.filmeService = filmeService;
        this.atorService = atorService;
        this.diretorService = diretorService;
    }

    public void menuPrincipal() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("===== Menu Principal =====");
            System.out.println("1. Menu de Filmes");
            System.out.println("2. Menu de Atores");
            System.out.println("3. Menu de Diretores");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após o número

            switch (opcao) {
                case 1->this.menuFilmes(scanner);
                case 2->this.menuAtores(scanner);
                case 3->this.menuDiretores(scanner);
                case 0-> {
                    System.out.println("Saindo do programa. Até logo!");
                    scanner.close();
                }
                default->System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    private void menuFilmes(Scanner scanner) throws SQLException {
        int opcaoFilmes;

        do {
            System.out.println("===== Menu de Filmes =====");
            System.out.println("1. Cadastrar Filme");
            System.out.println("2. Associar Filme com Atores");
            System.out.println("3. Associar Filme com Diretores");
            System.out.println("4. Pesquisar Filme por Nome");
            System.out.println("5. Listar todos Filme ");
            System.out.println("6. Buscar Filme por ID ");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcaoFilmes = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após o número

            switch (opcaoFilmes) {
                case 1->filmeService.cadastrarFilme(scanner);
                case 2->filmeService.associarFilmeAtores(scanner);
                case 3->filmeService.associarFilmeDiretores(scanner);
                case 4->filmeService.buscarFilmesPorNome(scanner);
                case 5->filmeService.listarFilmes();
                case 6->filmeService.buscarFilmePorId(scanner);
                case 0->System.out.println("Voltando ao Menu Principal.");
                default->System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoFilmes != 0);
    }

    private void menuAtores(Scanner scanner) throws SQLException {
        int opcaoAtores;
        do {
            System.out.println("===== Menu de Atores =====");
            System.out.println("1. Inserir Ator");
            System.out.println("2. Listar Atores");
            System.out.println("3. Encontrar Ator por Nome");
            System.out.println("4. Encontrar Ator por ID");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcaoAtores = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após o número

            switch (opcaoAtores) {
                case 1->atorService.cadastrarAtor(scanner);
                case 2->atorService.listarAtores();
                case 3->atorService.buscarAtoresPorNome(scanner);
                case 4->atorService.buscarAtorPorId(scanner);
                case 0->System.out.println("Voltando ao Menu Principal.");
                default->System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoAtores != 0);
    }
    private void menuDiretores(Scanner scanner) throws SQLException {
        int opcaoDiretores;

        do {
            System.out.println("===== Menu de Diretores =====");
            System.out.println("1. Inserir Diretor");
            System.out.println("2. Listar Diretores");
            System.out.println("3. Encontrar Diretor por Nome");
            System.out.println("4. Encontrar Diretor por ID");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcaoDiretores = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após o número

            switch (opcaoDiretores) {
                case 1->diretorService.cadastrarDiretor(scanner);
                case 2->diretorService.listarDiretores();
                case 3->diretorService.buscarDiretoresPorNome(scanner);
                case 4->diretorService.buscarDiretorPorId(scanner);
                case 0->System.out.println("Voltando ao Menu Principal.");
                default->System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoDiretores != 0);
    }
}
