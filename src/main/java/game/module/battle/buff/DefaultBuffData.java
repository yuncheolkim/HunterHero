package game.module.battle.buff;

/**
 * @author Yunzhe.Jin
 * 2021/2/3 17:27
 */
public class DefaultBuffData implements IBuffVal {
    private int int1;

    private int int2;

    private int int3;


    private float float1;

    private float float2;


    @Override
    public void merge(IBuffVal from) {
        if (from instanceof DefaultBuffData) {
            DefaultBuffData data = (DefaultBuffData) from;
            int1 += data.int1;
            int2 += data.int2;
            int3 += data.int3;

            float1 += data.float1;
            float2 += data.float2;
        }
    }

    public int getInt1() {
        return int1;
    }

    public void setInt1(int int1) {
        this.int1 = int1;
    }

    public int getInt2() {
        return int2;
    }

    public void setInt2(int int2) {
        this.int2 = int2;
    }

    public int getInt3() {
        return int3;
    }

    public void setInt3(int int3) {
        this.int3 = int3;
    }

    public float getFloat1() {
        return float1;
    }

    public void setFloat1(float float1) {
        this.float1 = float1;
    }

    public float getFloat2() {
        return float2;
    }

    public void setFloat2(float float2) {
        this.float2 = float2;
    }
}
