package net.client;


import game.proto.LoginReq;
import game.proto.Message;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author Yunzhe.Jin
 */
public class ClientMain {

    @Test
    public void testLogin() throws InterruptedException {
        Client client = new Client();
        client.connect("localhost", 9000);

        client.send(Message.newBuilder()
                .setMsgNo(1)
                .setBody(LoginReq.newBuilder().setPlayerId(1).setCode("kim").build().toByteString())
                .build());

        TimeUnit.SECONDS.sleep(300);

    }
}
