package lesson07;

/**
 * Created by eriol4ik on 21/01/2017.
 */
public class User {
    private Integer id;
    private String login;
    private String password;

    public User(Integer id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("login: ").append(login).append(", ")
                .append("password: ").append(password).append(";");
        return sb.toString();
    }
}
