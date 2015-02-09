package firstProgramSocket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by glebgeracimenko on 03.02.15.
 */
public class MyClientSocket {

    private String ipAddress;
    private int port;

    public MyClientSocket() {
    }

    public MyClientSocket(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public void start() {
        try {
            Socket socket = new Socket(ipAddress, port);
            BufferedReader systemin = new BufferedReader(new InputStreamReader(System.in));

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String s = "";
            while (true) {
                System.out.print("Client message: ");
                s = systemin.readLine();
                dataOutputStream.writeUTF(s);
                dataOutputStream.flush();
                System.out.println("Send to server!");
                s = dataInputStream.readUTF();
                System.out.print("Server message: " + s + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
