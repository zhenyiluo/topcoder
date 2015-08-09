import java.util.*;

public class BearPlaysDiv2{
	public String equalPiles(int A, int B, int C){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(A);
		list.add(B);
		list.add(C);
		int total = A + B + C;
		if(total / 3 * 3 != total){
			return "impossible";
		}
		int target = total / 3;
		
		HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
		
		while(true){
			if(check(list, target)){
				return "possible";
			}
			Collections.sort(list);
			if(hs.contains(list)){
				return "impossible";
			}else{
				hs.add(list);
			}
			int first = list.remove(0);
			int last = list.remove(list.size()-1);
			int tmp = first;
			first *= 2;
			last -= tmp;
			if(last <= 0){
				return "impossible";
			}
			list.add(first);
			list.add(last);
		}
	}
	
	private boolean check(ArrayList<Integer> list, int target){
		for(int n : list){
			if(n != target){
				return false;
			}
		}
		return true;
	}
}





