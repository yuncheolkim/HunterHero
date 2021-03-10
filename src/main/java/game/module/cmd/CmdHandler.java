package game.module.cmd;

import cn.hutool.core.collection.ListUtil;
import game.player.Player;
import game.proto.CmdReq;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

/**
 * 测试用命令
 *
 * @author Yunzhe.Jin
 * 2021/3/10 22:45
 */
public class CmdHandler {


    public static void cmd(Player player, CmdReq req) {
        ArrayList<String> s = ListUtil.toList(StringUtils.split(req.getParams(), " "));
        Cmd cmd = Cmd.findById(Integer.parseInt(s.remove(0)));
        cmd.run(player, s);
    }
}
