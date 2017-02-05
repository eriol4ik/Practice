package lesson06.lan_graphic.domain;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by eriol4ik on 26/01/2017.
 */
public class TextMessage {
    private IntegerProperty idProperty;
    private StringProperty textProperty;
    private StringProperty loginProperty;
    private StringProperty dateProperty;
    private LocalDateTime date;

    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy H:m:s");

    public TextMessage(String login, String text) {
        this.loginProperty = new SimpleStringProperty(login);
        this.textProperty = new SimpleStringProperty(text);
        date = LocalDateTime.now();
        this.dateProperty = new SimpleStringProperty(date.format(formatter));
    }

    public String getText() {return textProperty.get();}
    public String getLogin() {return loginProperty.get();}
    public String getDate() {return date.format(formatter);}
}
