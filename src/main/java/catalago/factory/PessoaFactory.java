package catalago.factory;

import catalago.abstracts.Pessoa;
import catalago.entities.Ator;
import catalago.entities.Diretor;
import catalago.enums.TipoPessoaEnum;

public class PessoaFactory {

    public static Pessoa getInstance(TipoPessoaEnum tipoPessoaEnum) {
        return switch (tipoPessoaEnum) {
            case ATOR -> new Ator();
            case DIRETOR -> new Diretor();
            default -> throw new IllegalArgumentException("Tipo Pessoa não encontrada");
        };

    }
}
