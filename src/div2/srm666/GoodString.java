import java.util.*;
 
public class GoodString {
    
    public String isGood(String s){
        if(s.length() % 2 != 0){
            return "Bad";
        }
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(st.charAt(i) == 'a'){
                st.add('a');
            }else{
                if(s.isEmpty()){
                    return "Bad";
                }
                st.pop();
            }
        }
        if(st.isEmpty()){
            return "Good";
        }
        return "Bad";
    }
    
}