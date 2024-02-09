package entities;

import abstracts.Pessoa;
import enums.TipoPessoa;

import java.time.LocalDate;

public class Ator extends Pessoa {
    public Ator() {
    }

    public Ator(String nome, LocalDate dataNascimento, String nascionalidade) {
        super(nome, dataNascimento, nascionalidade, TipoPessoa.ATOR);
    }

    @Override
    public TipoPessoa getTipoPessoa() {
        return TipoPessoa.ATOR;
    }
}
