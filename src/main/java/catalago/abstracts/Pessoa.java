package catalago.abstracts;


import catalago.enums.TipoPessoaEnum;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa {
    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private String nacionalidade;

    private TipoPessoaEnum tipoPessoaEnum;

    public Pessoa() {
    }


    public Pessoa(String nome, LocalDate dataNascimento, String nacionalidade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;

    }
    public Pessoa(Integer id,String nome, LocalDate dataNascimento, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;

    }


    public Integer getId() {
        return id;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public String getDataNascimentoFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return getDataNascimento().format(formatter);
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    protected TipoPessoaEnum getTipoPessoaEnum() {
        return tipoPessoaEnum;
    }

    protected void setTipoPessoaEnum(TipoPessoaEnum tipoPessoaEnum) {
        this.tipoPessoaEnum = tipoPessoaEnum;
    }

    public void showInformations(){
        System.out.println(this.getTipoPessoaEnum().name());
        System.out.println("ID: " + this.getId());
        System.out.println("Nome: " + this.getNome());
        System.out.println("Data Nascimento: " + this.getDataNascimentoFormatada());
        System.out.println("Nascionalidade: " + this.getNacionalidade());
        System.out.print("\n");
    }

    @Override
    public String toString() {
        return  tipoPessoaEnum.name() +
                " id=" + id +"\n" +
                " nome='" + nome +"\n" +
                " dataNascimento=" + dataNascimento +"\n" +
                " nacionalidade='" + nacionalidade +"\n" +
               "\n"   ;
    }
}
