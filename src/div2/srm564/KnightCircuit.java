import java.util.*;

public class KnightCircuit {
    public static void main(String[] args){
        System.out.println(new KnightCircuit().maxSize(3, 20, 1, 3));
    }
    public long maxSize(int w, int h, int a, int b){
        int g = gcd(a, b);
        if(g != 1){
            return maxSize( (1 + (w-1)) /g, (1 +(h-1))/g, a/g, b/g);
        }else{
            if(w < 21 || h < 21){
                return bfs(w, h, a, b);
            }else{
                if((a + b) % 2 != 0){
                    return (long) w * h;
                }else{
                    return (1 + (long)w * h) /2;
                }
            }
        }
    }   
    
    private long bfs(int w, int h, int a, int b){
        boolean[][] isVisited = new boolean[w][h];
        final int[] dx = {a, a, b, b, -a, -a, -b, -b};
        final int[] dy = {b, -b, a, -a, b, -b, a, -a};
        long best = 1;
        for(int i = 0; i < w; i++){
            for(int j = 0; j < h; j++){
                if(!isVisited[i][j]){
                    Queue<Integer> q = new LinkedList<Integer>();
                    q.add(i);
                    q.add(j);
                    isVisited[i][j] = true;
                    long count = 0;
                    while(!q.isEmpty()){
                        int x = q.poll();
                        int y = q.poll();
                        count++;
                        for(int k = 0; k < 8; k++){
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if(nx >= 0 && ny >= 0 && nx < w && ny < h && !isVisited[nx][ny]){
                                isVisited[nx][ny] = true;
                                q.add(nx);
                                q.add(ny);
                            }
                        }
                    }
                    best = Math.max(count, best);
                }
            }
        }
        return best;
    }
    
    private int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
}
