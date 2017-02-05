package lesson08.jdbc_graphic.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lesson08.jdbc_graphic.Domain.Contact;

import java.io.IOException;
import java.sql.*;
import java.util.Locale;

/**
 * Created by eriol4ik on 22/01/2017.
 */
public class MainController {
    private static String url       = "jdbc:mysql://localhost:3306/first_db";
    private static String login     = "root";
    private static String password  = "qwerty";

    private ObservableList<Contact> contacts;

    @FXML private TableView<Contact> tableContacts;
    @FXML private TableColumn<Contact, Integer> id;
    @FXML private TableColumn<Contact, String>  name;
    @FXML private TableColumn<Contact, String>  surname;
    @FXML private TableColumn<Contact, Integer> age;
    @FXML private TableColumn<Contact, String>  email;
    @FXML private TableColumn<Contact, Integer> mobile;


    @FXML
    public void initialize() {
        contacts = FXCollections.observableArrayList();

        /* https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/cell/PropertyValueFactory.html */
        id.setCellValueFactory(new PropertyValueFactory<>("id")); // связывает колонку id таблицы контактов с методом getId() класса Contact (в данном случае// )
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));

        tableContacts.setItems(contacts);

        updateTable();
    }

    private void updateTable() {
        try {
            Locale.setDefault(Locale.ENGLISH);
            Connection connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM CONTACTS");
            contacts.clear();
            while (resultSet.next()) {
                contacts.add(new Contact(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getString("email"),
                        resultSet.getInt("mobile")
                ));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onActionInsertButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lesson08/jdbc_graphic/insert.fxml"));
        GridPane page = loader.load();

        Stage stage = new Stage();
        stage.setTitle("New contact");
        stage.initOwner(tableContacts.getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.showAndWait();

        InsertController insertController = loader.getController();
        Contact contact = insertController.getContact();
        if (contact != null) {
            addContactToDB(contact);
            updateTable();
        }
    }

    @FXML
    public void onActionExitButton() {
        System.exit(0);
    }

    public void addContactToDB(Contact contact) {
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            String query = String.format(
                    "INSERT INTO `contacts` (" +
                    "`id`, `name`, `surname`, `age`, `email`, `mobile`" +
                    ") VALUES (" +
                    "'%d', '%s', '%s', '%d', '%s', '%d'" +
                    ");",
                    contact.getId(),
                    contact.getName(),
                    contact.getSurname(),
                    contact.getAge(),
                    contact.getEmail(),
                    contact.getMobile()
            );
            connection.createStatement().execute(query);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
