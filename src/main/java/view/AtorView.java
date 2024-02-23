package view;

import catalago.abstracts.Pessoa;
import catalago.enums.TipoPessoaEnum;
import catalago.models.Ator;
import catalago.service.AtorService;
import catalago.utils.ScannerSingleton;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AtorView {
    private AtorService service;

    public AtorView(AtorService service) {
        this.service = service;
    }

        public void cadastrarAtor(TipoPessoaEnum tipoPessoaEnum) {
        Scanner scanner = ScannerSingleton.instance().getScanner();

        try {

            System.out.printf("Digite o nome do %s: ",tipoPessoaEnum.name());
            String nome = scanner.nextLine();

            System.out.printf("Digite a data de nascimento (dd/mm/aaa)  do  %s: ",tipoPessoaEnum.name());
            String dataNascimentoStr = scanner.nextLine();
            String[] partesData = dataNascimentoStr.split("/");

            int dia = Integer.parseInt(partesData[0]);
            int mes = Integer.parseInt(partesData[1]);
            int ano = Integer.parseInt(partesData[2]);

            LocalDate dataNascimento = LocalDate.of(ano, mes, dia);


            System.out.printf("Digite a nacionalidade do  %s: ",tipoPessoaEnum.name());
            String nacionalidade = scanner.nextLine();

            Ator ator = (Ator) new Pessoa.PessoaBuilder().tipoPessoa(tipoPessoaEnum).nome(nome).dataNascimento(dataNascimento).nacionalidade(nacionalidade).build();

            this.service.cadastrarAtor(ator);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    public void listarAtores() {
        List<Ator> atores = service.listarAtores();
        System.out.println("====================================");
        System.out.println("Atores cadastrados");
        for (Pessoa ator : atores) {
            ator.showInformations();
        }
        System.out.println("====================================");
    }

    public void buscarAtoresPorNome() {
        Scanner scanner = ScannerSingleton.instance().getScanner();

        System.out.print("Digite o nome do Ator a procurar  : ");
        String nome = scanner.nextLine().trim();
        List<Ator> atores = service.buscarAtoresPorNome(nome);

        System.out.println("====================================");
        System.out.println("Atores encontrados");
        for (Ator ator : atores) {
            ator.showInformations();
        }
        System.out.println("====================================");
    }

    public void buscarAtorPorId() {
        Scanner scanner = ScannerSingleton.instance().getScanner();

        System.out.print("Digite o Id do Ator a procurar  : ");
        Integer ID = Integer.parseInt(scanner.nextLine().trim());
        Pessoa ator = service.buscarAtorPorId(ID);
        System.out.println("====================================");
        System.out.println("Ators encontrado");
        ator.showInformations();
        System.out.println("====================================");
    }
}
