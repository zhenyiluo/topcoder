import java.util.*;

public class Fragile2 {

    int N;
    boolean[] visited;

    public int countPairs(String[] graph) {
        N = graph.length;
        int ret = 0;

        visited = new boolean[N];
        int cur = cal(graph, -1, -1);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                visited = new boolean[N];
                int newVal = cal(graph, i, j);
                if (newVal > cur) {
                    ret++;
                }
            }
        }

        return ret;
    }

    private int cal(String[] graph, int a, int b) {
        int ret = 0;
        for (int i = 0; i < N; i++) {
            if (i != a && i != b) {
                if (!visited[i]) {
                    ret++;

                    Queue<Integer> q = new LinkedList<Integer>();
                    q.add(i);
                    while (!q.isEmpty()) {
                        int node = q.poll();
                        visited[node] = true;
                        for (int j = 0; j < N; j++) {
                            if (j != a && j != b) {
                                if (j != node && !visited[j]
                                        && graph[node].charAt(j) == 'Y') {
                                    q.add(j);
                                }
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }
}
