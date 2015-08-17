import java.util.*;
public class CartInSupermarketEasy {
    int[][] dp;
    public int calc(int N, int K){
        dp = new int[N+1][K+1];
        
        for(int[] x : dp){
            Arrays.fill(x, -1);
        }
        
        return f(N, K);
    }
    
    private int f(int n, int k){
        if(dp[n][k] == -1){
            if(n == 0){
                return dp[n][k] = 0;
            }
            int result = 1 + f(n-1, k);
            
            if(k > 0){
                for(int x = 1; x <= n-1; x++){
                    for(int y = 0; y <= k-1; y++){
                        result = Math.min(result, Math.max(f(x,y), f(n-x, k-1-y)) + 1);
                    }
                }
            }
            dp[n][k] = result;
        }
        
        return dp[n][k];
    }
}
