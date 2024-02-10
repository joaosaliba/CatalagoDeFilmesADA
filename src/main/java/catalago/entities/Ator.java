package catalago.entities;

import catalago.abstracts.Pessoa;
import catalago.enums.TipoPessoaEnum;

import java.time.LocalDate;

public class Ator extends Pessoa {
    public Ator() {
        this.setTipoPessoaEnum(TipoPessoaEnum.ATOR);
    }

    public Ator(TipoPessoaEnum tipoPessoaEnum) {
        super(tipoPessoaEnum);
    }

    public Ator(String nome, LocalDate dataNascimento, String nascionalidade) {
        super(nome, dataNascimento, nascionalidade);
        this.setTipoPessoaEnum(TipoPessoaEnum.ATOR);
    }

    public Ator(Integer id, String nome, LocalDate dataNascimento, String nascionalidade) {
        super(id, nome, dataNascimento, nascionalidade);
        this.setTipoPessoaEnum(TipoPessoaEnum.ATOR);
    }

    @Override
    public TipoPessoaEnum getTipoPessoaEnum() {
        return TipoPessoaEnum.ATOR;
    }
}
