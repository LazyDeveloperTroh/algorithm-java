package g_dijkstra.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로_1753_g4 {
    private static List<int[]>[] graph;
    private static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        // 그래프, 최단거리배열 초기화
        graph = new ArrayList[v+1];
        distance = new int[v + 1];
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // a 노드에서 b 노드로가는데 비용c
            graph[a].add(new int[]{c, b});
        }

        // 우선순위큐에 (비용, 시작노드) 추가
        PriorityQueue<QueueItem> q = new PriorityQueue<>();
        q.add(new QueueItem(0, start));

        while(!q.isEmpty()) {
            QueueItem poll = q.poll();
            int dist = poll.distance;
            int now = poll.node;

            // 이미 처리된 노드라면 스킵
            if(distance[now] < dist) {
                continue;
            }

            for(int[] i : graph[now]) {
                int cost = dist + i[0];
                if(cost < distance[i[1]]) {
                    distance[i[1]] = cost;
                    q.add(new QueueItem(cost, i[1]));
                }
            }
        }

        for (int i = 1; i < distance.length; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    static class QueueItem implements Comparable{
        int distance;
        int node;

        public QueueItem(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }

        @Override
        public int compareTo(Object o) {
            QueueItem obj = (QueueItem) o;
            if(distance < obj.distance) return -1;
            else if(distance > obj.distance) return 1;
            else {
                if(node < obj.node) return -1;
                else if(node > obj.node) return 1;
                else return 0;
            }
        }
    }
}
