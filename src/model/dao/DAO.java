package model.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;

public abstract class DAO<T> {

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library","db_username","db_password");
            return conn;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public abstract T get(String id);
    public abstract List<T> getAll();
    public abstract void create(T t);
    public abstract boolean update(T t);
    public abstract boolean delete(T t);
}
