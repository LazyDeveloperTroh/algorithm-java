package c_graph.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기2_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // n 도시의 수, m 도로의 수, k 거리, x 출발 도시
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        // 데이터 입력
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
        }

        // 풀이
        // 1. 특정거리 k 인 도시 찾기임.
        // 2. (bfs, dfs) 알고리즘을 통해 탐색하다가 길이가 k이면 결과출력
        boolean[] visited = new boolean[n+1];
        List<Integer> result = bfs(graph, visited, x, k);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public static List<Integer> bfs(List<Integer>[] graph, boolean[] visited, int start, int k) {
        List<Integer> result = new ArrayList<>();

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        visited[start] = true;

        while(!q.isEmpty()) {
            int[] p = q.poll();
            int v = p[0];
            int dist = p[1];

            // 거리가 k인 도시들을 저장
            if(dist == k) {
                result.add(v);
            }

            // 거리가 k보다 커진다면 더이상 탐색할 필요가 없어서 stop
            if(dist > k) {
                break;
            }

            // 연결된 노드 방문
            for(int nv : graph[v]) {
                if(!visited[nv]) {
                    q.add(new int[]{nv, dist+1});
                    visited[nv] = true;
                }
            }
        }

        result.sort(Comparator.naturalOrder());
        return result;
    }
}
