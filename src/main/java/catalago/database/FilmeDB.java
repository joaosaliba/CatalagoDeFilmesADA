package catalago.database;

import catalago.entities.Filme;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmeDB implements DBInterface<Filme,Integer> {

    Connection db ;

    public FilmeDB() throws SQLException {
        this.db =  new DatabaseConnectionSingleton().getConnection();;
    }

    @Override
    public void insert(Filme filme) throws SQLException {
        String sql = "INSERT INTO filme (nome, data_lancamento, orcamento, descricao) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = db.prepareStatement(sql);
        try {
            statement.setString(1, filme.getNome());
            statement.setDate(2, Date.valueOf(filme.getDataLancamento()));
            statement.setBigDecimal(3, filme.getOrcamento());
            statement.setString(4, filme.getDescricao());
            statement.executeUpdate();
            db.commit();
        } catch (SQLException e) {
            db.rollback();
            e.printStackTrace();
        } finally {
            db.close();
        }
    }


    @Override
    public Filme getByID(Integer filmeID) throws SQLException {
        String sql = "SELECT * FROM filme WHERE id = ?";
        PreparedStatement statement = db.prepareStatement(sql);
        try {
            Filme filme = null;

            statement.setInt(1, filmeID);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                filme = new Filme(resultSet);
            }

            return filme;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar filme de id: "+filmeID, e);
        } finally {
            db.close();
        }

    }
    @Override
    public void removeById(Integer filmeID) throws SQLException {
        String sql = "DELETE FROM filme WHERE id = ?";
        PreparedStatement statement = db.prepareStatement(sql);
        try {

            statement.setInt(1, filmeID);
            statement.executeUpdate();
            db.commit();

        } catch (SQLException e) {
            db.rollback();
            e.printStackTrace();
            throw new RuntimeException("Erro ao remover filme de id: "+filmeID, e);
        } finally {
            db.close();
        }

    }

    @Override
    public List<Filme> getAll() throws SQLException {
        String sql = "SELECT * FROM filme";
        PreparedStatement statement = db.prepareStatement(sql);
        try {


            ResultSet resultSet = statement.executeQuery();
            List filmes = new ArrayList<>();
            while (resultSet.next()) {
                Filme filme  = new Filme(resultSet);
                filmes.add(filme);
            }

            return filmes;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar filmes", e);
        } finally {
            db.close();
        }
    }

    @Override
    public List<Filme> getByName(String name) throws SQLException {
        String sql = "SELECT * FROM filme WHERE upper(nome) LIKE ?";
        PreparedStatement statement = db.prepareStatement(sql);
        try {
            statement.setString(1, "%" + name.toUpperCase() + "%");

            ResultSet resultSet = statement.executeQuery();
            List<Filme> filmes = new ArrayList<>();
            while (resultSet.next()) {
                Filme filme = new Filme(resultSet);
                filmes.add(filme);
            }

            return filmes;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar filmes", e);
        } finally {
            db.close();
        }
    }



}
