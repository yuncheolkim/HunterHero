package game.msg;

import com.google.protobuf.MessageLite;
import game.proto.KickPush;
import game.proto.Message;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 15:31
 */
public class MsgUtil {
    private static final int version = 1;

    public static Message kickMsg() {
        return Message.newBuilder()
                .setVersion(version).setMsgNo(2).setBody(KickPush.getDefaultInstance().toByteString())
                .build();

    }

    public static Message make(int msgNo, MessageLite msg) {

    }
}
