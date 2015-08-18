public class TheFootballDivTwo {
    public int find(int yourScore, int[] scores, int[] numberOfTeams){
        int n = 1;
        for(int val : numberOfTeams){
            n += val;
        }
        int x = 0;
        int y = 0;
        int ret = 0;
        for(int i = 0; i < scores.length; i++){
            if(scores[i] <= yourScore){
                x += numberOfTeams[i];
            }else if(scores[i] > yourScore + 6){
                x += numberOfTeams[i];
                ret += numberOfTeams[i];
            }else if(scores[i] <= yourScore + 3){
                y += numberOfTeams[i];
            }
        }
        
        n -= 2 * x + y + 2;
        
        if(n > 0){
            ret += (n +1) /2;
        }
        
        return 1 + ret;
    }
}
