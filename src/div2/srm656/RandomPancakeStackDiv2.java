import java.util.*;

public class RandomPancakeStackDiv2 {
    int n;
    double ret;
    boolean[] taken;
    public double expectedDeliciousness(int[] d){
        n = d.length;
        ret = 0;
        int remaining = n;
        taken = new boolean[n];
        dfs(d, remaining, taken, 1, 0, Integer.MAX_VALUE);
        return ret;
    }
    
    private void dfs(int[] d, int remaining, boolean[] taken, double p, int sum, int base){
        if(remaining == 0){
            ret += p * sum;
        }
        p *= 1.0 / remaining;
        for(int i = 0; i < n; i++){
            if(taken[i]){
                continue;
            }
            
            if(i < base){
                taken[i] = true;
                
                dfs(d, remaining-1, taken, p, sum + d[i], i);
                
                taken[i] = false;
            }else{
                ret += p * sum;
            }
        }
    }
}
