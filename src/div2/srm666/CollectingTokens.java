import java.util.*;

public class CollectingTokens {
    ArrayList<Integer>[] g;
    int dp[][][][];
    int[] tokens;
    public int maxTokens(int[] A, int[] B, int[] tokens, int L){
        this.tokens = tokens;
        int n = A.length;
        g = new ArrayList[n+1];
        dp = new int[53][53][101][2];
        
        
        for(int i = 0; i < 53; i++){
            for(int j = 0; j < 53; j++){
                for(int k = 0; k < 101; k++){
                    for(int l = 0; l < 2; l++){
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        
        for(int i = 0; i < g.length; i++){
            g[i] = new ArrayList<Integer>();
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(0);
        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i = 0; i< A.length; i++){
                int y = -1;
                if(A[i] -1 == tmp){
                    y = B[i] -1;
                }
                if(B[i] - 1 == tmp){
                    y = A[i] -1;
                }
                if(y != -1 && !hs.contains(y)){
                    g[tmp].add(y);
                    hs.add(y);
                    q.add(y);
                }
            }
        }
        
        return tokens[0] + f(0, 0, L, 0);
    }
    
    private int f(int x, int e, int L, int m){
        if(dp[x][e][L][m] == -1){
            int res = 0;
            if( e != g[x].size()){
                int y = g[x].get(e);
                for(int i = 0; i <= L; i++){
                    if(L - i - 2 >= 0){
                        int tmp = tokens[y] + f(y, 0, i, 1) + f(x, e+1, L-i-2, m);
                        res = Math.max(res, tmp);
                    }
                    
                    if(L - i - 1 >= 0 && m == 0){
                        int tmp = tokens[y] + f(y, 0, i , 0) + f(x, e+1, L-i-1, 1);
                        res = Math.max(res, tmp);
                    }
                }
                int tmp = f(x, e+1, L, m);
                res = Math.max(res, tmp);
            }
            dp[x][e][L][m] = res;
        }
        return dp[x][e][L][m];
    }
}
