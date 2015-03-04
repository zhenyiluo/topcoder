package div2.srm640;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Eric on 15-3-3.
 */
public class TwoNumberGroupsEasy {

    public static void main (String[] args){
        System.out.println(new TwoNumberGroupsEasy().solve(new int[]{5, 7}, new int[]{1, 1}, new int[]{12, 14}, new int[]{1,1}));
    }
    public int solve(int[] A, int[] numA, int[] B, int[] numB){
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(2);
        for(int a : A){
            for(int b: B){
                int num = Math.abs(a-b);
                if(num > 1) {
                    hs.add(num);
                }
                for(int i = 2; i <= (int)Math.sqrt(num); i++){
                    if(num % i == 0){
                        hs.add(i);
                        hs.add(num/i);
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;

        for(int n : hs){
            HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
            for(int i = 0; i < A.length; i++){
                int tmp = A[i] % n;
                if(hm.containsKey(tmp)){
                    hm.put(tmp, hm.get(tmp) + numA[i]);
                }else{
                    hm.put(tmp, numA[i]);
                }
            }

            for(int i = 0; i < B.length; i++){
                int tmp = B[i] % n;
                if(hm.containsKey(tmp)){
                    hm.put(tmp, hm.get(tmp) - numB[i]);
                }else{
                    hm.put(tmp, -numB[i]);
                }
            }

            int sum = 0;
            for(int key : hm.keySet()){
                sum += Math.abs(hm.get(key));
            }
            result = Math.min(result, sum);
        }

        return result;
    }
}
