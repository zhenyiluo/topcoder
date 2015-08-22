import java.io.*;
import java.util.*;

public class LuckyCycle {
    ArrayList<Edge>[] g;
    int count4;
    int count7;
    boolean[] visited;
    static class Edge{
        int v;
        int w;
        public Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    public int[] getEdge(int[] edge1, int[] edge2, int[] weight){
        if(edge1 == null || edge1.length <=1){
            return new int[0];
        }
        int n = edge1.length;
        g = new ArrayList[n+1];
        for(int i = 0; i < g.length; i++){
            g[i] = new ArrayList<Edge>();
        }
        for(int i = 0; i < n; i++){
            g[edge1[i]-1].add(new Edge(edge2[i]-1, weight[i]));
            g[edge2[i]-1].add(new Edge(edge1[i]-1, weight[i]));
        }
        
        for(int i = 0; i <= n; i++){
            for(int j = i+1; j <= n; j++){
                count4 = 0;
                count7 = 0;
                visited = new boolean[n+1];
                dfs(i, j, 0, 0);
                if(Math.abs(count4 - count7) == 1 && count4 + count7 > 1){
                    if(count4 > count7){
                        return new int[]{i+1, j+1, 7};
                    }else{
                        return new int[]{i+1, j+1, 4};
                    }
                }
            }
        }
        return new int[0];
    }
    
    private void dfs(int u, int v, int count4, int count7){
        visited[u] = true;
        if(u == v){
            this.count4 = count4;
            this.count7 = count7;
            return;
        }
        for(Edge e : g[u]){
            if(!visited[e.v]){
                if(e.w == 4){
                    dfs(e.v, v, count4+1, count7);
                }else{
                    dfs(e.v, v, count4, count7 + 1);
                }
            }
        }
    }
}
