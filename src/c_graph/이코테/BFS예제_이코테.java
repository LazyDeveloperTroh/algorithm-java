package c_graph.이코테;

import java.util.LinkedList;
import java.util.Queue;

public class BFS예제_이코테 {
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
        BFS(graph, 1, visited);
    }

    private static void BFS(int[][] graph, int start, boolean[] visited) {
        if(visited[start]) return;

        Queue<Integer> q = new LinkedList();
        q.add(start);

        while(!q.isEmpty()) {
            Integer v = q.poll();
            visited[v] = true;
            System.out.println("v = " + v);

            for(int nv : graph[v]) {
                if(!visited[nv]) {
                    q.add(nv);
                    // 미리 방문처리를 하지 않으면 다른 노드에서 중복된 노드를 방문할 수 있음
                    visited[nv] = true;
                }
            }
        }
    }
}
