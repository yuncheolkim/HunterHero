package game;

import cn.hutool.setting.dialect.PropsUtil;
import game.base.G;
import game.base.Logs;
import game.net.server.TcpServer;
import game.utils.FileUtils;

import java.io.IOException;

/**
 * @author Yunzhe.Jin
 * 2021/2/18 16:13
 */
public class GameMain {
    public static void main(String[] args) throws IOException {
        System.out.println("start");
        FileUtils.createDir("data");
        Integer port = PropsUtil.getSystemProps().getInt("server.port", 9001);
        TcpServer tcpServer = new TcpServer(port);
        tcpServer.addStart(G.W);
        tcpServer.addStart(G.G);
        tcpServer.addStart(G.S);
        tcpServer.addStart(G.C);
        tcpServer.start();

        System.out.println(port);
        Logs.C.info("Start game");

    }
}
