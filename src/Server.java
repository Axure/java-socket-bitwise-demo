

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {

        byte[] data = new byte[]{(byte)0xff, (byte)0xff, (byte)0xff, (byte)0xff, (byte)0xff, (byte)0xff, (byte)0xff};
        ServerSocket serverSocket = new ServerSocket(11888);
        while (true) {
            Socket socket = serverSocket.accept();
            socket.getOutputStream().write(data);
            socket.close();
        }
    }
}