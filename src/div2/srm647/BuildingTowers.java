import java.util.*;
class Pair{
    int first; 
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
public class BuildingTowers {
    private boolean check(int N, int K , int[] x, int[] t, long H){
        ArrayList<Pair> list = new ArrayList<Pair>();
        list.add(new Pair(1, 1));
        list.add(new Pair(N+1, -1));
        
        for(int i = 0; i < x.length; i++){
        	if(t[i] < H){
        		long r = (H - t[i] - 1) / K;
            	int L = (int)Math.max(x[i] - r, 1);
            	int R = (int)Math.min(x[i] + r + 1, N+1);
            	list.add(new Pair(L, -1));
            	list.add(new Pair(R, 1));
        	}
        }
        
        Collections.sort(list, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                if(p1.first != p2.first){
                    return p1.first - p2.first;
                }
                
                return p1.second - p2.second;
            }
        });
        
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i).second;
            if(sum > 0){
                return true;
            }
        }
        return false;
    }
    
    public long maxHeight(int N, int K, int[] x, int[] t){
        long low = 0; 
        long high = ((long)1) << 60;
        int xx[] = new int[x.length+1];
        int tt[] = new int[t.length+1];
        for(int i = 0; i < x.length; i++){
        	xx[i] = x[i];
        	tt[i] = t[i];
        }
        xx[x.length] = 1;
        tt[t.length] = 0;
        while(low < high-1){
            long mid = low + ((high - low) >> 1);
            if(check(N, K, xx, tt, mid)){
                low = mid;
            }else{
                high = mid;
            }
        }
        return low;
    }
}
