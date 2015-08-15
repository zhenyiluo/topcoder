import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-17.
 */
public class MutaliskEasy {
    public static final int INF = (int)(1e9+10);
    int attacks[][] = {{1, 3, 9},{1, 9, 3}, {3, 1, 9}, {3, 9, 1}, {9, 1, 3}, {9, 3, 1}};
    public int minimalAttacks(int[] x){
        int a = x[0];
        int b = 0;
        int c = 0;
        if(x.length >= 2){
            b = x[1];
        }
        if(x.length == 3){
            c = x[2];
        }

        int[][][] dp = new int[a+10][b+10][c+10];
        for(int i = 0; i <= a; i++ ){
            for(int j = 0; j<= b; j++){
                for(int k = 0; k <= c; k++){
                    dp[i][j][k] = INF;
                }
            }
        }
        dp[0][0][0] = 0;
        for(int i = 0; i <= a; i++ ){
            for(int j = 0; j<= b; j++){
                for(int k = 0; k <= c; k++){
                    if(i == 0 && j == 0 && k == 0){
                        continue;
                    }
                    for(int n = 0; n < 6; n++){
                        int nx = Math.max(0, i - attacks[n][0]);
                        int ny = Math.max(0, j - attacks[n][1]);
                        int nz = Math.max(0, k - attacks[n][2]);
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[nx][ny][nz] + 1);
                    }
                }
            }
        }
        return dp[a][b][c];
    }

    public static void main(String[] args){
        int[] x = {28};
        System.out.println(new MutaliskEasy().minimalAttacks(x));
    }
}