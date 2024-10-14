package c_graph.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 음료수얼려먹기2_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Integer[][] map = new Integer[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(""))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 빈공간이라면 dfs 실행
                if (map[i][j] == 0 && !visited[i][j]) {
                    dfs(map, j, i, visited);
                    result++;
                }
            }
        }
        System.out.println("result = " + result);
    }

    public static void dfs(Integer[][] map, int x, int y, boolean[][] visited) {
        visited[y][x] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            // 틀안에 좌표가 들어오는지 확인
            if(nx < 0 || nx  >= map[0].length || ny < 0 || ny >= map.length) {
                continue;
            }

            if(map[ny][nx] == 0 && !visited[ny][nx]) {
                dfs(map, nx, ny, visited);
            }
        }
    }
}
