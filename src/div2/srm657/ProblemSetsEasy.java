package div2.srm657;

/**
 * Created by Zhenyi Luo on 15-4-27.
 */
public class ProblemSetsEasy {
    public static void main(String[] args){
        System.out.println(new ProblemSetsEasy().maxSets(10000, 10000, 10000, 10000, 10000));
    }
    public int maxSets(int E, int EM, int M, int MH, int H){
        int max = 0;
        int best = (E + EM + M + MH + H) /3;
        int x = 0;
        if(best >= E){
            x = Math.min(best - E, EM);
        }else{
            x = 0;
        }
        int y = 0;
        if(best >= H){
            y = Math.min(best - H, MH);
        }else{
            y = 0;
        }
        int a = E + x;
        int b = M + EM + MH - (x + y);
        int c = H + y;
        max = Math.max(Math.min(a, Math.min(b, c)), max);
        return max;
    }
}
