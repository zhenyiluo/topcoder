import java.util.*;

public class ColorfulLineGraphsDiv2 {
    int N; 
    int K;
    public static final int INF = (int)(1e9 + 7);
    int[][][] dp = new int[101][101][101];
    public int countWays(int N, int K){
        this.N = N;
        this.K = K;
        return f(0, 0, 0);
    }
    
    private int f(int a , int b, int c){
        if(dp[a][b][c] == 0){
            if(a + b + c == N){
                dp[a][b][c] = 1;
            }else{
                long ret = 0;
                long p = (1 + b + c);
                long q = f(a + 1, b, c);
                ret += (int) (p * q % INF);
                ret = ret % INF;
                
                if(K >= 2){
                    p = (1 + a + c);
                    q = f(a, b+1, c);
                    ret += (int) (p * q % INF);
                    ret = ret % INF;
                }
                
                if(K >= 3){
                    p = (1 + a + b);
                    q = f(a, b, c+1);
                    ret += (int) (p * q % INF);
                    ret = ret % INF;
                }
                dp[a][b][c] = (int)ret;
            }
        }
        return dp[a][b][c];
    }
}
