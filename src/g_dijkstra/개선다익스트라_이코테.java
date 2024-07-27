package g_dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class 개선다익스트라_이코테 {
    private static List<int[]>[] graph;
    private static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        distance = new int[n+1];
        for (int i = 0; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // a 노드에서 b 노드까지 비용이 c다
            graph[a].add(new int[]{b, c});
        }

        dijkstra(start);

        for (int i = 0; i < distance.length; i++) {
            System.out.println(i+":"+ distance[i]);
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(Node::getDist));
        q.add(new Node(start, 0));

        distance[start] = 0;
        while(!q.isEmpty()) {
            Node n = q.poll();

            int now = n.node;
            int dist = n.dist;

            for(int[] i : graph[now]) {
                int cost = dist + i[1];
                if(cost < distance[i[0]]) {
                    distance[i[0]] = cost;
                    q.add(new Node(i[0], cost));
                }
            }
        }
    }

    static class Node {
        private int node;
        private int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        public int getDist() {
            return dist;
        }
    }
}
