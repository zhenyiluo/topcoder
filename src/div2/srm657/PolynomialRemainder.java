package div2.srm657;

/**
 * Created by Zhenyi Luo on 15-4-27.
 */
public class PolynomialRemainder {
    public static void main(String[] args){
        System.out.println(new PolynomialRemainder().findRoot(0, 0, 1));
    }
    public int findRoot(int a, int b, int c){
        int div = 1000000000;
        long p0 = c;
        if(p0 % div == 0){
            return 0;
        }
        for(int y = 0; y < 999999999; y++){
            int dif = 2 * a * y + a + b;
            p0 += dif;
            if(p0 % div == 0){
                return y+1;
            }
        }
        return -1;
    }
}
