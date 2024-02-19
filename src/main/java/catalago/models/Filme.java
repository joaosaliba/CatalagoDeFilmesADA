package catalago.models;

import catalago.abstracts.Pessoa;
import catalago.database.DatabaseConnectionSingleton;
import catalago.repository.AtorDB;
import catalago.repository.DiretorDB;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Filme {
    private Integer id;
    private String nome;
    private LocalDate dataLancamento;
    private BigDecimal orcamento;
    private String descricao;
    private List<Diretor> diretores;
    private List<Ator> atores;

    public Filme(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.nome = resultSet.getString("nome");
        this.dataLancamento = resultSet.getDate("data_lancamento").toLocalDate();
        this.orcamento = resultSet.getBigDecimal("orcamento");
        this.descricao = resultSet.getString("descricao");
        this.diretores = new DiretorDB(new DatabaseConnectionSingleton().getConnection()).getByFilmeId(this.id);
        this.atores = new AtorDB(new DatabaseConnectionSingleton().getConnection()).getByFilmeId(this.id);


    }

    public Filme() {
        this.diretores = new ArrayList<>();
        this.atores = new ArrayList<>();
    }

    public Filme(Integer id, String nome, LocalDate dataLancamento,
                 BigDecimal orcamento, String descricao) {
        this.id = id;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;

    }

    public Filme(String nome, LocalDate dataLancamento,
                 BigDecimal orcamento, String descricao
    ) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;

    }

    public Integer getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public String getDataLancamentoFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return getDataLancamento().format(formatter);
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public BigDecimal getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(BigDecimal orcamento) {
        this.orcamento = orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Diretor> getDiretores() {
        return diretores;
    }

    public void setDiretores(List<Diretor> diretores) {
        this.diretores = diretores;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public List<Ator> addAtor(Ator ator) {
        this.atores.add(ator);
        return this.atores;
    }

    public List<Ator> removeAtor(Ator ator) {
        this.atores.remove(ator);
        return this.atores;
    }

    public List<Diretor> addDiretor(Diretor diretor) {
        this.diretores.add(diretor);
        return this.diretores;
    }

    public List<Diretor> removeDiretor(Diretor diretor) {
        this.diretores.remove(diretor);
        return this.diretores;
    }

    public void showInformations() {
        System.out.println("ID: " + this.getId());
        System.out.println("Nome: " + this.getNome());
        System.out.println("Data Lançamento: " + this.getDataLancamentoFormatada());
        System.out.println("Orçamento: R$" + this.getOrcamento().toString().replace(".", ","));
        System.out.println("Descrição: " + this.getDescricao());
        System.out.println("Diretores: ");
        this.diretores.forEach(Pessoa::showInformations);
        System.out.println("Atores: ");

        this.atores.forEach(Pessoa::showInformations);
        System.out.println("---------------------------\n");
    }

    @Override
    public String toString() {
        return "Filme " +
                "id=" + id + "\n" +
                "nome='" + nome + "\n" +
                "Data Lancamento=" + dataLancamento + "\n" +
                "orcamento=" + orcamento + "\n" +
                "descricao='" + descricao + "\n" +
                "diretores=" + diretores + "\n" +
                "atores=" + atores + "\n" + "\n";
    }
}
