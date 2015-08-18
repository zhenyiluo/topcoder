import java.util.*;
public class TheGridDivTwo {
    
    public static final int[] dx = {-1, 1, 0, 0};
    public static final int[] dy = {0, 0, -1, 1};
    public int find(int[] x, int[] y, int k){
        int n = x.length;
        for(int i = 0; i < n; i++){
            x[i] += 1000;
            y[i] += 1000;
        }
        int start = 1000; 
        int end = 1000;
        int ret = 1000;
        boolean[][] visited = new boolean[2001][2001];
        for(int i = 0; i < n; i++){
            visited[x[i]][y[i]] = true;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        q.add(end);
        q.add(k);
        visited[start][end] = true;
        
        while(!q.isEmpty()){
            int s = q.poll();
            int e = q.poll();
            int step = q.poll();
            ret = Math.max(ret, s);
            
            if(step == 0){
                continue;
            }
            for(int i = 0; i < 4; i++){
                int nx = s + dx[i];
                int ny = e + dy[i];
                if(!visited[nx][ny]){
                    q.add(nx);
                    q.add(ny);
                    q.add(step-1);
                    visited[nx][ny] = true;
                }
            }
            
        }
        
        ret -= 1000;
        return ret;
        
    }
}
