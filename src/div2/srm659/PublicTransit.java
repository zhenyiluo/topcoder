
public class PublicTransit {
    public static void main(String[] args){
        System.out.println(new PublicTransit().minimumLongestDistance(10, 10));
    }
    public static final int INF = 1000000;
    public int minimumLongestDistance(int R, int C){
        int n = R * C;
        int D = INF;
        for(int l = 0; l < n; l++){
            for(int m = l+1; m < n; m++){
                int[][] dist = new int[n][n];
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j ++){
                        if(j == i){
                            dist[i][j] = 0;
                        }else{
                            dist[i][j] = INF;
                        }
                    }
                }
        
                for(int i = 0; i < R; i++){
                    for(int j = 0; j < C-1; j++){
                        int k = i * C + j;
                        dist[k][k+1] = 1;
                        dist[k+1][k] =1 ;
                    }
                }
        
                for(int j = 0; j < C; j++){
                    for(int i = 0; i < R-1; i++){
                        int k = i * C + j;
                        dist[k][k + C] = 1;
                        dist[k+C][k] = 1;
                    }
                }
                dist[l][m] = 0;
                dist[m][l] = 0;
                
                for(int k = 0; k < n; k++){
                    for(int i = 0; i < n; i++){
                        for(int j = 0; j < n; j++){
                            if(dist[i][k] + dist[k][j] < dist[i][j]){
                                dist[i][j] = dist[i][k] + dist[k][j];
                            }
                        }
                    }
                }
                
                int maxDist = 0;
                for(int i = 0; i < n; i++){
                    for(int j = i+1; j < n; j++){
                        maxDist = Math.max(maxDist, dist[i][j]);
                    }
                }
                
                D = Math.min(D, maxDist);
            }
        }
        return D;
    }
}
