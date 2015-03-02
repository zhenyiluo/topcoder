package div2.srm649;

public class DecipherabilityEasy {
    public String check(String s, String t) {
        if(s.length() != t.length() +1){
            return "Impossible";
        }
        StringBuilder sb = new StringBuilder(s);
        StringBuilder st = new StringBuilder(t);
        for(int i = 0; i < sb.length(); i++){
            char c = sb.charAt(i);
            if(sb.deleteCharAt(i).toString().equals(st.toString())){
                return "Possible";
            }
            sb.insert(i, c);
        }
        return "Impossible";
    }


}
