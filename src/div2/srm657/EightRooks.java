package div2.srm657;

/**
 * Created by Zhenyi Luo on 15-4-27.
 */
public class EightRooks {
    public String isCorrect(String[] board){
        int n = 8;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(board[i].charAt(j) == 'R'){
                    count++;
                }
            }
            if(count != 1){
                return "Incorrect";
            }
        }

        for(int j = 0; j < n; j++){
            int count = 0;
            for(int i = 0; i < n; i++)
            {
                if(board[i].charAt(j) == 'R'){
                    count ++;
                }
            }
            if(count != 1){
                return "Incorrect";
            }
        }
        return "Correct";
    }
}
