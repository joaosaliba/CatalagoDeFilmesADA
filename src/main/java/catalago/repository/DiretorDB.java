package catalago.repository;

import catalago.models.Diretor;
import catalago.repository.intefaces.DBInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiretorDB implements DBInterface<Diretor, Integer> {

    Connection db;

    public DiretorDB(Connection db) {
        this.db = db;
    }

    @Override
    public void insert(Diretor diretor) throws SQLException {
        String sql = "INSERT INTO diretor (nome,data_nascimento,nacionalidade,tipo_pessoa_enum) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = db.prepareStatement(sql);
        try {
            statement.setString(1, diretor.getNome());
            statement.setDate(2, Date.valueOf(diretor.getDataNascimento()));
            statement.setString(3, diretor.getNacionalidade());
            statement.setString(4, diretor.getTipoPessoaEnum().name());
            statement.executeUpdate();
            db.commit();
        } catch (SQLException e) {
            db.rollback();
            e.printStackTrace();
        } 
    }


    @Override
    public Diretor getByID(Integer filmeID) throws SQLException {
        String sql = "SELECT * FROM diretor WHERE id = ?";
        PreparedStatement statement = db.prepareStatement(sql);
        try {
            Diretor diretor = null;

            statement.setInt(1, filmeID);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                diretor = new Diretor(resultSet);
            }

            return diretor;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar diretor de id: " + filmeID, e);
        } 

    }

    @Override
    public void removeById(Integer filmeID) throws SQLException {
        String sql = "DELETE FROM diretor WHERE id = ?";
        PreparedStatement statement = db.prepareStatement(sql);
        try {

            statement.setInt(1, filmeID);
            statement.executeUpdate();
            db.commit();

        } catch (SQLException e) {
            db.rollback();
            e.printStackTrace();
            throw new RuntimeException("Erro ao remover diretor de id: " + filmeID, e);
        } 

    }

    @Override
    public List<Diretor> getAll() throws SQLException {
        String sql = "SELECT * FROM diretor";
        PreparedStatement statement = db.prepareStatement(sql);
        try {


            ResultSet resultSet = statement.executeQuery();
            List diretores = new ArrayList<>();
            while (resultSet.next()) {
                Diretor diretor = new Diretor(resultSet);
                diretores.add(diretor);
            }

            return diretores;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar diretores", e);
        } 
    }

    @Override
    public List<Diretor> getByName(String name) throws SQLException {
        String sql = "SELECT * FROM diretor WHERE upper(nome) LIKE ?";
        PreparedStatement statement = db.prepareStatement(sql);
        try {
            statement.setString(1, "%" + name.toUpperCase() + "%");
            ResultSet resultSet = statement.executeQuery();
            List<Diretor> diretores = new ArrayList<>();
            while (resultSet.next()) {
                Diretor diretor = new Diretor(resultSet);
                diretores.add(diretor);
            }

            return diretores;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar diretores", e);
        } 
    }

    public List<Diretor> getByFilmeId(Integer filmeId) throws SQLException {
        String sql = "  SELECT d.* FROM diretor d" +
                " LEFT JOIN filme_diretor  fd ON d.id = fd.diretor_id" +
                " where fd.filme_id = ?";
        PreparedStatement statement = db.prepareStatement(sql);
        try {
            statement.setInt(1, filmeId);
            ResultSet resultSet = statement.executeQuery();
            List<Diretor> diretores = new ArrayList<>();
            while (resultSet.next()) {
                Diretor diretor = new Diretor(resultSet);
                diretores.add(diretor);
            }

            return diretores;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar diretores", e);
        } 
    }

}
