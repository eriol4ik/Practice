package lesson05.ex01;

import java.io.Serializable;

/**
 * Created by eriol4ik on 14/01/2017.
 */
public class User implements BaseUser, Serializable {
    public String pubStr = "pub";
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public boolean setNewLoginAndPassword(String login, String password) {
        this.login = login;
        this.password = password;
        return true;
    }

    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
}
