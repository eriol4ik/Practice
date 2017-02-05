package lesson06.ex01;

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
    ByteBuffer buffer;
    ByteBuffer bufferReceiver;
    int bytes;

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.startSendingMessages();

    }

    private void startSendingMessages() throws IOException {
        String ip = "localhost";
        int port = 20000;
        channel = SocketChannel.open(new InetSocketAddress(ip, port));
        System.out.println(channel.getRemoteAddress());
//        SocketChannel channel = SocketChannel.open(new InetSocketAddress("192.168.1.127", 30000));
        buffer = ByteBuffer.allocate(4096); // объем данных, который передаётся за раз (в байтах)
        bufferReceiver = ByteBuffer.allocate(4096); // объем данных, который передаётся за раз (в байтах)
        Thread thread = new Thread(this);
        thread.start();
//        String testMessage = "Hello!";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testMessage = "";
        while (true) {
            System.out.println("Type your message:");
            testMessage = br.readLine();
            if (testMessage.equals("exit")) {
                channel.close();
                break;
            }

            buffer.put(testMessage.getBytes());
            buffer.flip();
            channel.write(buffer);
            buffer.clear();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                bytes = channel.read(bufferReceiver);
            } catch (IOException ioe) {
                break;
            }
            if (bytes <= 0) {
                break;
            }
            bufferReceiver.flip();
            String message = new String(bufferReceiver.array(), 0, bytes);
            bufferReceiver.clear();
            System.out.println(message);
        }
    }
}
