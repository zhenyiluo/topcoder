public class LostCharacter {
    public int[] getmins(String[] str){
        int len = str.length;
        int[] ret = new int[len];
        StringBuilder[] sbs = new StringBuilder[len];
        for(int i = 0; i < len; i++){
            sbs[i] = new StringBuilder(str[i]);
            for(int j = 0; j < sbs[i].length(); j++){
                if(sbs[i].charAt(j) == '?'){
                    sbs[i].setCharAt(j, 'z'); 
                }
            }
        }
        for(int i = 0; i < len; i++){
            StringBuilder sb = new StringBuilder(str[i]);
            for(int j = 0; j < sb.length();j++){
                if(sb.charAt(j) == '?'){
                    sb.setCharAt(j, 'a');
                }
            }
            ret[i] = findPosition(sb, sbs);
        }
        return ret;
    }
    
    private int findPosition(StringBuilder sb, StringBuilder[] sbs){
        int ret = 0; 
        for(int i = 0; i < sbs.length; i++){
            if(sb.toString().compareTo(sbs[i].toString()) > 0){
                ret ++;
            }
        }
        return ret;
    }
}
