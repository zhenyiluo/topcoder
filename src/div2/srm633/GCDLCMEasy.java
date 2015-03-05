package div2.srm633;

/**
 * Created by Eric on 15-3-5.
 */
import java.util.ArrayList;
public class GCDLCMEasy {

    public static void main(String[] args){
        int n = 5;
        int[] A = {0, 1, 2, 3, 4};
        int[] B = {1, 2, 3, 4, 0};
        int[] G = {6, 6, 6, 6, 6};
        int[] L = {12, 12, 12, 12, 12};
        System.out.println(new GCDLCMEasy().possible(n, A, B, G, L));
    }
    static ArrayList<ArrayList<Component>> ls;
    static int[] value;
    static boolean oneGood;
    static boolean good;
    public String possible(int n, int[] A, int[] B, int[] G, int[] L){
        ls = new ArrayList<ArrayList<Component>>();
        for(int i = 0; i< n; i++){
            ls.add(new ArrayList<Component>());
        }
        for(int i = 0; i < A.length; i++){
            ArrayList<Component> l = ls.get(A[i]);
            l.add(new Component(B[i], G[i], L[i]));
            ls.set(A[i], l);
        }

        for(int i = 0; i < B.length; i++){
            ArrayList<Component> l = ls.get(B[i]);
            l.add(new Component(A[i], G[i], L[i]));
            ls.set(B[i], l);
        }

        value = new int[n];
        for(int i = 0; i < n; i++){
            value[i] = -1;
        }

        for(int i = 0; i < n; i++){
            if(value[i] ==  -1){
                oneGood = false;
                for(int x = 1; x <=10000; x++){
                    cleanDFS(i);
                    good = true;
                    setDFS(i, x);
                    if(good){
                        oneGood = true;
                        break;
                    }
                }
                if(! oneGood){
                    return "Solution does not exist";
                }
            }
        }

        return "Solution exists";
    }
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b, a % b);
        }
    }

    public static int lcm(int a, int b){
        return (a / gcd(a, b)) * b;
    }
    public static void setDFS(int x, int a){
        if(value[x] == -1){
            value[x] = a;
            if(ls.get(x) != null){
                int size = ls.get(x).size();
                for(int i = 0; i < size; i++){
                    Component c = ls.get(x).get(i);
                    int p = c.gcd * c.lcm;
                    if(p % a == 0){
                        int b = p / a;
                        if(lcm(a, b) == c.lcm && gcd(a, b) == c.gcd){
                            setDFS(c.node, b);
                        }else{
                            good = false;
                        }
                    }else{
                        good = false;
                    }
                }
            }
        }else if(value[x] != a){
            good = false;
        }
    }

    public static void cleanDFS(int x){
        if(value[x] != -1){
            value[x] = -1;
            if(ls.get(x) != null){
                int size = ls.get(x).size();
                for(int i = 0; i < size; i++){
                    Component c = ls.get(x).get(i);
                    cleanDFS(c.node);
                }
            }
        }
    }
}

class Component{
    int node;
    int gcd;
    int lcm;
    public Component(int node, int gcd, int lcm){
        this.node = node;
        this.gcd = gcd;
        this.lcm = lcm;
    }
}
