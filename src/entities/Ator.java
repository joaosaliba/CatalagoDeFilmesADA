package entities;

import abstracts.Pessoa;

import java.time.LocalDate;

public class Ator extends Pessoa {
    public Ator() {
    }

    public Ator(String nome, LocalDate dataNascimento, String nascionalidade) {
        super(nome, dataNascimento, nascionalidade);
    }
}
