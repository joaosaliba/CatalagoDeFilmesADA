package catalago.entities;

import catalago.abstracts.Pessoa;
import catalago.enums.TipoPessoaEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Diretor extends Pessoa {
    public Diretor() {
        this.setTipoPessoaEnum(TipoPessoaEnum.DIRETOR);
    }

    public Diretor(TipoPessoaEnum tipoPessoaEnum) {
        super(tipoPessoaEnum);
    }

    public Diretor(String nome, LocalDate dataNascimento, String nacionalidade) {
        super(nome, dataNascimento, nacionalidade);
        this.setTipoPessoaEnum(TipoPessoaEnum.DIRETOR);
    }
    public Diretor(Integer id,String nome, LocalDate dataNascimento, String nacionalidade) {
        super(id,nome, dataNascimento, nacionalidade);
        this.setTipoPessoaEnum(TipoPessoaEnum.DIRETOR);
    }

    public Diretor(ResultSet resultSet) throws SQLException {
        super( resultSet.getInt("id"), resultSet.getString("nome"),
                resultSet.getDate("data_nascimento").toLocalDate(), resultSet.getString("nacionalidade"));
        this.setTipoPessoaEnum(TipoPessoaEnum.DIRETOR);
    }

    @Override
    public TipoPessoaEnum getTipoPessoaEnum() {
        return TipoPessoaEnum.DIRETOR;
    }
}
