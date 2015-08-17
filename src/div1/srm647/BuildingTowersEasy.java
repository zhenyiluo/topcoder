import java.util.*;
public class BuildingTowersEasy {
    public int maxHeight(int N, int[] x, int[] t){
        int ret = 0;
        
        ArrayList<Integer> xx = new ArrayList<Integer>();
        ArrayList<Integer> yy = new ArrayList<Integer>();
        xx.add(0);
        yy.add(1);
        for(int i = 0; i < x.length; i++){
            xx.add(x[i]);
            yy.add(t[i]);
        }
        
        for(int i = 0; i < N; i++){
            int top = 100000;
            for(int j = 0; j < xx.size(); j++){
                top = Math.min(top, yy.get(j) + Math.abs(xx.get(j) - i));
            }
            ret = Math.max(ret, top);
        }
        return ret;
    }
}
