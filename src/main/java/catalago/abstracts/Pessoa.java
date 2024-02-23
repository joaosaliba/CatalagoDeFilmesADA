package catalago.abstracts;


import catalago.enums.TipoPessoaEnum;
import catalago.factory.PessoaFactory;

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



    @Override
    public String toString() {
        return  tipoPessoaEnum.name() +
                " id=" + id +"\n" +
                " nome='" + nome +"\n" +
                " dataNascimento=" + dataNascimento +"\n" +
                " nacionalidade='" + nacionalidade +"\n" +
               "\n"   ;
    }
    public static class PessoaBuilder {
        private String nome;
        private LocalDate dataNascimento;
        private String nacionalidade;
        private TipoPessoaEnum tipoPessoaEnum;
        public Pessoa build() {
            Pessoa pessoa =  PessoaFactory.getInstance(tipoPessoaEnum);

            pessoa.setNome(nome);
            pessoa.setDataNascimento(dataNascimento);
            pessoa.setNacionalidade(nacionalidade);

            return pessoa;
        }

        public PessoaBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public PessoaBuilder dataNascimento(LocalDate dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public PessoaBuilder nacionalidade(String nacionalidade) {
            this.nacionalidade = nacionalidade;
            return this;
        }

        public PessoaBuilder tipoPessoa(TipoPessoaEnum tipoPessoaEnum) {
            this.tipoPessoaEnum = tipoPessoaEnum;
            return this;
        }


    }

}
