package game.config;

/**
 * @author Yunzhe.Jin
 * 2021/5/25 10:27
 */
public class TransformConfigData extends BaseConfigData<TransformConfigData> {
    public int sceneId;

    @Override
    public TransformConfigData convert(DataConfigData data) {
        TransformConfigData convert = super.convert(data);
        convert.sceneId = data.i1;
        return convert;
    }
}
