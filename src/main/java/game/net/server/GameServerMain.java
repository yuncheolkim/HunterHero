package game.net.server;

/**
 * @author Yunzhe.Jin
 */
public class GameServerMain {
    public static void main(String[] args) {
        TcpServer gameServer = new TcpServer(9000);
        gameServer.start();

    }
}
