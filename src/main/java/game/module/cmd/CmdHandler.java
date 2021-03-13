package game.module.cmd;

import game.player.Player;
import game.proto.CmdReq;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 测试用命令
 *
 * @author Yunzhe.Jin
 * 2021/3/10 22:45
 */
public class CmdHandler {


    public static void cmd(Player player, CmdReq req) {
        List<String> s = Arrays.stream(StringUtils.split(req.getParams(), " ")).map(s1 -> s1.trim()).collect(Collectors.toList());
        Cmd cmd = Cmd.findById(Integer.parseInt(s.remove(0)));
        cmd.run(player, s);
    }
}
