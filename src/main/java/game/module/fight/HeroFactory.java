package game.module.fight;

import game.base.G;
import game.module.battle.Hero;
import game.module.battle.HeroData;
import game.module.battle.hero.Guanyu;
import game.module.battle.hero.creature.CreatureTarget;
import game.player.Player;
import game.proto.data.FightEnemyInfo;
import game.proto.data.PlayerHero;
import game.proto.data.Property;

/**
 * @author Yunzhe.Jin
 * 2021/3/4 10:21
 */
public class HeroFactory {

    public static Hero createPlayerHero(Player player, PlayerHero playerHero) {
        Hero hero = null;
        int heroId = playerHero.getId();
        switch (heroId) {
            case 1001: {
                hero = new Guanyu();
                break;
            }
        }

        if (hero != null) {
            hero.setId(heroId);
            hero.setLevel(playerHero.getLevel());
            hero.setName(G.C.dataMap1.get(heroId).name);
            // property data
            HeroData data = makeData(playerHero.getProperty());

            hero.origin = data;
            hero.heroStats.hp = data.getMaxHp();

        }

        return hero;
    }

    private static HeroData makeData(Property property) {
        HeroData data = new HeroData();
        data.setMaxHp(property.getHp());
        data.setDef(property.getDef());
        data.setDamage(property.getDamage());
        data.setAvoid(property.getAvoid());
        data.setCritical(property.getCritical());
        data.setCriticalDamageRate(property.getCriticalDamage());
        data.setSpeed(property.getSpeed());
        data.setAvoidBase(property.getAvoidBase());
        data.setCriticalBase(property.getCriticalBase());
        data.setDefBase(property.getDefBase());
        return data;
    }

    public static CreatureTarget createFightEnemy(FightEnemyInfo info) {

        CreatureTarget target = new CreatureTarget();
        target.setId(info.getId());
        target.setName(info.getName());
        target.setLevel(info.getLevel());
        HeroData data = makeData(info.getProperty());
        target.origin = data;
        target.heroStats.hp = data.getMaxHp();

        return target;
    }


}
