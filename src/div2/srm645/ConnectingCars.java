import java.util.*;
public class ConnectingCars {
    static class Pair{
        int position;
        int length;
        public Pair(int position, int length){
            this.position = position;
            this.length = length;
        }
    }
    Pair[] pairs;
    public long minimizeCost(int[] positions, int[] lengths){
        long totalLength = 0;
        for(int n : lengths){
            totalLength += n;
        }
        int len = positions.length;
        pairs = new Pair[len];
        for(int i = 0; i < len; i++){
            pairs[i] = new Pair(positions[i], lengths[i]);
        }
        Arrays.sort(pairs, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return p1.position - p2.position;
            }
        });
                    
        int low = pairs[0].position;
        int high = pairs[pairs.length-1].position;
        int mid = 0;
        while(low < high -1){
            mid = low + ((high - low) >> 1);
            if(f(mid) > f(mid + 1)){
                low = mid +1;
            }else if(f(mid) < f(mid+1)){
                high = mid -1;
            }else{
                break;
            }
        }
        return f(mid);            
    }
    
    private long f(int pos){
        long cost = 0;
        for(Pair pair : pairs){
            cost += Math.abs(pos - pair.position);
            pos += pair.length;
        }
        return cost;
    }
}
