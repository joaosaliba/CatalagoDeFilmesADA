package catalago.repository.intefaces;

import catalago.entities.Filme;

import java.sql.SQLException;
import java.util.List;

public interface DBInterface<T,I> {
    void insert(T entity) throws SQLException;
    void removeById(I entityID) throws SQLException;
    T getByID(I entityID) throws SQLException;
    List<T> getAll() throws SQLException;
    List<T> getByName(String name) throws SQLException;
}
