package lesson06.lan_graphic;

import com.google.gson.Gson;
import lesson06.lan_graphic.domain.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.sql.*;
import java.util.List;

public class Server {
    private ByteBuffer bufferIn;
    private ByteBuffer bufferOut;
    private SocketChannel socket;
    private List<Handler> handlers;
    private List<String> messages;

    private Integer sessionId = 1;

    private Gson gson = new Gson();

    private static String url = "jdbc:mysql://localhost:3306/chat";
    private static String dbLogin = "root";
    private static String dbPassword = "qwerty";

    public static void main(String[] args) {
        Server server = new Server();
        server.init();

//        Thread writeMessagesThread = new Thread(server);
//        writeMessagesThread.start();
//
//        String message;
//        while((message = server.readMessage()) != null) {
//            System.out.println(message);
//        }
    }

    public void init() {
        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.bind(new InetSocketAddress(30000));

            while (channel.isOpen()) {
                new Handler(channel.accept()).start();
                System.out.println("accepted");
            }
        } catch (IOException ioe) {
            System.out.println("Error");
        }
    }


    private class Handler extends Thread {
        private SocketChannel socket;
        private ByteBuffer bufferIn;
        private ByteBuffer bufferOut;

        public Handler(SocketChannel socket) {
            this.socket = socket;
            bufferIn = ByteBuffer.allocate(128);
            bufferOut = ByteBuffer.allocate(128);
        }

        @Override
        public void run() {
            while(true) {
                readMessage();
            }
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String message;
//            try {
//                while (!(message = br.readLine()).equals("exit")) {
//                    writeMessage(message);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            String message;
//            while((message = readMessage()) != null) {
//                System.out.println(message);
//            }
        }

        private void readMessage() {
            String gsonMessage = LanHelper.readMessage(this.socket, this.bufferIn);
            Message message = (new Gson()).fromJson(gsonMessage, Message.class);
            String gsonString = message.getGsonString();
            switch (message.getType()) {
                case TEXT_MESSAGE:
                    readTextMessage(gsonString);
                    break;
                case AUTHORIZE:
                    Result result1 = authorize(gsonString);
                    System.out.println(gson.toJson(result1));
                    writeMessage(gson.toJson(result1), Type.RESULT);
                    break;
                case REGISTER:
                    Result result2 = register(gsonString);
                    writeMessage(gson.toJson(result2), Type.RESULT);
                    break;
            }
        }

        private void writeMessage(String message, Type type) {
            LanHelper.writeMessage(message, this.socket, this.bufferOut, type);
        }
    }

    private Result authorize(String gsonString) {
        SignData signData = gson.fromJson(gsonString, SignData.class);
        try {
            Connection connection = DriverManager.getConnection(url, dbLogin, dbPassword);
            String query = "SELECT `password` from USERS WHERE `login`=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, signData.getLogin());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getString(1).equals(signData.getPassword())) {
//                    setErrorMsg("");
//                    showChatWindowFor(new SignData(login, password));
                    return new Result(Status.SUCCESS, sessionId++);
                } else {
                    return new Result(Status.INCORRECT_PASSWORD, null);
                }
            } else {
                return new Result(Status.NO_SUCH_USER, null);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return new Result(Status.SQL_EXCEPTION, null);
        }
    }

    private Result register(String gsonString) {
        SignData signData = gson.fromJson(gsonString, SignData.class);
        String login = signData.getLogin();
        String password = signData.getPassword();
        try {
            Connection connection = DriverManager.getConnection(url, dbLogin, dbPassword);

            // check the user with this login in `users`
            String query1 = "SELECT `password` from USERS WHERE `login`=?";
            PreparedStatement statement1 = connection.prepareStatement(query1);
            statement1.setString(1, login);
            ResultSet resultSet = statement1.executeQuery();
            if (resultSet.next()) {
                return new Result(Status.USER_EXISTS, null);
            } else {
                // if not insert this new user into table `users`
                String query2 = "INSERT INTO `users` (`login`, `password`) VALUES (?, ?)";
                PreparedStatement statement2 = connection.prepareStatement(query2);
                statement2.setString(1, login);
                statement2.setString(2, password);
                statement2.execute();
                return new Result(Status.SUCCESS, sessionId++);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return new Result(Status.SQL_EXCEPTION, null);
        }
    }

    private void readTextMessage(String gsonString) {

    }
}
