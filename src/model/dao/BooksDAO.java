package model.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Books;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BooksDAO extends DAO<Books> {
    @Override
    public Books get(String id) {
        return null;
    }

    @Override
    public ObservableList<Books> getAll() {
        ObservableList<Books> booksList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM books ";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Books books;
            while(rs.next()) {
                books = new Books(rs.getInt("Id"),
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getInt("Year"),
                        rs.getInt("Pages"));
                booksList.add(books);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return booksList;
    }

    @Override
    public void create(Books books) {
        String query = "insert into books values("+books.getId()+",'"+books.getTitle()+"','"+books.getAuthor()+"',"+books.getYear()+","+books.getPages()+")";
        executeQuery(query);
    }

    @Override
    public boolean update(Books books) {
        String query = "UPDATE books SET Title='"+books.getTitle()+"',Author='"+books.getAuthor()+"',Year="+books.getYear()+",Pages="+books.getPages()+" WHERE ID="+books.getId()+"";
        executeQuery(query);
        return true;
    }

    @Override
    public boolean delete(Books books) {
        String query = "DELETE FROM books WHERE ID="+books.getId()+"";
        executeQuery(query);
        return true;
    }

    public void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
