package game.module.ladder;

/**
 * @author Yunzhe.Jin
 * 2021/8/25 22:25
 */
public class LadderService {


    /**
     * A 获胜
     *
     * @param rateA
     * @param rateB
     * @param k     分数基数
     * @return 分数变化值
     */
    public static int calcScoreWinA(int rateA, int rateB, int k) {
        LadderScoreData d = new LadderScoreData();

        double a = 1.0 / (1 + Math.pow(10, (rateB - rateA) / 400.0));

        return (int) (k * (1 - a));
    }

    private static double winChance(double diff) {
        return 1.0 / (1 + Math.pow(10, diff / 400.0));
    }


    /**
     * B 获胜
     *
     * @param rateA
     * @param rateB
     * @param k
     * @return
     */
    public static int calcScoreWinB(int rateA, int rateB, int k) {
        LadderScoreData d = new LadderScoreData();

        double a = 1.0 / (1 + Math.pow(10, (rateB - rateA) / 400.0));

        return (int) (k * a);

    }

//    public static int find(int rate, double winChance) {
//
//    }

    public static void main(String[] args) {

        for (int i = 0; i < 400; i += 20) {

            System.out.println(i + " : " + winChance(-1 * i));

        }


    }
}
