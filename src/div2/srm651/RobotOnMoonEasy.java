package div2.srm651;
public class RobotOnMoonEasy{
	public String isSafeCommand(String[] board, String S){
		int row = board.length;
		int col = board[0].length();
		int x = 0; 
		int y = 0; 
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(board[i].charAt(j) == 'S'){
					x = i;
					y = j;
				}
			}
		}
		
		
		for(int i = 0; i < S.length(); i++){
			switch(S.charAt(i)){
				case 'U' : if(x == 0){ 
							return "Dead"; 
							}else if(board[x-1].charAt(y) != '#'){
								x--;
							}
							break;
				case 'D' : if(x == row -1){
							return "Dead";
							}else if(board[x+1].charAt(y) != '#'){
							   x++;
							}
							break;
				case 'L' : if(y == 0){
							return "Dead";
							}else if(board[x].charAt(y-1) !='#'){
								y--;
							}
							break;
				case 'R' : if(y == col-1){
								return "Dead";
							}else if(board[x].charAt(y+1) != '#'){
								y++;
							}
							break;
				default : break;
			}
		}
		
		return "Alive";
	}
}