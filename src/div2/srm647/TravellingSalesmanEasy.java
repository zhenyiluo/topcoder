import java.util.*;
public class TravellingSalesmanEasy {
    public int getMaxProfit(int M, int[] profit, int[] city, int[] visit){
        int ret = 0;
        
        PriorityQueue<Integer>[] pqs = new PriorityQueue[M+1];
        int n = profit.length;
        for(int i = 1; i <= M; i++){
            pqs[i] = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
                @Override
                public int compare(Integer i1, Integer i2){
                    return i2 - i1;
                }
            });
        }
        
        for(int i = 0; i < n; i++){
            pqs[city[i]].add(profit[i]);
        }
        
        int m = visit.length;
        for(int i = 0; i< m; i++){
            if(!pqs[visit[i]].isEmpty()){
                ret += pqs[visit[i]].poll();
            }
        }
        
        return ret;
    }
}
