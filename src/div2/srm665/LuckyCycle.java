import java.util.*;

public class LuckyCycle {
    public int[] getEdge(int[] edge1, int[] edge2, int[] weight){
        if(edge1 == null || edge1.length <=1){
            return new int[]{};
        }
        
        int n = edge1.length + 1;
        boolean[][] connected = new boolean[n+1][n+1];
        int[][] ww = new int[n+1][n+1];
        ArrayList<Integer>[] g = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            g[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < edge1.length; i++){
            ww[edge1[i]][edge2[i]] = weight[i];
            ww[edge2[i]][edge1[i]] = weight[i];
            g[edge1[i]].add(edge2[i]);
            g[edge2[i]].add(edge1[i]);
            connected[edge1[i]][edge2[i]] = true;
            connected[edge2[i]][edge1[i]] = true;
        }
        
        boolean found = false;
        int P = 0;
        int Q = 0;
        int W = 0;
        int finalSum = 0;
        
        for(int i = 1; i <= n && !found; i++){
            for(int j = i+1; j<=n && !found; j++){
                if(!connected[i][j]){
                    connected[i][j] = true;
                    connected[j][i] = true;
                    g[j].add(i);
                    
                    Queue<Integer> q = new LinkedList<Integer>();
                    boolean[] visited = new boolean[n+1];
                    q.add(i);
                    q.add(1);
                    q.add(0);
                    visited[i] = true;
                    
                    while(!q.isEmpty()){
                        int node = q.poll();
                        int step = q.poll();
                        int sum = q.poll();
                        
                        for(int tmp : g[node]){
                            if(step != 2 && tmp == i){
                                if(step % 2 == 0){
                                    P = i;
                                    Q = j;
                                    finalSum = sum;
                                    found = true;
                                }
                                break;
                            }
                            if(!visited[tmp]){
                                visited[tmp]= true;
                                q.add(tmp);
                                q.add(step+1);
                                if(ww[node][tmp]!= 0){
                                    q.add(sum + ww[node][tmp]);
                                }else{
                                   q.add(sum);
                                }
                            }
                        }
                    }
                    g[j].remove(g[j].size() -1);
                    connected[i][j] = false;
                    connected[j][i] = false;
                }
            }
        }
        
        if(!found){
            return new int[]{};
        }
        
        if(finalSum % 11 == 7){
            W = 4;
        }else if(finalSum % 11 == 4){
            W = 7;
        }
        
        return new int[]{P, Q, W};
    }
}
