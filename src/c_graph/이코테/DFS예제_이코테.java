package c_graph.이코테;

public class DFS예제_이코테 {
    public static void main(String[] args) {
        int[][] graph = {
                {},
                {2, 3, 8},
                {1, 7},
                {1, 4, 5},
                {3, 5},
                {3, 4},
                {7},
                {2, 6, 8},
                {1, 7}
        };

        boolean[] visited = new boolean[10];

        DFS(graph, 1, visited);
    }

    private static void DFS(int[][] graph, int v, boolean[] visited) {
        if(visited[v]) return;

        visited[v] = true;
        System.out.println("v = " + v);

        for (int nv : graph[v]) {
            if(!visited[nv]) {
                DFS(graph, nv, visited);
            }
        }
    }
}
