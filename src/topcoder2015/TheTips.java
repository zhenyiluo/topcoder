package topcoder2015;


/**
 * Created by Zhenyi Luo on 15-4-25.
 */
public class TheTips {
    public static void main(String[] args){
        String[] clues = {"NYYNYYNNNN","NNNNYNNNYN","YNNYYYYYNN","YYNYNNNNYN","NYNNNNNNNY","YNYYNNYNNY","NYNNYYYYYY","NYYYYNNNNN","YYNYNNYYYN","NNYYNYNYYY"};
        int[] probability = {11,66,99,37,64,45,21,67,71,62};
        System.out.println(new TheTips().solve(clues, probability));
    }
    public double solve(String[] clues, int[] probability){
        int N = clues.length;
        boolean[][] connected = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String s = clues[i];
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == 'Y'){
                    connected[i][j] = true;
                }
            }
            connected[i][i] = true;
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    if(connected[i][k] && connected[k][j]){
                        connected[i][j] = true;
                    }
                }
            }
        }
        double[] prob = new double[N];
        for(int i = 0; i < N; i++){
            prob[i] = (1.00 * probability[i])/100;
        }
        double ret = N;
        for(int i = 0; i < N; i++){
            double p = 1;
            for(int j = 0; j < N; j++){
                if(connected[i][j]){
                    p *= 1- prob[j];
                }
            }
            ret -= p;
        }
        return ret;
    }
}
