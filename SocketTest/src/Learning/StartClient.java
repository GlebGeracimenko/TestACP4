package Learning;

/**
 * Created by glebgeracimenko on 06.02.15.
 */
public class StartClient {
    public static void main(String[] args) {
        Client client = new Client("127.0.0.1", 9090);
        client.start();
    }
}
