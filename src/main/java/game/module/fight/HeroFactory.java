package game.module.fight;

import game.base.G;
import game.module.battle.Hero;
import game.module.battle.HeroData;
import game.module.battle.hero.Guanyu;
import game.player.Player;
import game.proto.data.PlayerHero;

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
            // property data
            HeroData data = new HeroData();
            data.setMaxHp(playerHero.getProperty().getHp());
            data.setDef(playerHero.getProperty().getDef());
            data.setDamage(playerHero.getProperty().getDamage());
            data.setAvoid(playerHero.getProperty().getAvoid());
            data.setCritical(playerHero.getProperty().getCritical());
            data.setCriticalDamageRate(playerHero.getProperty().getCriticalDamage());
            data.setSpeed(playerHero.getProperty().getSpeed());
            data.setAvoidBase(playerHero.getProperty().getAvoidBase());
            data.setCriticalBase(playerHero.getProperty().getCriticalBase());
            data.setDefBase(playerHero.getProperty().getDefBase());

            hero.setName(G.C.heroMap1001.get(heroId).name);
            hero.origin = data;
            hero.heroStats.hp = data.getMaxHp();

        }

        return hero;
    }
}
