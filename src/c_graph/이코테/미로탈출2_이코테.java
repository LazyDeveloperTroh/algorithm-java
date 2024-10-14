package c_graph.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탈출2_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Integer[][] map = new Integer[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(""))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }
        bfs(0, 0, map);
        System.out.println("map = " + map[n - 1][m - 1]);
    }

    public static void bfs(int x, int y, Integer[][] map) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        while (!q.isEmpty()) {
            int[] p = q.poll();

            // 상하좌우로 탐색
            for (int k = 0; k < 4; k++) {
                int nx = p[1] + dx[k];
                int ny = p[0] + dy[k];

                if(nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) continue;

                if(map[ny][nx] == 1) {
                    q.add(new int[]{ny, nx});
                    map[ny][nx] = map[p[0]][p[1]] + 1;
                }
            }
        }
    }
}
