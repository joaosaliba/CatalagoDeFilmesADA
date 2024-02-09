package catalago;

import catalago.abstracts.Pessoa;
import catalago.database.DatabaseConnection;
import catalago.entities.Ator;
import catalago.entities.Filme;
import catalago.enums.TipoPessoaEnum;
import catalago.factory.PessoaFactory;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class CatalagoDeFilmesMain {
    static Connection db = DatabaseConnection.getConnection();

    public static void main(String[] args) {
        Pessoa ator = PessoaFactory.getInstance(TipoPessoaEnum.ATOR);
        ator.setId(1);
        ator.setNome("JOAO");
        ator.setDataNascimento(LocalDate.parse("1997-02-05"));
        ator.setNascionalidade("Brasilerio");
        System.out.println(ator.toString());

        Filme filme = new Filme();
        filme.setId(1);
        filme.setNome("Ascabanas");
        filme.setDataLancamento(LocalDate.parse("2023-05-05"));
        filme.setDescricao("FIlme Bolinha");
        filme.setOrcamento(BigDecimal.valueOf(3_000_000L));
        filme.addAtor((Ator) ator);
        System.out.println(filme.toString());
        filme.removeAtor((Ator) ator);

        System.out.println(filme.toString());

        try {

            inserirFilme(filme, db);
            db.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void inserirFilme(Filme filme, Connection conexao) throws SQLException {
        String sql = "INSERT INTO filme (nome, data_lancamento, orcamento, descricao) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, filme.getNome());
            statement.setDate(2, Date.valueOf(filme.getDataLancamento()));
            statement.setBigDecimal(3, filme.getOrcamento());
            statement.setString(4, filme.getDescricao());

            statement.executeUpdate();
        }
    }

}