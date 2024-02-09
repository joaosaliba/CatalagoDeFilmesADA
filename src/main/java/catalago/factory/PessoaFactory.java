package catalago.factory;

import catalago.abstracts.Pessoa;
import catalago.entities.Ator;
import catalago.entities.Diretor;
import catalago.enums.TipoPessoaEnum;

public class PessoaFactory {

    public static Pessoa getInstance(TipoPessoaEnum tipoPessoaEnum) {
        return switch (tipoPessoaEnum) {
            case ATOR -> new Ator(TipoPessoaEnum.ATOR);
            case DIRETOR -> new Diretor(TipoPessoaEnum.DIRETOR);
            default -> throw new IllegalArgumentException("Tipo Pessoa não encontrada");
        };

    }
}
