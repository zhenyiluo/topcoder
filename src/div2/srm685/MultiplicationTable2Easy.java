import java.util.HashSet;

/**
 * Created by eric on 9/25/16.
 */
public class MultiplicationTable2Easy {
//    public static void main(String[] args){
//
//    }

    public String isGoodSet(int[] table, int[] t){
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < t.length; i++){
            hs.add(t[i]);
        }
        int n = (int) Math.sqrt(table.length);
        for(int i = 0; i < t.length; i++) {
            for(int j = 0; j < t.length; j++) {
                int index = i * n + j;
                if(!hs.contains(table[index])){
                    return "Not Good";
                }
            }
        }
        return "Good";
    }
}
