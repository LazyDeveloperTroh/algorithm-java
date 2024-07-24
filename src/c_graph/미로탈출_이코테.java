package c_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탈출_이코테 {
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Integer[][] map = new Integer[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Integer[] inputs = new Integer[m];
            Arrays.stream(br.readLine().split("")).map(Integer::parseInt).toList().toArray(inputs);
            map[i] = inputs;
        }

        BFS(map, 0, 0, visited);
        System.out.println("map[n-1][m-1] = " + map[n-1][m-1]);
    }

    private static void BFS(Integer[][] map, int y, int x, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{y, x});
        visited[y][x] = true;

        while(!q.isEmpty()) {
            int[] v = q.poll();

            for (int k = 0; k < 4; k++) {
                int ny = v[0] + dy[k];
                int nx = v[1] + dx[k];

                if (nx >= 0 && ny >= 0 && ny < map.length && nx < map[0].length
                        && !visited[ny][nx] && map[ny][nx] == 1) {
                    q.add(new int[]{ny, nx});
                    visited[ny][nx] = true;

                    map[ny][nx] = map[v[0]][v[1]] + 1;
                }
            }
        }
    }
}
