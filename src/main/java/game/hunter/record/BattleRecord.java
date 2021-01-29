package game.hunter.record;

import game.hunter.Battle;
import game.hunter.Hero;
import game.hunter.Round;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yunzhe.Jin
 * 2021/1/19 14:46
 */
public class BattleRecord {

    private List<Round> roundList;

    private List<HeroRecordData> sideAhero;

    private List<HeroRecordData> sideBhero;

    public BattleRecord() {
    }

    public BattleRecord(Battle battle) {
        sideAhero = battle.getSideAhero().stream().map(Hero::record).collect(Collectors.toList());
        sideBhero = battle.getSideBhero().stream().map(Hero::record).collect(Collectors.toList());
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
}
