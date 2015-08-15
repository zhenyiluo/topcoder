import java.util.*;

public class FoldingPaper2 {
    public int solve(int W, int H, int A){
        if (W > H){
            return solve(H, W, A);
        }
        if(W * H < A){
            return -1;
        }
        int first = -1;
        for(int i = Math.min((int) Math.sqrt(A), W); i >= 1; i--){
            if(A % i == 0){
                first = i;
                break;
            }
        }
        int second = A / first;
        if(second > H){
            return -1;
        }
        
        int ret = 0;
        while(W > first){
            ret ++;
            first *= 2;
        }
        
        while(H > second){
            ret ++;
            second *= 2;
        }
        return ret;
    }
}
