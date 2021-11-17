package game.base;

import game.manager.*;
import game.module.player.Player;
import game.msg.MsgProcess;
import game.proto.Message;
import game.proto.no.No;

import java.util.Map;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 10:35
 */
public class G {

    ///////////// Lifecycle
    public static WorkManager W = new WorkManager();

    public static GameManager G = new GameManager();

    public static ScheduleManager S = new ScheduleManager();

    public static ConfigManager C = new ConfigManager();

    public static SceneManager SCENE = new SceneManager();

    public static RepositoryManager RP = new RepositoryManager();

    public static HttpManager H = new HttpManager();

    ///////////// No Lifecycle
    public static RepoManager R = new RepoManager();

    public static PlayerManager P = new PlayerManager();

    public static EventManager E = new EventManager();

    public static TaskManager T = new TaskManager();


    public static void findException(Exception e) {
        Logs.C.error(e);
        System.exit(-1);
    }

    /**
     * 消息发送给后端用户
     *
     * @param pid
     * @param msgNo
     * @param message
     */
    public static void sendToPlayer(long pid, int msgNo, com.google.protobuf.MessageLite message) {

        W.getPlayerWork(pid).addTask(new MsgProcess(Message.newBuilder()
                .setMsgNo(msgNo)
                .setBody(message.toByteString()).build(), pid));
    }

    /**
     * 消息发送给后端用户
     *
     * @param pid
     * @param msgNo
     */
    public static void sendToPlayer(long pid, int msgNo) {
        W.getPlayerWork(pid).addTask(new MsgProcess(Message.newBuilder()
                .setMsgNo(msgNo).build(), pid));
    }

    public static void pushToPlayer(long pid, No no, com.google.protobuf.MessageLite message) {
        pushToPlayer(pid, no.getNumber(), message);
    }

    /**
     * 消息发送给前端
     *
     * @param pid
     * @param msgNo
     * @param message
     */
    public static void pushToPlayer(long pid, int msgNo, com.google.protobuf.MessageLite message) {
        P.findPlayer(pid).ifPresent(player -> {
            player.getTransport().send(msgNo, message);
        });
    }

    /**
     * 消息发送给前端
     *
     * @param msgNo
     * @param message
     */
    public static void pushToAllPlayer(int msgNo, com.google.protobuf.MessageLite message) {
        for (Map.Entry<Long, Player> longPlayerEntry : P.allPlayer()) {

            longPlayerEntry.getValue().getTransport().send(msgNo, message);
        }
    }
}
