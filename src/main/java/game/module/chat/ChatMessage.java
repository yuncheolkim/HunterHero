package game.module.chat;

import game.proto.ChatMessageReq;


/**
 * @author Yunzhe.Jin
 * 2021/5/25 15:43
 */
public class ChatMessage {

    public final long pid;

    public final ChatMessageReq req;

    public ChatMessage(long pid, ChatMessageReq req) {
        this.pid = pid;
        this.req = req;
    }
}
