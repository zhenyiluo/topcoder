import java.util.*;
public class XorSequenceEasy {
    public int getmax(int[] A, int N){
        int bitNum = Integer.bitCount(N-1);
        int[][] profits = new int[bitNum][2];
        int ret = 0;
        int n = A.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = bitNum-1; k >= 0; k--){
                    if((A[i] >> k & 1) != (A[j] >> k & 1) ){
                        profits[k][A[i] >> k & 1]++;
                    }
                }
            }
        }
        
        for(int i = 0; i < bitNum; i++){
            ret += Math.max(profits[i][0], profits[i][1]);
        }
        
        return ret;
    }
}
