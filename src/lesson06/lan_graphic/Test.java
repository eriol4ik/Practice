package lesson06.lan_graphic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lesson06.lan_graphic.domain.Message;
import lesson06.lan_graphic.domain.Type;

/**
 * Created by eriol4ik on 28/01/2017.
 */
public class Test {
    public static void main(String[] args) {
        Message message = new Message(Type.TEXT_MESSAGE, "This is message");
        Gson gson = new Gson();
        String gsonString = gson.toJson(message);
        System.out.println(gsonString);
        Message message1 = gson.fromJson(gsonString, message.getClass());
        System.out.println(message1.getType() + ", " + message1.getGsonString());
    }
}
