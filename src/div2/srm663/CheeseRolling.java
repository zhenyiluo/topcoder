import java.util.*;

public class CheeseRolling {

    public long[][] cache;
    public static ArrayList<Integer>[] halfSubsets = new ArrayList[1 << 16];
    String[] wins;
    int len;
    static {
        for (int n = 1; n < (1 << 16); n ++) {
            halfSubsets[n] = new ArrayList<Integer>();
            for (int subset = n & (n - 1); subset > 0; subset = (subset - 1)
                    & n) {
                if (Integer.bitCount(subset) * 2 == Integer.bitCount(n)) {
                    halfSubsets[n].add(subset);
                }
            }
        }
    }

    public long[] waysToWin(String[] wins) {
        len = wins.length;
        this.wins = wins;
        long[] ret = new long[len];
        cache = new long[len][1 << len];
        

        int mask = (1 << len) - 1;
        for (int i = 0; i < len; i++) {
            ret[i] = dfs(i, mask);
        }

        return ret;
    }

    private long dfs(int num, int mask) {
        if (cache[num][mask] == 0) {
            if (Integer.bitCount(mask) == 1) {
                cache[num][mask] = 1;
            } else {
                cache[num][mask] = 0;
                for (int subset : halfSubsets[mask]) {
                    if ((subset & (1 << num)) != 0) {
                        int subset2 = mask & ~subset;
                        for (int j = 0; j < len; j++) {
                            if (wins[num].charAt(j) == 'Y'
                                    && (subset2 & (1 << j)) != 0) {
                                cache[num][mask] += 2 * dfs(num, subset)
                                        * dfs(j, subset2);
                            }
                        }
                    }
                }

            }

        }
        return cache[num][mask];
    }
}