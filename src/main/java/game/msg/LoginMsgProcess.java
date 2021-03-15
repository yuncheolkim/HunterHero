package game.msg;

import game.base.G;
import game.base.Logs;
import game.proto.LoginReq;
import game.proto.Message;
import io.netty.channel.Channel;


/**
 * @author Yunzhe.Jin
 * 2021/2/20 14:42
 */
public class LoginMsgProcess implements Runnable {

    private Channel ch;

    private Message message;

    public LoginMsgProcess(Channel ch, Message message) {
        this.ch = ch;
        this.message = message;
    }


    @Override
    public void run() {

        try {
            G.G.getLoginHandler().login(ch, LoginReq.parseFrom(message.getBody()));
        } catch (Exception e) {
            Logs.C.error(e);
        }
    }
}
