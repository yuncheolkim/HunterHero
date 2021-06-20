package game.module.battle.record;

import game.module.battle.Battle;
import game.module.battle.Hero;
import game.module.battle.Round;
import game.module.battle.Side;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yunzhe.Jin
 * 2021/1/19 14:46
 */
public class BattleRecord {

    private Side winSide;
    private List<Round> roundList;

    private List<HeroRecordData> sideAhero;

    private List<HeroRecordData> sideBhero;

    public BattleRecord() {
    }

    public BattleRecord(Battle battle) {
        sideAhero = battle.getSideAhero().values().stream().map(Hero::record).collect(Collectors.toList());
        sideBhero = battle.getSideBhero().values().stream().map(Hero::record).collect(Collectors.toList());
    }

    public List<Round> getRoundList() {
        return roundList;
    }

    public void setRoundList(List<Round> roundList) {
        this.roundList = roundList;
    }

    public List<HeroRecordData> getSideAhero() {
        return sideAhero;
    }

    public void setSideAhero(List<HeroRecordData> sideAhero) {
        this.sideAhero = sideAhero;
    }

    public List<HeroRecordData> getSideBhero() {
        return sideBhero;
    }

    public void setSideBhero(List<HeroRecordData> sideBhero) {
        this.sideBhero = sideBhero;
    }

    public Side getWinSide() {
        return winSide;
    }

    public void setWinSide(Side winSide) {
        this.winSide = winSide;
    }
}
