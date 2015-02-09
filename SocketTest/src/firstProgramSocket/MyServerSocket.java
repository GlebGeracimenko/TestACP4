package firstProgramSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by glebgeracimenko on 02.02.15.
 */
public class MyServerSocket {

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(9090);
            Socket socket = serverSocket.accept();
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
