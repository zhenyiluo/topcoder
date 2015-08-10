public class ABBA {

    public String canObtain(String initial, String target){
        if(initial.length() > target.length()){
            return "Impossible";
        }
        if(initial.equals(target)){
            return "Possible";
        }
        if(target.charAt(target.length() -1) == 'A'){
            return canObtain(initial, target.substring(0, target.length()-1));
        }else{
            StringBuilder sb = new StringBuilder(target.substring(0, target.length()-1));
            return canObtain(initial, sb.reverse().toString());
        }
    }    
}