import java.util.HashMap;

/**
 * Created by eric on 2016-02-06.
 */
public class ExplodingRobots {
    public static final int[] dx = {-1, 1, 0, 0};
    public static final int[] dy = {0, 0, -1, 1};
    public String canExplode(int x1, int y1, int x2, int y2, String instructions) {
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('L', 0);
        hm.put('R', 1);
        hm.put('U', 2);
        hm.put('D', 3);
        String ret1 = "Explosion";
        String ret2 = "Safe";
        for(int mask1 = 0; mask1 <= 15; mask1 ++) {
            for(int mask2 = 0; mask2 <= 15; mask2++) {
                int xx1 = x1;
                int yy1 = y1;
                int xx2 = x2;
                int yy2 = y2;
                for(int i = 0; i < instructions.length(); i++) {
                    int dir = hm.get(instructions.charAt(i));
                    if(((mask1 >> dir) & 1) == 0) {
                        xx1 += dx[dir];
                        yy1 += dy[dir];
                    }
                    if(((mask2 >> dir) & 1) == 0) {
                        xx2 += dx[dir];
                        yy2 += dy[dir];
                    }
                    if(xx1 == yy1 && xx2 == yy2) {
                        return ret1;
                    }
                }
            }
        }
        return ret2;
    }
}
