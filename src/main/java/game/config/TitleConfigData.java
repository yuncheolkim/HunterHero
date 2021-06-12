package game.config;

import game.config.base.BaseConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class TitleConfigData extends BaseConfigData<TitleConfigData> {

    public String content;

    @Override
    public TitleConfigData convert(final DataConfigData data) {
        final TitleConfigData convert = super.convert(data);
        content = data.s1;
        return convert;
    }
}
