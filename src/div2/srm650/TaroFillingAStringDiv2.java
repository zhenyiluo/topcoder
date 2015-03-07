package div2.srm650;
//Version2
public class TaroFillingAStringDiv2{
	public int getNumber(String S){
		int result = 0;
		boolean flag = false;
		for(int i = 0 ; i< S.length() && !flag; i++){
			if(S.charAt(i) != '?'){
				flag = true;
			}
		}
		if(!flag){
			return 0;
		}
		StringBuilder sb = new StringBuilder(S);
		for(int i = 0; i < sb.length()-1; i++){
			if(sb.charAt(i) == 'A' && sb.charAt(i+1) == '?'){
				sb.setCharAt(i+1, 'B');
			}else if(sb.charAt(i) == 'B' && sb.charAt(i+1) == '?'){
						sb.setCharAt(i+1, 'A');
					}
		}
		
		for(int i = sb.length()-1; i > 0; i--){
			if(sb.charAt(i) == 'A' && sb.charAt(i-1) == '?'){
				sb.setCharAt(i-1, 'B');
			}else if(sb.charAt(i) == 'B' && sb.charAt(i-1) == '?'){
						sb.setCharAt(i-1, 'A');
					}
		}	
		
		for(int i =0; i < sb.length()-1; i++){
			if(sb.charAt(i) == sb.charAt(i+1)){
				result++;
			}
		}
		
		return result;	
	}
}