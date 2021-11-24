package controller;

import model.Books;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dao.BooksDAO;

import java.net.URL;

import java.util.ResourceBundle;





public class MainController implements Initializable {

    @FXML
    private TextField idField;

    @FXML
    private TextField titleField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField yearField;

    @FXML
    private TextField pagesField;

    @FXML
    private Button insertButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TableView<Books> TableView;

    @FXML
    private TableColumn<Books, Integer> idColumn;

    @FXML
    private TableColumn<Books, String> titleColumn;

    @FXML
    private TableColumn<Books, String> authorColumn;

    @FXML
    private TableColumn<Books, Integer> yearColumn;

    @FXML
    private TableColumn<Books, Integer> pagesColumn;

    BooksDAO dao = new BooksDAO();

    @FXML
    private void insertButton() {
        Books firstBooks = new Books();
        firstBooks.setId(Integer.parseInt(idField.getText()));
        firstBooks.setTitle(titleField.getText());
        firstBooks.setAuthor(authorField.getText());
        firstBooks.setYear(Integer.parseInt(yearField.getText()));
        firstBooks.setPages(Integer.parseInt(pagesField.getText()));
        dao.create(firstBooks);
        showBooks();
    }


    @FXML
    private void updateButton() {
        Books updatedBooks = new Books();
        updatedBooks.setId(Integer.parseInt(idField.getText()));
        updatedBooks.setTitle(titleField.getText());
        updatedBooks.setAuthor(authorField.getText());
        updatedBooks.setYear(Integer.parseInt(yearField.getText()));
        updatedBooks.setPages(Integer.parseInt(pagesField.getText()));
        dao.update(updatedBooks);
        showBooks();
    }

    @FXML
    private void deleteButton() {
        Books removedBooks = new Books();
        removedBooks.setId(Integer.parseInt(idField.getText()));
        dao.delete(removedBooks);
        showBooks();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showBooks();
    }


    public ObservableList<Books> getBooksList(){
        return dao.getAll();
    }

    public void showBooks() {
        ObservableList<Books> list = getBooksList();

        idColumn.setCellValueFactory(new PropertyValueFactory<Books,Integer>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Books,String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Books,String>("author"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Books,Integer>("year"));
        pagesColumn.setCellValueFactory(new PropertyValueFactory<Books,Integer>("pages"));

        TableView.setItems(list);
    }

}