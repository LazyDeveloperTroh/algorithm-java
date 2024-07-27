package c_graph.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기_이코테 {
    private static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        // 1. 출발노드(x)부터 그래프 탐색을 수행
        // 2. 거리가 k인 도시번호 저장

        List[] graph = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList();
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // a 도시에서 b도시로 이동
            graph[a].add(b);
        }

        bfs(graph, x, k, visited);
        if(result.isEmpty()) {
            System.out.println(-1);
        } else {
            result.sort(Comparator.naturalOrder());
            for (int i = 0; i < result.size(); i ++) {
                System.out.println(result);
            }
        }
    }

    private static void bfs(List[] graph, int start, int target, boolean[] visited) {
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{start, 0});
        visited[start] = true;

        while(!q.isEmpty()) {
            int[] poll = q.poll();
            int v = poll[0];
            int dist = poll[1];

            if(dist == target) {
                result.add(v);
            }
            List<Integer> list = graph[v];
            for(int nv : list) {
                if(!visited[nv]) {
                    q.add(new int[]{nv, dist + 1});
                    visited[nv] = true;
                }
            }
        }
    }
}
