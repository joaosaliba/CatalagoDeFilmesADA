package entities;

import abstracts.Pessoa;

import java.time.LocalDate;

public class Diretor extends Pessoa {
    public Diretor() {
    }

    public Diretor(String nome, LocalDate dataNascimento, String nascionalidade) {
        super(nome, dataNascimento, nascionalidade);
    }
}
