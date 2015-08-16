import java.util.*;

public class ThePermutationGameDiv2 {
    public long findMin(int N){
        if(N == 1){
            return 1;
        }
        
        long ret = 1;
        
        for(int i = 2; i <= N; i++){
            ret = (ret * i) / gcd(i, ret);
        }
        
        return ret;
    }
    
    private long gcd(long a, long b){
        if( b== 0){
            return a;
        }
        return gcd(b, a % b);
    }
}
