package div2.srm628;

import java.util.LinkedList;
import java.util.Queue;

class Point {
	int x;
	int y;
	int l;
	public Point(int x, int y, int l){
		this.x = x;
		this.y = y;
		this.l = l;
	}
}
public class BishopMove {
	public static int[] vx = new int[]{1, 1, -1, -1};
	public static int[] vy = new int[]{1, -1, 1, -1};
	public int howManyMoves(int r1, int c1, int r2, int c2){
		boolean[][] visited = new boolean[8][8]; 
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(r1, c1, 0));
		while(q.size() > 0){
			Point p = q.poll();
			visited[p.x][p.y] = true;
			int level = p.l;
			if((p.x == r2)&&(p.y == c2)){
				return level;
			}
			for(int k = 1; k <=7 ; k++){
				for(int dir = 0; dir < 4; dir++){
					int x = p.x + vx[dir] * k;
					int y = p.y + vy[dir] * k;
					if(!isOutOfRange(x, y) && !visited[x][y]){
						q.add(new Point(x ,y, level+1));
					}
				}
			}
		}
		return -1;
	}
	private boolean isOutOfRange(int x, int y) {
		if(x < 0 || y < 0 || x > 7 || y > 7){
			return true;
		}
		return false;
	}

}
