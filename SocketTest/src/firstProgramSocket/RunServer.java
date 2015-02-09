package firstProgramSocket;

/**
 * Created by glebgeracimenko on 03.02.15.
 */
public class RunServer {

    public static void main(String[] args) {
        MyServerSocket myServerSocket = new MyServerSocket();
        myServerSocket.run();
    }

}
