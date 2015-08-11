import java.util.*;

public class AlternateColors {
	public final String[] ss = {"RED", "GREEN", "BLUE"};
    public String getColor(long r, long g, long b, long k){
        ArrayList<Long> list = new ArrayList<Long>();
        list.add(r);
        list.add(g);
        list.add(b);
        while(true){
            Long min = Long.MAX_VALUE;
            for(long l : list){
                min = Math.min(l, min);
            }
            if(min * 3 < k){
                k -= min *3;
            }else{
                return ss[(int)((k-1) % 3)];
            }
            ArrayList<Long> tmp = list;
            list = new ArrayList<Long>();
            for(long l : tmp){
                l -= min;
                if(l != 0){
                    list.add(l);
                }
            }
        }
    }
}
