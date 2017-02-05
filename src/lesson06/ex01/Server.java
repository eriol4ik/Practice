package lesson06.ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server implements Runnable {
    private ByteBuffer bufferIn;
    private ByteBuffer bufferOut;
    private SocketChannel socket;
    private ServerSocketChannel channel;

    public static void main(String[] args)throws IOException {
        Server server = new Server();
        server.init();

        Thread thread = new Thread(server);
        thread.start();

        server.writeMessages();
    }

    public void init() {
        try {
            channel = ServerSocketChannel.open();
            channel.bind(new InetSocketAddress("localhost", 20000));

            socket = channel.accept();
            bufferIn = ByteBuffer.allocate(4096);
            bufferOut = ByteBuffer.allocate(4096);
        } catch (IOException ioe) {
            System.out.println("Error starting server");
        }
    }

    public void readMessages() {
        int bytes;
        while (true) {
            try {
                bytes = socket.read(bufferIn);
            } catch (IOException ioe) {
                break;
            }
            if (bytes <= 0) {
                break;
            }
            bufferIn.flip();
            String message = new String(bufferIn.array(), 0, bytes);
            bufferIn.clear();
            System.out.println(message);
        }
    }

    private void writeMessages() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String outMessage;
        while (true) {
            System.out.println("Type your message:");
            outMessage = br.readLine();
            if (outMessage.equals("exit")) {
                channel.close();
                break;
            }

            bufferOut.put(outMessage.getBytes());
            bufferOut.flip();
            socket.write(bufferOut);
            bufferOut.clear();
        }
    }

    @Override
    public void run() {
        readMessages();
    }
}
