package entities;

import abstracts.Pessoa;
import enums.TipoPessoaEnum;

import java.time.LocalDate;

public class Diretor extends Pessoa {
    public Diretor() {
        this.setTipoPessoaEnum(TipoPessoaEnum.DIRETOR);
    }

    public Diretor(TipoPessoaEnum tipoPessoaEnum) {
        super(tipoPessoaEnum);
    }

    public Diretor(String nome, LocalDate dataNascimento, String nascionalidade) {
        super(nome, dataNascimento, nascionalidade);
        this.setTipoPessoaEnum(TipoPessoaEnum.DIRETOR);
    }

    @Override
    public TipoPessoaEnum getTipoPessoaEnum() {
        return  TipoPessoaEnum.DIRETOR;
    }
}
