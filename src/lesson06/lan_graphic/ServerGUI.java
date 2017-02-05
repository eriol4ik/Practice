package lesson06.lan_graphic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * Created by eriol4ik on 21/01/2017.
 */
public class ServerGUI extends Application {
    TilePane messages;
    TextField message;
    ScrollPane scrollPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Server");
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 500, 250);

//        FlowPane messages = new FlowPane();
        messages = new TilePane();
//        messages.setVgap(5);
        messages.setPrefSize(350, 200);
        messages.setPrefColumns(1);
        scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(messages);
        root.add(scrollPane, 0, 0);
        messages.getChildren().add(getTextFieldWith("fsdfs1"));
        messages.getChildren().add(getTextFieldWith("fsdfs2"));
        messages.getChildren().add(getTextFieldWith("fsdfs3"));

        message = new TextField();
        message.setOnAction((e) -> getAction());
        root.add(message, 0, 1);

        Button button = new Button("add");
        button.setOnAction((e) -> getAction());
        root.add(button, 0, 2);

        scene.getStylesheets().add(getClass().getResource("copyable-text.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println(messages);
    }

    private void getAction() {
        if (!message.getText().equals("")) {
            messages.getChildren().add(getTextFieldWith(message.getText()));
            message.setText("");
            scrollPane.setVvalue(scrollPane.getVmax());
        }
    }

    private TextField getTextFieldWith(String text) {
        TextField textField = new TextField(text);
        textField.setPrefWidth(300);
        textField.getStyleClass().add("copyable-label");
        return textField;
    }

    public void addMessage(String message) {
        messages.getChildren().add(getTextFieldWith(message));
    }
}
