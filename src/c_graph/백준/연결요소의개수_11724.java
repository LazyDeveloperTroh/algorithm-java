package c_graph.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 연결요소의개수_11724 {
    static void dfs(List[] graph, boolean[] visited, int v) {
        if(visited[v]) {
            return;
        }

        visited[v] = true;
        List<Integer> links = graph[v];
        for(int i=0; i<links.size(); i++) {
            Integer nextNode = links.get(i);
            if(!visited[nextNode]){
                dfs(graph, visited, nextNode);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n+1];

        List<Integer>[] graph = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        int result = 0;
        for (int i = 1; i < graph.length; i++) {
            if(graph[i].size() != 0 && !visited[i]) {
                dfs(graph, visited, i);
                result += 1;
            }
            else if(graph[i].size() == 0) {
                result += 1;
            }
        }

        System.out.println(result);
    }
}
