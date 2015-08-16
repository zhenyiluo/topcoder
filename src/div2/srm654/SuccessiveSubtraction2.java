import java.util.*;

public class SuccessiveSubtraction2 {
    int[] a;
    int n;
    int[][][] dp;
    public static final int INF = (int)(1e9);
    public int[] calc(int[] a, int[] p, int[] v){
        this.a = a;
        this.n = a.length;
        int size = p.length;
        int[] ret = new int[size];
        for(int i = 0; i < size; i++){
            a[p[i]] = v[i];
            ret[i] = solve();
        }
        return ret;
    }
    
    private int solve(){
        dp = new int[n+1][3][3];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    dp[i][j][k] = -INF;
                }
            }
        }
        return a[0] + f(1, 0, 2);
    }
    
    private int f(int p, int open, int remains){
        if(dp[p][open][remains] == -INF){
            if(p == n){
                dp[p][open][remains] = 0;
            }else{
                int x = a[p];
                if(open % 2 == 0){
                    x = -x;
                }
                
                if(remains > 0){
                   dp[p][open][remains] = Math.max(dp[p][open][remains], x + f(p+1, open+1, remains-1));
                }
                
                if(open > 0){
                   dp[p][open][remains] = Math.max(dp[p][open][remains], x + f(p+1, open-1, remains)); 
                }
                
                dp[p][open][remains] = Math.max(dp[p][open][remains], x + f(p+1, open, remains));
            }
        }
        
        return dp[p][open][remains];
    }
}
