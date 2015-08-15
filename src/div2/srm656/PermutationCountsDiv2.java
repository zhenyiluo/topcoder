import java.util.*;

public class PermutationCountsDiv2 {
    public static final int MOD = (int) (1e9 + 7);
    public int countPermutations(int N, int[] pos){
        boolean[] mark = new boolean[N];
        for(int n: pos){
            mark[n-1] = true; 
        }
        
        long[][] dp = new long[N+1][N+1];
        for(int i = 0; i <= N; i++){
            dp[i][i] = 1;
            if(i < N){
                dp[i][i+1] = 1;
            }
        }
        
        long[][] c = new long[N+1][N+1];
        for(int i = 0; i <= N; i++){
            c[i][0] = 1;
            for(int j = 1; j <= i; j++){
                c[i][j] = (c[i-1][j-1] + c[i-1][j]) % MOD;
            }
        }
        
        for(int t = 2; t <=N; t++){
            for(int a = 0; a + t <= N; a++){
                int b = a+ t;
                dp[a][b] = 0;
                for(int i = a; i < b; i++){
                    if((mark[i] || i == b-1)&&(i == a || !mark[i-1])){
                        long p = dp[a][i];
                        long q = dp[i+1][b];
                        dp[a][b] += (c[t-1][i-a] *((p * q) % MOD) ) % MOD; 
                    }
                }
                dp[a][b] %= MOD;
            }
        }
        
        return (int) dp[0][N]; 
    }
}
