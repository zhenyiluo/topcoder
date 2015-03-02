package div2.srm650;
import java.util.HashSet;

public class TaroJiroDividing{
	public int getNumber(int A, int B){
		int result = 0; 
		HashSet<Integer> hs = new HashSet<Integer>();
		if(A % 2 == 0){
			while(A % 2 == 0){
			hs.add(A);
			A /= 2;
			}
			hs.add(A);
		}
		
		if(B % 2==0){
			while(B % 2 == 0){
				if(hs.contains(B)){
					result++;
				}
				B /= 2;
			}
			if(hs.contains(B)){
				result++;
			}
		}
		
		return result;
	}
}