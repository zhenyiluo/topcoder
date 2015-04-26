package div2.srm653;

/**
 * Created by Eric on 15-3-17.
 */
public class CountryGroup {
//    public static void main(String[] args){
//        int a[] = {2,1,2,2,1,2};
//        System.out.println(new CountryGroup().solve(a));
//    }
    public int solve(int[] a){
        int len = a.length;
        int result = 0;

        int i = 0;
        while (i < len){
            int n = a[i];
            if(i+n >len){
                return -1;
            }
            for(int j = i+1; j < i+n ; j++){
                if (a[j] != a[i]){
                    return -1;
                }
            }
            i += n;
            result++;
        }
        return result;
    }
}
