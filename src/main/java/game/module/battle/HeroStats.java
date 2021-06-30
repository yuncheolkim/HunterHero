package game.module.battle;

import game.base.Logs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 英雄变化的数据
 */
public class HeroStats {
    /**
     * 血量
     */
    public int hp;

    /**
     * 怒气
     */
    public int angry;

    /**
     * 能否行动
     */
    public boolean active = true;

    /**
     * 护盾
     */
    private int shield;

    /**
     * 影响护盾列表
     */
    private List<ShieldInfo> shieldInfoList = new ArrayList<>(2);

    /**
     * 增加护盾
     *
     * @param info
     */
    public void addShield(final ShieldInfo info) {
        shield += info.count;
        int i = 0;
        ShieldInfo old = null;

        for (int i1 = 0; i1 < shieldInfoList.size(); i1++) {
            i = i1;
            final ShieldInfo s = shieldInfoList.get(i1);

            if (s.round == info.round) {
                old = s;
                break;
            } else if (s.round > info.round) {
                break;
            }
        }
        if (old != null) {
            old.count += info.count;
        } else {
            shieldInfoList.add(i, info);
        }
    }


    /**
     * 减少护盾
     *
     * @param count 减少的护盾量
     */
    public int reduceShield(final int count) {

        if (count >= shield) {
            shield = 0;
            shieldInfoList.clear();
            return count;
        }
        int remain = count;
        final Iterator<ShieldInfo> iterator = shieldInfoList.iterator();
        while (iterator.hasNext()) {
            final ShieldInfo next = iterator.next();
            final int reduce = Math.min(next.count, remain);
            next.count -= reduce;
            shield -= reduce;
            remain -= reduce;
            if (next.count == 0) {
                iterator.remove();
            }
            if (remain == 0) {
                break;
            }
        }

        return count - remain;
    }

    /**
     * 减少回合数
     */
    public void roundShield() {
        final Iterator<ShieldInfo> iterator = shieldInfoList.iterator();
        while (iterator.hasNext()) {
            final ShieldInfo next = iterator.next();
            if (--next.round == 0) {
                shield = Math.max(0, shield - next.count);

                Logs.trace("移除护盾", shield, next.count);
                iterator.remove();
            }
        }
    }


    public int getShield() {
        return shield;
    }
}
