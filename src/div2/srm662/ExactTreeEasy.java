import java.util.*;


public class ExactTreeEasy {
    public int[] getTree(int n, int m){
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int count = 1;
        ret.add(0);
        ret.add(1);
        int total = 2;
        boolean flag = true;
        int first = 1;
        int second = 2;
        while(total != 2 * (n-1)){
                ret.add(first);
                ret.add(second);
                total += 2;
                count++;
                if(count < m){
                    second++;
                }else{
                    first++;
                    second++;
                }
        }
        
        
        int[] result = new int[ret.size()];
        for(int i = 0; i < ret.size(); i++){
            result[i] = ret.get(i);
        }
        return result;
    }
}