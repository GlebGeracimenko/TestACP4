package firstProgramSocket;

/**
 * Created by glebgeracimenko on 03.02.15.
 */
public class CreateClient {

    public static void main(String[] args) {
        MyClientSocket myClientSocket = new MyClientSocket("127.0.0.1", 9090);
        myClientSocket.start();
    }

}
