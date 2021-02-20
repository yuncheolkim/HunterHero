package game;

import game.base.G;
import game.net.server.TcpServer;

/**
 * @author Yunzhe.Jin
 * 2021/2/18 16:13
 */
public class GameMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        TcpServer tcpServer = new TcpServer(9000);
        tcpServer.addStart(G.W);
        tcpServer.addStart(G.G);
        tcpServer.start();

    }
}
