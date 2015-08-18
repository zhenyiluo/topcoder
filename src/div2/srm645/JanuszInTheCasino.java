import java.util.HashMap;

class Pair{
        long n;
        int k;
        public Pair(long n, int k){
            this.n = n; 
            this.k = k;
        }
        @Override
        public boolean equals(Object o){
            if(o == null)                return false;
            if(!(o instanceof Pair)) return false;

            Pair other = (Pair) o;
            return this.n == other.n && this.k == other.k;
        }
        
        @Override
        public int hashCode(){
            return (int)n + k;
        }
    }
public class JanuszInTheCasino {
    
    HashMap<Pair, Double> hm = new HashMap<Pair, Double>();
    public double findProbability(long n, int m, int k){
        Pair pair = new Pair(n, k);
        if(hm.containsKey(pair)){
            return hm.get(pair);
        }
        
        if(n == 0){
            hm.put(pair, (double)0);
            return 0;
        }
        
        if(m == 1){
            hm.put(pair, (double)1);
            return 1;
        }
        
        if(k == 1){
            if(n >= 2){
                hm.put(pair, (double)1);
                return 1;
            }else{
                hm.put(pair, (double)(m-n)/m);
                return (double)(m-n)/m;
            }
        }
        
        double p1 = (double) (m - n % m) / m;
        double p2 = (double) (n % m) / m;
        
        double ret = p1 * findProbability(n - n/m, m, k-1) + p2 * findProbability(n - (n/m + 1), m, k-1);
        hm.put(pair, ret);
        return ret;
    }
}
