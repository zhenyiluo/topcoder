package div2.srm640;

/**
 * Created by Eric on 15-3-3.
 */
public class ChristmasTreeDecorationDiv2 {
    public int solve(int[] col, int[] x, int[] y) {
        int result = 0;

        for(int i = 0; i < x.length; i++){
            if(col[x[i]-1] != col[y[i]-1]){
                result++;
            }
        }

        return result;
    }
}
