package div2.srm547;

/**
 * Created by Eric on 15-3-5.
 */
public class RelativelyPrimeSubset {
    public int findSize(int[] S){
        int result = 0;

        int[] primers = new int[15];

        primers[0] = 2;
        int index = 1;
        for(int i =3 ; i < 50; i++){
            boolean flag = true;
            for(int j = 2; j < i && flag ; j ++){
                if(i % j == 0){
                    flag = false;
                }
            }
            if(flag){
              primers[index ++] =i;
            }
        }
        int[] divisors = new int[S.length];
        for(int i = 0; i < S.length; i++){
            for(int j = 0 ; j< 15; j ++){
                if(S[i] % primers[j] == 0){
                    divisors[i] |= 1 << j;
                }
            }
        }

        int N = (int)Math.pow(2, 15);
        int[][] dp = new int[S.length+1][N];

        for(int i =0; i < S.length; i++){
            for(int j = 0; j < N; j++){
                dp[i+1][j] = Math.max(dp[i][j] ,dp[i+1][j]);
                if((j & divisors[i]) == 0){
                    dp[i+1][j|divisors[i]] = Math.max(dp[i+1][j|divisors[i]], dp[i][j]+1);
                }
            }
        }

        for(int i =0 ; i < N ;i++){
            result = Math.max(result, dp[S.length][i]);
        }
        return result;
    }

}
