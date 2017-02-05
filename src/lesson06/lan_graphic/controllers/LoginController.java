package lesson06.lan_graphic.controllers;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lesson06.lan_graphic.Client;
import lesson06.lan_graphic.domain.*;

import javax.xml.transform.Source;
import java.io.IOException;

/**
 * Created by eriol4ik on 26/01/2017.
 */
public class LoginController {

    @FXML private TextField loginField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorMsg;

    @FXML private Button signIn;
    @FXML private Button signUp;

    private Client client;

    public void initialize() {
        client = new Client();
    }

    /*
    * по-хорошему, отправляются данные авторизации на сервер,
    * он их проверяет и отправляет результат
    */
    @FXML
    public void signIn(ActionEvent event) throws IOException {
        if (!loginField.getText().isEmpty() && !passwordField.getText().isEmpty()) {
            String login = loginField.getText();
            String password = passwordField.getText();
            if (event.getSource() == signIn) {
                client.authorize(login, password);
            } else {
                client.register(login, password);
            }
            Result result = client.readResult();

            switch (result.getStatus()) {
                case SUCCESS:
                    Integer sessionId = result.getSessionId();
                    showChatWindowFor(login, sessionId);
                    break;
                case SQL_EXCEPTION:
                    setErrorMsg(Status.SQL_EXCEPTION.toString());
                    break;
                case INCORRECT_PASSWORD:
                    setErrorMsg(Status.INCORRECT_PASSWORD.toString());
                    break;
                case NO_SUCH_USER:
                    setErrorMsg(Status.NO_SUCH_USER.toString());
                    break;
                case USER_EXISTS:
                    setErrorMsg(Status.USER_EXISTS.toString());
                    break;
                case UNKNOWN:
                    setErrorMsg(Status.UNKNOWN.toString());
                    break;
                default:
                    setErrorMsg("");
            }
        } else {

        }
    }

    private void showChatWindowFor(String login, Integer sessionId) throws IOException {
        Stage loginStage = (Stage) loginField.getScene().getWindow();
        loginStage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lesson06/lan_graphic/main.fxml"));
        GridPane pane = loader.load();

        ChatController chatController = loader.getController();

        client.setLogin(login);
        client.setSessionId(sessionId);

        chatController.setClient(client);

        Stage stage = new Stage();
        stage.setTitle("Chat");
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void setErrorMsg(String msg) {
        errorMsg.setText(msg);
    }

}
