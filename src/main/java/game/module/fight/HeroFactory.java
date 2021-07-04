package game.module.fight;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.HeroData;
import game.module.battle.hero.*;
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

    public static Hero createPlayerHero(final Player player, final PlayerHero playerHero) {
        Hero hero = null;
        final int heroId = playerHero.getId();
        switch (heroId) {
            case 1001: {
                hero = new Guanyu();
                break;
            }
            case 1002: {
                hero = new Huangzhong();
                break;
            }
            case 1003: {
                hero = new ZhaoYun();
                break;
            }
            case 1004: {
                hero = new WeiYan();
                break;
            }
            case 1005: {
                hero = new Machao();
                break;
            }
            case 1006: {
                hero = new Lusu();
                break;
            }
            case 1007: {
                hero = new XiaHouDun();
                break;
            }
            case 1008: {
                hero = new ZhouYu();
                break;
            }
            case 1009: {
                hero = new ZhuGeLiang();
                break;
            }
            case 1010: {
                hero = new DaQiao();
                break;
            }
            case 1011: {
                hero = new DianWei();
                break;
            }
            case 1012: {
                hero = new JiangWei();
                break;
            }

        }

        assert hero != null;
        hero.setId(heroId);
        hero.setLevel(playerHero.getLevel());
        hero.setName(ConfigManager.getHeroName(heroId));
        hero.setTalentInfo(playerHero.getTalent());
        // property data
        final HeroData data = makeData(playerHero.getProperty());

        hero.origin = data;
        hero.heroStats.hp = data.getMaxHp();

        return hero;
    }

    private static HeroData makeData(final Property property) {
        final HeroData data = new HeroData();
        data.setMaxHp(property.getHp());
        data.setDef(property.getDef());
        data.setDamage(property.getDamage());
        data.setAvoid(property.getAvoid());
        data.setCritical(property.getCritical());
        data.setCriticalDamageRate(property.getCriticalDamage());
        data.setAvoidBase(property.getAvoidBase());
        data.setCriticalBase(property.getCriticalBase());
        data.setDefBase(property.getDefBase());
        return data;
    }

    public static CreatureTarget createFightEnemy(final FightEnemyInfo info) {

        final CreatureTarget target = new CreatureTarget();
        target.setId(info.getId());
        target.setName(info.getName());
        target.setLevel(info.getLevel());
        final HeroData data = makeData(info.getProperty());
        target.origin = data;
        target.heroStats.hp = data.getMaxHp();

        return target;
    }


}
