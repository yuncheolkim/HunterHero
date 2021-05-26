package game.module.chat;

import game.base.G;
import game.game.scene.GameScene;
import game.proto.ChatChannel;
import game.proto.ChatMessagePush;
import game.proto.ChatMessageReq;
import game.proto.no.No;

/**
 * 聊天处理
 *
 * @author Yunzhe.Jin
 * 2021/4/2 16:57
 */
public class ChatScene extends GameScene {

    //    private Map<Long, ChatData> playerMap = new HashMap<>();
    private long id;

    @Override
    protected void process(Object msg) {
        if (msg instanceof ChatMessage) {

            recvMsg((ChatMessage) msg);
        }
    }

    /**
     * 收到聊天消息
     *
     * @param msg
     */
    private void recvMsg(ChatMessage msg) {
        long now = System.currentTimeMillis();
//        ChatData chatData = playerMap.computeIfAbsent(msg.pid, pid -> {
//            ChatData n = new ChatData();
//            n.pid = pid;
//            n.lastTime = lastTime;
//            return n;
//        });
//
//        chatData.lastTime = lastTime;

        ChatMessageReq req = msg.req;
        ChatMessagePush message = ChatMessagePush.newBuilder()
                .setChannel(req.getChannel())
                .setFromUser(msg.pid)
                .setTime(now)
                .setId(++id)
                .setContent(req.getContent())
                .buildPartial();
        if (msg.req.getChannel() == ChatChannel.WORLD) {
            // 世界聊天，广播所有人,包括自己
            G.pushToAllPlayer(No.ChatMessagePush_VALUE, message);
        } else if (msg.req.getChannel() == ChatChannel.PRIVACY || msg.req.getChannel() == ChatChannel.SYSTEM) {
            // 私聊
            G.pushToPlayer(req.getToUser(), No.ChatMessagePush_VALUE, message);
        }

    }

}
