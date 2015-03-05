package div2.srm633;

/**
 * Created by Eric on 15-3-4.
 */
public class Jumping {
    public String ableToGet(int x, int y, int[] jumpLengths){
        int low = 0;
        int high = 0;

        for(int i = 0; i < jumpLengths.length; i++){
            if(jumpLengths[i] <= low){
                low -= jumpLengths[i];
            }else if(jumpLengths[i] <= high){
                low = 0;
            }else{
                low = jumpLengths[i] - high;
            }
            high += jumpLengths[i];
        }
        long xx = x;
        long yy = y;
        long distance = xx * xx + yy * yy;
        if(distance >= low * low && distance <= high * high){
            return "Able";
        }else{
            return "Not able";
        }
    }
}
