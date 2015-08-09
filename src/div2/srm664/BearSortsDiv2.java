import java.util.*;
public class BearSortsDiv2{
    int[] a;
    public double getProbability(int[] seq){
        int count = getCount(seq);
        return Math.log(Math.pow(0.5, count));
    }
    
    private int getCount(int[] seq){
        int len = seq.length;
        a = new int[len+1];
        for(int i = 0; i < len; i++){
            a[seq[i]] = i;
        }
        
        int[] nums = new int[len];
        for(int i = 0; i < len; i++){
            nums[i] = i+1;
        }
        return dfs(nums);
    }
    
    private int dfs(int[] nums){
        if(nums.length <=1){
            return 0;
        }
        int len = nums.length;
        int lenL = len/2;
        int[] numsL = Arrays.copyOfRange(nums, 0, lenL);
        int[] numsR = Arrays.copyOfRange(nums, lenL, len);
        int count1= dfs(numsL);
        int count2 = dfs(numsR);
        int count3 = merge(numsL, numsR, nums);
        return count1 + count2 + count3;
    }
    
    private int merge(int[] numsL, int[] numsR, int[] nums){
        int ret = 0;
        int indexL = 0;
        int indexR = 0;
        int index = 0;
        while(indexL < numsL.length && indexR < numsR.length){
            if(a[numsL[indexL]] < a[numsR[indexR]]){
                nums[index++] = numsL[indexL++];
            }else{
                nums[index++] = numsR[indexR++];
            }
            ret++;
        }
        while(indexL < numsL.length){
            nums[index++] = numsL[indexL++];
        }
        while(indexR < numsR.length){
            nums[index++] = numsR[indexR++];
        }
        return ret;
    }   
}