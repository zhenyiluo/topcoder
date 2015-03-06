package div2.srm547;

/**
 * Created by Eric on 15-3-5.
 */
public class PillarsDivTwo {
    public double maximalLength(int[] height, int w){
        double result = 0;

        double[][] dp = new double[height.length][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for(int i = 1; i < height.length; i++){
            for(int j = 0; j < 2; j++){
                dp[i][j] = -1;
                for(int k = 0; k < 2; k++){
                    dp[i][j] = Math.max(dp[i-1][k] + len(k ==0? 1: height[i-1], j == 0? 1: height[i], w), dp[i][j]);
                }
            }
        }
        result = Math.max(dp[height.length-1][0], dp[height.length-1][1]);
        return result;
    }
    public double len(int height1, int height2, int w){
        return Math.sqrt(w * w + (height1 -height2) * (height1 - height2));
    }
}
