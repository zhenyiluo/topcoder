import java.util.*;
public class NoRightTurnDiv2 {
    public static final int INF = (int) (1e9);
    public int[] findPath(int[] x, int[] y){
        int n = x.length;
        int[] ret = new int[n];
        for(int i = 0; i < n; i++){
            ret[i] = i;
        }
        int init = -1;
        int initX = INF;
        int initY = INF;
        for(int i = 0; i < n; i++){
            if(x[i] < initX){
                init = i;
                initX = x[i];
                initY = y[i];
            }else if(x[i] == initX){
                if(y[i] < initY){
                    init = i;
                    initX = x[i];
                    initY = y[i];
                }
            }
        }
        swap(ret, 0, init);
        
        for(int i = 1; i<n; i++){
            int pick = -1;
            for(int j = i; j < n; j++){
                boolean bad = false;
                for(int k = i; k < n; k++){
                    if(j != k){
                        int l = ret[i-1];
                        int m = ret[j];
                        int o = ret[k];
                        if(area(x[l], y[l], x[m], y[m], x[o], y[o]) < 0){
                            bad = true;
                        }
                    }
                }
                if(!bad){
                    pick = j;
                }
            }
            swap(ret, i, pick);
        }
        
        return ret;
    }
    
    private int area(int x1, int y1, int x2, int y2, int x3, int y3){
        return (x2- x1) * (y3 - y1) - (x3 - x1)*(y2 - y1);
    }
    
    private void swap(int[] ret, int x, int y){
        int tmp = ret[x];
        ret[x] = ret[y];
        ret[y] = tmp;
    }
}
