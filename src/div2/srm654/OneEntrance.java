package div2.srm654;

import java.util.ArrayList;

/**
 * Created by Zhenyi Luo on 15-3-25.
 */
public class OneEntrance {
    public static void main(String[] args){
        int[] a = {7, 4, 1, 0, 1, 1, 6, 0};
        int[] b = {6, 6, 2, 5, 0, 3, 8, 4};
        int s = 4;
        System.out.println(new OneEntrance().count(a, b, s));
    }
    public int count(int[] a, int[] b, int s){
        int n = a.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < n; i++){
            list.get(a[i]).add(b[i]);
            list.get(b[i]).add(a[i]);
        }
        return dfs(list, n, s);
    }
    public static int dfs(ArrayList<ArrayList<Integer>> list, int n, int s){
        if(checkList(list) <= 1){
            return 1;
        }
        int result = 0;
        for(int i = 0; i <= n; i++){
            if(list.get(i) != null && list.get(i).size() == 1 && i !=s){
                ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
                for(int j = 0; j < list.size();j ++){
                    tmp.add(new ArrayList<Integer>(list.get(j)));
                }
                int num = tmp.get(i).get(0);
                tmp.get(i).remove(0);
                ArrayList<Integer> tmpList = tmp.get(num);
                int t = 0;
                for(; t< tmpList.size(); t++){
                    if(tmpList.get(t) == i){
                        break;
                    }
                }
                tmpList.remove(t);
                result += dfs(tmp, n, s);
            }
        }
        return result;
    }
    public static int checkList(ArrayList<ArrayList<Integer>> list){
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            if (list.get(i).size() > 0){
                count ++;
            }
        }
        return count;
    }
}
