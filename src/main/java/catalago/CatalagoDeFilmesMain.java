package catalago;

import catalago.repository.AtorDB;

import java.sql.SQLException;
import java.util.List;

public class CatalagoDeFilmesMain {


    public static void main(String[] args) throws SQLException {
//        Pessoa ator = PessoaFactory.getInstance(TipoPessoaEnum.DIRETOR);
//        ator.setNome("JOAO");
//        ator.setDataNascimento(LocalDate.parse("1997-02-05"));
//        ator.setNacionalidade("Brasilerio");
//        new DiretorDB().insert((Diretor) ator);
//        List atores= new DiretorDB().getByName("J");
//        System.out.println(atores.toString());
//
//        Filme filme = new Filme();
//        filme.setNome("Ascabanas");
//        filme.setDataLancamento(LocalDate.parse("2023-05-05"));
//        filme.setDescricao("FIlme Bolinha");
//        filme.setOrcamento(BigDecimal.valueOf(3_000_000L));
//        filme.addDiretor((Diretor) ator);
//        System.out.println(filme.toString());
//
//        System.out.println(filme.toString());
//
//        new FilmeDB().insert(filme);
//        filme.setNome("bbbbb");
//
//        new FilmeDB().insert(filme);
//        List filmes= new FilmeDB().getByName("a");
//        System.out.println(filmes.toString());


//                Pessoa ator = PessoaFactory.getInstance(TipoPessoaEnum.ATOR);
//        ator.setNome("HENRIQUE");
//        ator.setDataNascimento(LocalDate.parse("1997-02-05"));
//        ator.setNacionalidade("Brasilerio");
//        new AtorDB().insert((Ator) ator);
//        List atores= new AtorDB().getByName("J");
//        System.out.println(atores.toString());
        List atores= new AtorDB().getByFilmeId(1);
        System.out.println(atores.toString());

    }


}