package catalago.models;

import catalago.abstracts.Pessoa;
import catalago.enums.TipoPessoaEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Ator extends Pessoa {
    public Ator() {
        this.setTipoPessoaEnum(TipoPessoaEnum.ATOR);
    }


    public Ator(String nome, LocalDate dataNascimento, String nacionalidade) {
        super(nome, dataNascimento, nacionalidade);
        this.setTipoPessoaEnum(TipoPessoaEnum.ATOR);
    }

    public Ator(Integer id, String nome, LocalDate dataNascimento, String nacionalidade) {
        super(id, nome, dataNascimento, nacionalidade);
        this.setTipoPessoaEnum(TipoPessoaEnum.ATOR);
    }

    public Ator(ResultSet resultSet) throws SQLException {
        super( resultSet.getInt("id"), resultSet.getString("nome"),
                resultSet.getDate("data_nascimento").toLocalDate(), resultSet.getString("nacionalidade"));
        this.setTipoPessoaEnum(TipoPessoaEnum.ATOR);

    }


    @Override
    public TipoPessoaEnum getTipoPessoaEnum() {
        return TipoPessoaEnum.ATOR;
    }
}
