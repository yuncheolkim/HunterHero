package game.msg;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import game.player.Player;
import game.proto.Message;

import java.util.function.Supplier;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 15:10
 */
public class Invoker<T extends MessageLite> {

    private IMsgHandler<T> handler;

    private int msgNo;

    private Supplier<Parser<T>> supplier;


    public Invoker(int msgNo, IMsgHandler<T> handler, Supplier<Parser<T>> supplier) {
        this.handler = handler;
        this.msgNo = msgNo;
        this.supplier = supplier;
    }

    public void invoke(Player player, Message msg) {
        try {
            T req = supplier.get().parseFrom(msg.getBody());
            Object ret = handler.handler(player, req);
            player.send(ret);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }

    public int getMsgNo() {
        return msgNo;
    }
}
