package topcoder2015;

/**
 * Created by Zhenyi Luo on 15-4-25.
 */
public class TheNicePair {
    public static void main(String[] args){
        int[] A = {8,8,5,5,5};
        System.out.println(new TheNicePair().solve(A));
    }
    public int solve(int[] A){
        int ret = -1;
        int max = 0;
        for(int i = 0; i < A.length; i++){
            max = Math.max(max, A[i]);
        }

        for(int i = 0; i < A.length; i++){
            for(int j = i; j < A.length; j++){
                for(int v = 2; v <= max; v++){
                    int count = 0;
                    int len = j-i+1;
                    for(int k = i; k <=j; k++){
                        if(A[k] % v == 0){
                            count++;
                        }
                    }
                    if(count*2 >= len){
                        ret = Math.max(ret, len-1);
                    }
                }
            }
        }

        return ret;
    }
}
