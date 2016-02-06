/**
 * Created by eric on 2016-02-06.
 */
public class XorLists {
    public int countLists(int[] s, int m) {
        int ret = 0;
        int n = (int) Math.sqrt(s.length);
        int[] mask = new int[30];
        for(int i = 0; i < 30; i++) {
            int[] a = new int[n];

            // set 0
            a[0] = 0;
            for(int j = 1; j < n; j++) {
                if(((s[j] >> i) & 1) == 0) {
                    a[j] = 0;
                } else{
                    a[j] = 1;
                }
            }

            boolean flag = true;
            for(int k = 0; k < n && flag; k++) {
                for(int j = k + 1; j < n && flag; j++) {
                    int tmp = a[k] ^ a[j];
                    if(tmp != ((s[k * n + j] >> i)&1)) {
                        flag = false;

                    }
                }
            }
            if(flag) {
                mask[i] += 1;
            }

            // set 1
            a[0] = 1;
            for(int j = 1; j < n; j++) {
                if(((s[j] >> i) & 1) == 0) {
                    a[j] = 1;
                } else{
                    a[j] = 0;
                }
            }

            flag = true;
            for(int k = 0; k < n && flag; k++) {
                for(int j = k + 1; j < n && flag; j++) {
                    int tmp = a[k] ^ a[j];
                    if(tmp != ((s[k * n + j] >> i)&1)) {
                        flag = false;

                    }
                }
            }
            if(flag) {
                mask[i] += 2;
            }
        }




        return ret;
    }
}
