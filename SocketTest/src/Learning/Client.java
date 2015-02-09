package Learning;

import java.io.*;
import java.net.Socket;

/**
 * Created by glebgeracimenko on 06.02.15.
 */
public class Client {

    private String ip;
    private int port;

    public Client() {
    }

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void start() {
        try {
            Socket client = new Socket(ip, port);
            BufferedReader systemin = new BufferedReader(new InputStreamReader(System.in));
            DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
            String s = "";
            while (true) {
                System.out.print("Client message: ");
                s = systemin.readLine();
                dataOutputStream.writeUTF(s);
                dataOutputStream.flush();
                System.out.println("Send to server!");
                s = dataInputStream.readUTF();
                System.out.println("Server message: " + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
