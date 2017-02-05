package lesson06.lan_graphic.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lesson06.lan_graphic.Client;
import lesson06.lan_graphic.domain.Message;
import lesson06.lan_graphic.domain.SignData;
import lesson06.lan_graphic.domain.TextMessage;

import java.time.LocalDate;

/**
 * Created by eriol4ik on 21/01/2017.
 */

public class ChatController {
    @FXML private TextField messageField;
    @FXML private TableView<TextMessage> messagesTable;
    private ObservableList<TextMessage> messages;
    @FXML private TableColumn<TextMessage, String> user;
    @FXML private TableColumn<TextMessage, String> text;
    @FXML private TableColumn<TextMessage, String> date;
//    private SignData user;
    private Client client;

    public void initialize() {
        messages = FXCollections.observableArrayList();

        user.setCellValueFactory(new PropertyValueFactory<>("login"));
        text.setCellValueFactory(new PropertyValueFactory<>("text"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        messagesTable.setItems(messages);
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @FXML
    public void onActionSendButton() {
        if (!messageField.getText().equals("")) {
            TextField textField = new TextField(messageField.getText());
            textField.setEditable(false);
            textField.setStyle( "-fx-background-color: transparent;" +
                                "-fx-background-insets: 0px;");
            messages.add(new TextMessage(client.getLogin(), textField.getText()));
            messageField.setText("");
        }
    }
}
