package net.client;



/**
 * @author Yunzhe.Jin
 */
public class ClientMain {

    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        client.connect("localhost", 9000);

    }
}
