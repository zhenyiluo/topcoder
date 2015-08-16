
public class NineEasy {
    int N;
    int[] d;
    public static final int SIZE = 9*9*9*9*9;
    public static final int MOD = (int)(1e9 + 7);
    long[][] dp = new long[SIZE][21];
    int[] pow = new int[6];
    
    public static void main(String[] args){
        int N = 2;
        int[] d = new int[]{1, 2};
        System.out.println(new NineEasy().count(N, d));
    }
    
    public int count(int N, int[] d){
        this.N = N; 
        this.d = d;
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < 21; j++){
                dp[i][j] = -1;
            }
        }
        pow[0] = 1;
        for(int i = 1; i <= N; i++){
            pow[i] = 9 * pow[i-1];
        }
        return (int) f(0, 0);
    }
    
    private long f(int mask, int digit){
        if(dp[mask][digit] == -1){
            dp[mask][digit] = 0;
            if(digit == d.length){
                if(mask == 0){
                    dp[mask][digit] = 1;
                    return dp[mask][digit];
                }
            }else{
                for(int i = 0; i<=9; i++){
                    int newMask = 0;
                    for(int j = N-1; j>= 0; j--){
                        int remains = (mask / pow[j]) % 9;
                        if((d[digit] & (1 << j)) != 0){
                            remains = (remains + i) % 9;
                        }
                        newMask = newMask * 9 + remains;
                    }
                    dp[mask][digit] += f(newMask, digit+1);
                }
                dp[mask][digit] %= MOD;
            }
        }
        
        return dp[mask][digit];
    }
}
