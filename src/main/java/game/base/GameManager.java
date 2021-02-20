package game.base;

import game.module.player.LoginHandler;
import game.msg.IMsgHandler;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 14:28
 */
public class GameManager extends AbsLifecycle {

    private ConcurrentHashMap<Integer, IMsgHandler<?>> handler = new ConcurrentHashMap<>();

    private LoginHandler loginHandler = new LoginHandler();

    public <T> IMsgHandler<T> getHandler(Integer msgNo) {
        return (IMsgHandler<T>) handler.get(msgNo);
    }

    public LoginHandler getLoginHandler() {
        return loginHandler;
    }

    @Override
    public void start() {


        super.start();
    }
}
