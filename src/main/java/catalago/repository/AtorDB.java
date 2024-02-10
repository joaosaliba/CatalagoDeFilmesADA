package catalago.repository;

import catalago.database.DatabaseConnectionSingleton;
import catalago.entities.Ator;
import catalago.repository.intefaces.DBInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AtorDB implements DBInterface<Ator,Integer> {

    Connection db ;

    public AtorDB() throws SQLException {
        this.db =  new DatabaseConnectionSingleton().getConnection();;
    }

    @Override
    public void insert(Ator ator) throws SQLException {
        String sql = "INSERT INTO ator (nome,data_nascimento,nacionalidade,tipo_pessoa_enum) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = db.prepareStatement(sql);
        try {
            statement.setString(1, ator.getNome());
            statement.setDate(2, Date.valueOf(ator.getDataNascimento()));
            statement.setString(3, ator.getNacionalidade());
            statement.setString(4, ator.getTipoPessoaEnum().name());
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
    public Ator getByID(Integer filmeID) throws SQLException {
        String sql = "SELECT * FROM ator WHERE id = ?";
        PreparedStatement statement = db.prepareStatement(sql);
        try {
            Ator ator = null;

            statement.setInt(1, filmeID);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ator = new Ator(resultSet);
            }

            return ator;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar ator de id: "+filmeID, e);
        } finally {
            db.close();
        }

    }
    @Override
    public void removeById(Integer filmeID) throws SQLException {
        String sql = "DELETE FROM ator WHERE id = ?";
        PreparedStatement statement = db.prepareStatement(sql);
        try {

            statement.setInt(1, filmeID);
            statement.executeUpdate();
            db.commit();

        } catch (SQLException e) {
            db.rollback();
            e.printStackTrace();
            throw new RuntimeException("Erro ao remover ator de id: "+filmeID, e);
        } finally {
            db.close();
        }

    }

    @Override
    public List<Ator> getAll() throws SQLException {
        String sql = "SELECT * FROM ator";
        PreparedStatement statement = db.prepareStatement(sql);
        try {


            ResultSet resultSet = statement.executeQuery();
            List atores = new ArrayList<>();
            while (resultSet.next()) {
                Ator ator  = new Ator(resultSet);
                atores.add(ator);
            }

            return atores;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar atores", e);
        } finally {
            db.close();
        }
    }

    @Override
    public List<Ator> getByName(String name) throws SQLException {
        String sql = "SELECT * FROM ator WHERE upper(nome) LIKE ?";
        PreparedStatement statement = db.prepareStatement(sql);
        try {
            statement.setString(1, "%" + name.toUpperCase() + "%");
            ResultSet resultSet = statement.executeQuery();
            List<Ator> atores = new ArrayList<>();
            while (resultSet.next()) {
                Ator ator = new Ator(resultSet);
                atores.add(ator);
            }

            return atores;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar atores", e);
        } finally {
            db.close();
        }
    }



}
