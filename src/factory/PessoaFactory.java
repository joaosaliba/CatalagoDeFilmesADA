package factory;

import abstracts.Pessoa;
import entities.Ator;
import entities.Diretor;
import enums.TipoPessoaEnum;

public class PessoaFactory {

    public static Pessoa getInstance(TipoPessoaEnum tipoPessoaEnum){
        return switch (tipoPessoaEnum){
            case ATOR -> new Ator(TipoPessoaEnum.ATOR);
            case DIRETOR ->  new Diretor(TipoPessoaEnum.DIRETOR);
            default -> throw new IllegalArgumentException("Tipo Pessoa não encontrada");
        };

    }
}
