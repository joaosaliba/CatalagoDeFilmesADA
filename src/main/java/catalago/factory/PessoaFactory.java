package catalago.factory;

import catalago.abstracts.Pessoa;
import catalago.models.Ator;
import catalago.models.Diretor;
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
