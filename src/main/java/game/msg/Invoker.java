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

    public Object invoke(Player player, Message msg) {
        try {
            T req = supplier.get().parseFrom(msg.getBody());
            return handler.handler(player, req);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();

        }
        return null;
    }

    public int getMsgNo() {
        return msgNo;
    }
}
