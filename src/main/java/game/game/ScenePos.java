package game.game;

import com.fasterxml.jackson.annotation.JsonProperty;
import game.base.Copy;

public class ScenePos implements Copy {
    @JsonProperty
    public float x;
    @JsonProperty
    public float y;

    public ScenePos() {
    }

    public ScenePos(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public ScenePos copy(){
        return new ScenePos(x,y);
    }
}
