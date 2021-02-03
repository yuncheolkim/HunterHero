package game.hunter.buff;

/**
 * @author Yunzhe.Jin
 * 2021/2/3 17:27
 */
public class DefaultBuffData implements IBuffVal {
    private int int1;

    private int int2;

    private int int3;

    private int int4;

    private int int5;

    private float float1;

    private float float2;

    private float float3;

    private float float4;

    private float float5;

    @Override
    public void merge(IBuffVal from) {
        if (from instanceof DefaultBuffData) {
            DefaultBuffData data = (DefaultBuffData) from;
            int1 += data.int1;
            int2 += data.int2;
            int3 += data.int3;
            int4 += data.int4;
            int5 += data.int5;

            float1 += data.float1;
            float2 += data.float2;
            float3 += data.float3;
            float4 += data.float4;
            float5 += data.float5;
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

    public int getInt4() {
        return int4;
    }

    public void setInt4(int int4) {
        this.int4 = int4;
    }

    public int getInt5() {
        return int5;
    }

    public void setInt5(int int5) {
        this.int5 = int5;
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

    public float getFloat3() {
        return float3;
    }

    public void setFloat3(float float3) {
        this.float3 = float3;
    }

    public float getFloat4() {
        return float4;
    }

    public void setFloat4(float float4) {
        this.float4 = float4;
    }

    public float getFloat5() {
        return float5;
    }

    public void setFloat5(float float5) {
        this.float5 = float5;
    }
}
