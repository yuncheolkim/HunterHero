package game.config.box;

import game.config.base.MapConfigDataBox;
import game.config.data.HomeRecipeConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class HomeRecipeDataBox extends MapConfigDataBox<HomeRecipeConfigData> {


    public HomeRecipeDataBox() {
        super("data/home_recipe.json");
    }
}
