import client.Client;
import server.Server;

public class SocketShare {
    public static void main(String[] args) {
        switch (args[0]){
            case "-r":
                new Server();
                break;
            case "-s":
                new Client();
                break;
            default:
                System.out.println("-r for Recive / -s to Send");
        }
    }
}
