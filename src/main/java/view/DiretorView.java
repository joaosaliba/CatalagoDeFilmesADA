package view;

import catalago.abstracts.Pessoa;
import catalago.enums.TipoPessoaEnum;
import catalago.models.Diretor;
import catalago.service.DiretorService;
import catalago.utils.ScannerSingleton;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class DiretorView {
    private DiretorService service;

    public DiretorView() {
    }

    public DiretorView(DiretorService service) {
        this.service = service;
    }

        public void cadastrarDiretor(TipoPessoaEnum tipoPessoaEnum) {
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

            Diretor diretor = (Diretor) new Pessoa.PessoaBuilder().tipoPessoa(tipoPessoaEnum).nome(nome).dataNascimento(dataNascimento).nacionalidade(nacionalidade).build();

            this.service.cadastrarDiretor(diretor);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    public void listarDiretores() {
        List<Diretor> diretores = service.listarDiretores();
        System.out.println("====================================");
        System.out.println("Diretores cadastrados");
        for (Pessoa diretor : diretores) {
            this.showInformations(diretor);
        }
        System.out.println("====================================");
    }

    public void buscarDiretoresPorNome() {
        Scanner scanner = ScannerSingleton.instance().getScanner();

        System.out.print("Digite o nome do Diretor a procurar  : ");
        String nome = scanner.nextLine().trim();
        List<Diretor> diretores = service.buscarDiretoresPorNome(nome);

        System.out.println("====================================");
        System.out.println("Diretores encontrados");
        for (Diretor diretor : diretores) {
            this.showInformations(diretor);
        }
        System.out.println("====================================");
    }

    public void buscarDiretorPorId() {
        Scanner scanner = ScannerSingleton.instance().getScanner();

        System.out.print("Digite o Id do Diretor a procurar  : ");
        Integer ID = Integer.parseInt(scanner.nextLine().trim());
        Pessoa diretor = service.buscarDiretorPorId(ID);
        System.out.println("====================================");
        System.out.println("Diretors encontrado");
        this.showInformations(diretor);
        System.out.println("====================================");
    }
    public  void showInformations(Pessoa pessoa){
        System.out.println("ID: " + pessoa.getId());
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Data Nascimento: " + pessoa.getDataNascimentoFormatada());
        System.out.println("Nascionalidade: " + pessoa.getNacionalidade());
        System.out.print("\n");
    }
}
