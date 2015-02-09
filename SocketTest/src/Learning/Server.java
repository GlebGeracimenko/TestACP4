package Learning;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by glebgeracimenko on 06.02.15.
 */
public class Server {

    public void run() {
        try {
            ServerSocket server = new ServerSocket(9090);
            Socket socket = server.accept();
            System.out.println("Client connect!");
            BufferedReader systemin = new BufferedReader(new InputStreamReader(System.in));
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String s = "";
            while (true) {
                s = dataInputStream.readUTF();
                System.out.println("Client message: " + s);
                System.out.print("Server message: ");
                s = systemin.readLine();
                dataOutputStream.writeUTF(s);
                dataOutputStream.flush();
                System.out.println("Send to client!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
