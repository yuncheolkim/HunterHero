package game.module.scene;

import com.fasterxml.jackson.annotation.JsonProperty;
import game.base.Copy;
import game.game.ScenePos;

public class SceneData implements Copy {
    @JsonProperty
    public int id;

    @JsonProperty
    public ScenePos scenePos;

    public SceneData copy() {
        SceneData sceneData = new SceneData();
        sceneData.id = id;
        sceneData.scenePos = scenePos.copy();
        return sceneData;
    }
}
