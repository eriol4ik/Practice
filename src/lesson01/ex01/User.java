package lesson01.ex01;

/**
 * Created by eriol4ik on 17/12/2016.
 */
public class User {

    private String login;
    private String password;
    private Integer year;

    public User(String login, String password, Integer year) {
        this.login = login;
        this.password = password;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false; // сравнить с null не можем, поэтому false
        if (this == obj) return true; // сравнение по ссылке
        if (getClass() == obj.getClass()) {
            User user = (User) obj;
            return this.login.equals(user.getLogin()) && this.password.equals(user.getPassword()) && this.getYear().equals(user.getYear());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return login.hashCode() * password.hashCode() * year.hashCode();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
