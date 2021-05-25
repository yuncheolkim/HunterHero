package game.module.chat;

import game.base.G;
import game.base.Logs;
import game.player.Player;
import game.proto.ChatMessageReq;

/**
 * 聊天相关
 *
 * @author Yunzhe.Jin
 * 2021/4/2 14:53
 */
public class ChatHandler {


    /**
     * 聊天
     *
     * @param player
     * @param req
     */
    public static void chat(Player player, ChatMessageReq req) {
        Logs.chat.info("[{}] --> {}", player.getPid(), req.getContent());

        // todo 检查聊天内容
        ChatScene chatScene = G.G.getChatScene();
        chatScene.tell(new ChatMessage(player.getPid(), req));
    }


    /**
     * 世界聊天
     *
     * @param player
     */
    public static void worldChat(Player player) {

    }

    /**
     * 帮派聊天
     *
     * @param player
     */
    public static void groupChat(Player player) {

    }

    /**
     * 私聊
     *
     * @param player
     */
    public static void privacyChat(Player player) {

    }

}
