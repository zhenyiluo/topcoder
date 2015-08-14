import java.util.*;

public class PrivateD2party {
    public int getsz(int[] a){
        int len = a.length;
        int ret = len;
        for(int i = 0; i < len; i++){
            if(i != a[i]){
                for(int j = i + 1; j < len; j++){
                    if(j != a[j]){
                        if(a[i] == j && a[j] == i){
                            ret --;
                        }
                    }
                }
            }
        }
        return ret;
    }
}