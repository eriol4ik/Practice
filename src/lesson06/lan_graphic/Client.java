package lesson06.lan_graphic;

import com.google.gson.Gson;
import lesson06.lan_graphic.domain.Message;
import lesson06.lan_graphic.domain.Result;
import lesson06.lan_graphic.domain.SignData;
import lesson06.lan_graphic.domain.Type;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by eriol4ik on 15/01/2017.
 */

/**

Интернет --- набор сетей, который объеденён одним протоколом для взаимодействия и обмена данными
Протокол --- набор универсальных правил для обмена информации между компьютерами

Протоколы имеют восемь уровней:
1) Физический
2) Канальный
3) Сетевой              <---
4) Транспортный         <---
5) ...
6) ...
7) ...
8) Прикладной

IP  --- Internet Protocol (адресация между компьютерами)
TCP --- Transmission Control Protocol (гарантирует передачу данных в пакетах)

XXX.XXX.XXX.XXX /IPv4/ --- формат адреса

Порт --- идентификатор программы
*/

public class Client implements Runnable {
    SocketChannel channel;
    ByteBuffer bufferOut;
    ByteBuffer bufferIn;

    Integer sessionId;
    String login;

    public String getLogin() {
        return login;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    Gson gson = new Gson();

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.init();

        Thread writeMessagesThread = new Thread(client);
        writeMessagesThread.start();

//        String message;
//        while ((message = client.readMessage()) != null) {
//            System.out.println(message);
//        }

    }

    public Client() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() throws IOException {
        String ip = "192.168.1.100";
        int port = 30000;
        channel = SocketChannel.open(new InetSocketAddress(ip, port));
//        SocketChannel channel = SocketChannel.open(new InetSocketAddress("192.168.1.127", 30000));
        bufferOut = ByteBuffer.allocate(128); // объем данных, который передаётся за раз (в байтах)
        bufferIn = ByteBuffer.allocate(128); // объем данных, который передаётся за раз (в байтах)
    }

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message;
        try {
            while (!(message = br.readLine()).equals("exit")) {
                writeTextMessage(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Message readMessage() {
        String gsonMessage = LanHelper.readMessage(channel, bufferIn);
        return gson.fromJson(gsonMessage, Message.class);
    }

    public void writeTextMessage(String message) {
        LanHelper.writeMessage(message, channel, bufferOut, Type.TEXT_MESSAGE);
    }

    public void authorize(String login, String password) {
        SignData signData = new SignData(login, password);
        LanHelper.writeMessage(gson.toJson(signData), channel, bufferOut, Type.AUTHORIZE);
    }

    public void register(String login, String password) {
        SignData signData = new SignData(login, password);
        LanHelper.writeMessage(gson.toJson(signData), channel, bufferOut, Type.REGISTER);
    }

    public void writeMessage(Message message) {

    }

    public Result readResult() {
        Message message = readMessage();
        if (message.getType() == Type.RESULT) {
            return gson.fromJson(message.getGsonString(), Result.class);
        }
        return null;
    }
}
