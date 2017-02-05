package lesson06.lan_graphic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lesson06.lan_graphic.domain.Message;
import lesson06.lan_graphic.domain.Type;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by eriol4ik on 27/01/2017.
 */
public class LanHelper {
    public static String readMessage(SocketChannel socket, ByteBuffer buffer) {
        int bytes;
        try {
            bytes = socket.read(buffer);
        } catch (IOException ioe) {
            return null;
        }
        if (bytes <= 0) {
            return null;
        }
        buffer.flip();
        String message = new String(buffer.array(), 0, bytes);
        buffer.clear();
        return message;
    }

    public static void writeMessage(String gsonString, SocketChannel socket, ByteBuffer buffer, Type type) {
        Message message = new Message(type, gsonString);
        String gsonMessage = (new Gson()).toJson(message);
        buffer.put(gsonMessage.getBytes());
        buffer.flip();
        try {
            socket.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        buffer.clear();
    }
}
