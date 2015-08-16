import java.util.*;

public class SingingEasy {
    int n;
    int[] pitch;
    int[][] dp;
    public int solve(int[] pitch){
        n = pitch.length;
        this.pitch = pitch;
        dp = new int[n+1][n+1];
        for(int i = 0; i <=n; i++){
            for(int j = 0; j <= n; j++){
                dp[i][j] = -1;
            }
        }
        return f(1, n);
    }
    
    private int f(int p, int lastB){
        if(dp[p][lastB] == -1){
            if(p >= n){
                dp[p][lastB] = 0;
            }else{
                dp[p][lastB] = Math.abs(pitch[p] - pitch[p-1]) + f(p+1, lastB);
                int tmp;
                if(lastB == n){
                    tmp = f(p+1, p-1);
                }else{
                    tmp = Math.abs(pitch[p] - pitch[lastB]) + f(p+1, p-1);
                }
                
                dp[p][lastB] = Math.min(dp[p][lastB], tmp);
            }
            
        }
        return dp[p][lastB];
    }
}
