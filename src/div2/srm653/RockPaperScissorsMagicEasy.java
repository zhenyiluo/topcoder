package div2.srm653;

import java.math.BigInteger;

/**
 * Created by Eric on 15-3-17.
 */
public class RockPaperScissorsMagicEasy {
    public int count(int[] card, int score){

        int n = card.length;
        if(score > n){
            System.out.println(0);

        }
        BigInteger result = getFact(n).divide(getFact(n-score)).divide(getFact(score));
        for(int i = 0; i < n-score; i++ ){
            result = result.multiply(BigInteger.valueOf(2));
        }
        result = result.mod(BigInteger.valueOf(1000000007));

        return result.intValue();
    }
//    public static void main(String[] args){
//        int[] a = {0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}
//        ;
//        int n = a.length;
//        int num = 7;
//        if(num > n){
//            System.out.println(0);
//
//        }
//        BigInteger result = getFact(n).divide(getFact(n-num)).divide(getFact(num));
//        for(int i = 0; i < n-num; i++ ){
//            result = result.multiply(BigInteger.valueOf(2));
//        }
//        result = result.mod(BigInteger.valueOf(1000000007));
//        System.out.println(result);
//    }

    public static BigInteger getFact(int n){
        BigInteger result = BigInteger.valueOf(1);
        for(int i = 1 ; i<=n; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}

