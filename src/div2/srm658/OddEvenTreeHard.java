import java.util.*;

public class OddEvenTreeHard {
    ArrayList<Integer>[] listEven;
    ArrayList<Integer>[] listOdd;
    int[] colors;
    boolean flag;
    public int[] getTree(String[] x){
        int n = x.length;
        listEven = new ArrayList[n];
        listOdd = new ArrayList[n];
        for(int i = 0; i < n; i++){
            listEven[i] = new ArrayList<Integer>();
            listOdd[i] = new ArrayList<Integer>();
        }
        
        for(int i= 0; i < n; i++){
            for(int j = 0; j < x[0].length(); j ++){
                if(x[i].charAt(j) == 'E'){
                    listEven[i].add(j);
                }else if(x[i].charAt(j) == '0'){
                    listOdd[i].add(j);
                }
            }
        }
        
        colors = new int[n];
        for(int i = 0; i < n; i++){
            colors[i] = -1;
        }
        flag = false;
        for(int i = 0; i < n; i++){
            if(colors[i] == -1){
                if(i == 0){
                    dfs(i, 0);
                }else{
                    dfs(i, 1);
                }
            }
        }
        
        if(flag){
            return new int[]{-1};
        }
        
        ArrayList<Integer> zeros = new ArrayList<Integer>();
        ArrayList<Integer> ones = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            if(colors[i] == 0){
                zeros.add(i);
            }else{
                ones.add(i);
            }
        }
        if(zeros.size() == 0 || ones.size() == 0){
            return new int[]{-1};
        }
        
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i < ones.size(); i++){
            ret.add(zeros.get(0));
            ret.add(ones.get(i));
        }
        
        for(int i = 1; i < zeros.size(); i++){
            ret.add(ones.get(0));
            ret.add(zeros.get(i));
        }
        
        int[] result = new int[ret.size()];
        for(int i = 0; i< ret.size(); i++){
            result[i] = ret.get(i);
        }
        
        return result;
    }
    
    private void dfs(int i, int color){
        if(colors[i] == -1){
            colors[i] = color;
            for(int n : listEven[i]){
                dfs(n, color);
            }
            
            for(int n: listOdd[i]){
                dfs(n, 1 ^ color);
            }
        }else if(colors[i] != color){
            flag = true;
        }
        
    }
}
