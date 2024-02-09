package entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Filme {
    private static Integer counter = 1;

    private static Integer getAndIncrementCounter() {
        return counter++;
    }

    private Integer id;
    private String nome;
    private LocalDate dataLancamento;
    private BigDecimal orcamento;
    private String descricao;

    private List<Diretor> diretores;
    private List<Ator> atores;


    public Filme() {
        this.diretores = new ArrayList<>();
        this.atores = new ArrayList<>();
    }

    public Filme(String nome, LocalDate dataLancamento,
                 BigDecimal orcamento, String descricao) {
        this.id = getAndIncrementCounter();
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        ;
    }

    public Filme(String nome, LocalDate dataLancamento,
                 BigDecimal orcamento, String descricao,
                 List<Diretor> diretores, List<Ator> atores) {
        this.id = getAndIncrementCounter();
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.diretores = diretores;
        this.atores = atores;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataLancamento=" + dataLancamento +
                ", orcamento=" + orcamento +
                ", descricao='" + descricao + '\'' +
                ", diretores=" + diretores +
                ", atores=" + atores +
                '}';
    }
}
