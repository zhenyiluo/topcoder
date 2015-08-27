import java.util.*;
 
public class DevuAndGame {
    
    public String canWin(int[] nextLevel){
        int n = nextLevel.length;
        int cur = 0;
        boolean[] visited = new boolean[n];
        while(!visited[cur] && nextLevel[cur] != -1){
            visited[cur] = true;
            cur = nextLevel[cur];
        }
        if(visited[cur]){
            return "Lose";
        }
        
        return "Win";
    }
    
}