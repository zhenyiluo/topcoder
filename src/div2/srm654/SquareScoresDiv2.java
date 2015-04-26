package div2.srm654;

/**
 * Created by Zhenyi Luo on 15-3-25.
 */
public class SquareScoresDiv2 {
//    public static void main(String[] args){
//
//    }
    public int getscore(String s){
        int count= 0;
        for(int len = 1; len <= s.length(); len++){
            for(int i = 0; i + len <= s.length(); i++){
                String sub = s.substring(i, i+len);
                if(isSame(sub)){
                    count++;
                }
            }
        }
        return count;
    }
    public static boolean isSame(String s){
        if(s.length() == 1){
            return true;
        }
        char prev = s.charAt(0);
        for(int i = 1; i< s.length(); i++){
            if(s.charAt(i) != prev){
                return false;
            }
        }
        return true;
    }
}
