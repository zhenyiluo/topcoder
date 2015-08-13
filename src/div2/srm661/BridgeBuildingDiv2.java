public class BridgeBuildingDiv2 {
    public static final int INF = 1000000;
    public int minDiameter(int[] a, int[] b, int k) {
        int ret = INF;
        int n = a.length + 1;

        for (int mask = 0; mask < (1 << n); mask++) {
            if (Integer.bitCount(mask) == k) {
                int[][] c = new int[2 * n][2 * n];
                for (int i = 0; i < 2 * n; i++) {
                    for (int j = 0; j < 2 * n; j++) {
                        c[i][j] = INF;
                    }
                }
                for (int i = 0; i < n - 1; i++) {
                    c[i][i + 1] = a[i];
                    c[i + 1][i] = a[i];
                    c[n + i][n + i + 1] = b[i];
                    c[n + i + 1][n + i] = b[i];
                }
                
                for(int i = 0; i < n ;i++){
                    if((mask & (1 << i)) != 0){
                        c[i][n + i] = 0;
                        c[n+ i][i] = 0;
                    }
                }

                ret = Math.min(ret, solve(c));
            }
        }
        return ret;
    }

    private int solve(int[][] c) {
        int n = c.length;
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(c[i][k] + c[k][j]  < c[i][j]){
                        c[i][j] = c[i][k] + c[k][j];
                    }
                }
            }
        }
        
        int ret = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                ret = Math.max(ret, c[i][j]);
            }
        }
        return ret;
    }
}