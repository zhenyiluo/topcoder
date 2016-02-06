/**
 * Created by eric on 2016-02-06.
 */
public class CoinFlipsDiv2 {
    public int countCoins(String state) {
        int count = 0;
        for(int i = 0; i < state.length(); i++) {
            if(i-1 >= 0 && state.charAt(i-1) != state.charAt(i)){
                count++;
                continue;
            }
            if(i+1 < state.length() && state.charAt(i+1) != state.charAt(i)){
                count ++;
                continue;
            }
        }
        return count;
    }
}
