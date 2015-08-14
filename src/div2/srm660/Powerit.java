import java.util.*;

public class Powerit {
    public int calc(int n, int k, int m){
        int[] firstFactor = new int[n+1];
        firstFactor[1] = 1;
        for(int i = 2; i <=n; i++){
            if(firstFactor[i] == 0){
                firstFactor[i] = i;
            }else{
                for(int j = i+i; j <= n; j += i){
                    firstFactor[j] = i;
                }
            }
        }
        long[] dp = new long[n+1];
        long sum = 0;
        for(int i = 1; i <= n; i++){
            if(firstFactor[i] == i){
                dp[i] = getIth(i, k, m);
            }else{
                dp[i] = (dp[firstFactor[i]] * dp[i/firstFactor[i]]) % m;
            }
            sum += dp[i] % m;
            sum = sum % m;
        }
        return (int) sum;
    }
    
    private long getIth(int i, int k , int m){
        long p = i;
        long q = p;
        for(int j = 1; j < k; j++){
            q = (q * q) % m;
            p = (p * q) % m;
        }
        return p;
    }
}
