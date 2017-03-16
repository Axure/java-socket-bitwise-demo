import java.io.InputStream;
import java.net.Socket;

public class Client {

    final static int n = 10;

    public static void main(String[] args) throws Exception {

        System.out.printf("%x\n", 0xff);
        System.out.printf("%x\n", 0xff << 1);
        System.out.printf("%x\n", 0xff << 2);
        System.out.printf("%x\n", 0xff << 3);
        System.out.printf("%x\n", 0xff << 4);
        System.out.printf("%x\n", 0xff << 5);
        System.out.printf("%x\n", 0xff << 6);
        System.out.printf("%x\n", 0xff << 7);
        System.out.printf("%x\n", 0xff << 8);
        System.out.printf("%x\n", 0xff << 9);
        System.out.printf("%x\n", 0xff << 10);
        System.out.printf("%x\n", (0xff << 8) + (0xff));

        Socket socket = new Socket("127.0.0.1", 11888);

        InputStream outputStream = socket.getInputStream();
        byte[] bytes = new byte[n];

        outputStream.read(bytes);

        for (int i = 0; i < n; ++i) {
            System.out.printf("%x\n", bytes[i]);
        }
        for (int i = 0; i < n / 2; ++i) {
            System.out.printf("%x, %x, %x, %x\n", bytes[2 * i], bytes[2 * i + 1],bytes[2 * i] <<
            8, ((bytes[2 * i]) << 8) + bytes[2 * i + 1]);
        }
        socket.close();
    }
}

class Target {
    public String hostName;
    public int portNumber;

    public Target(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
    }
}