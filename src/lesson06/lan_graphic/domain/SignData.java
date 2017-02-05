package lesson06.lan_graphic.domain;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by eriol4ik on 26/01/2017.
 */
public class SignData {
    private String login;
    private String password;

    public SignData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {return login;}
    public String getPassword() {return password;}
}
