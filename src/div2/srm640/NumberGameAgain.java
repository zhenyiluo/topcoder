package div2.srm640;

import java.util.Arrays;

/**
 * Created by Eric on 15-3-3.
 */
public class NumberGameAgain {
    public static void main(String[] args){
        long[] a = {2, 4, 6};
        System.out.println(new NumberGameAgain().solve(3, a));
    }
    public long solve(int k, long[] table) {
        long result = (long) Math.pow(2, k) -2;

        int len = table.length;

        boolean[] flag = new boolean[len];

        Arrays.sort(table);

        for(int i = 0; i < len-1; i++){
            for(int j = i+1; j < len; j++){
                if(checkParent(table[i], table[j])){
                    flag[j] = true;
                }
            }
        }

        for(int i = 0; i < len; i++){
            if(!flag[i]){
                result -= getSubTreeSize(table[i], k);
            }
        }

        return result;
    }

    public long getSubTreeSize(long x, int k){
        int height = 0;
        while(x != 1){
            x /= 2;
            height ++;
        }
        return (long) Math.pow(2, k - height) -1 ;
    }

    public boolean checkParent(long x , long y){
        while(y > x){
            y /= 2;
        }
        return x == y;
    }
}
