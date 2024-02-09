package abstracts;

import java.time.LocalDate;

public abstract class Pessoa {
    private static Integer counter = 1;

    private static Integer getAndIncrementCounter() {
        return counter++;
    }

    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private String nascionalidade;

    public Pessoa() {
    }

    public Pessoa(String nome, LocalDate dataNascimento, String nascionalidade) {
        this.id = getAndIncrementCounter();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nascionalidade = nascionalidade;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNascionalidade() {
        return nascionalidade;
    }

    public void setNascionalidade(String nascionalidade) {
        this.nascionalidade = nascionalidade;
    }
}
