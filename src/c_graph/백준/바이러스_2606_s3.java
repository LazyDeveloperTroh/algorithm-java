package c_graph.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 바이러스_2606_s3 {
    private static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int links = Integer.parseInt(br.readLine());

        List[] graphs = new ArrayList[n+1];
        for (int i = 0; i < graphs.length; i++) {
            graphs[i] = new ArrayList();
        }

        for (int i = 0; i < links; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graphs[v1].add(v2);
            graphs[v2].add(v1);
        }

        boolean[] visited = new boolean[n+1];
        dfs(1, graphs, visited);

        System.out.println(result-1);
    }

    private static void dfs(int v, List[] graphs, boolean[] visited) {
        if(visited[v]) return;

        visited[v] = true;
        result++;

        List links = graphs[v];
        for (int i = 0; i < links.size(); i++) {
            int nv = (int) links.get(i);
            if(!visited[nv]) {
                dfs(nv, graphs, visited);
            }
        }
    }
}
