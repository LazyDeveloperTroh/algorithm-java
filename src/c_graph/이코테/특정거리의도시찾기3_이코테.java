package c_graph.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기3_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List[] graph = new ArrayList[n+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
        }

        boolean[] visited = new boolean[n+1];
        List<Integer> result = bfs(graph, visited, x, k);
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int r : result) {
                System.out.println(r);
            }
        }
    }

    private static List<Integer> bfs(List<Integer>[] graph, boolean[] visited, int x, int k) {
        List<Integer> result = new ArrayList<>();

        Queue<int[]> q = new LinkedList();
        // [노드, 거리]
        q.add(new int[]{x, 0});
        visited[x] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int v = poll[0];
            int dist = poll[1];

            if(dist == k) {
                result.add(v);
            }

            for(int nv : graph[v]) {
                if(!visited[nv]) {
                    q.add(new int[]{nv, dist + 1});
                    visited[nv] = true;
                }
            }
        }

        return result;
    }
}
