package c_graph.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 음료수얼려먹기_이코테 {
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Integer[][] maps = new Integer[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Integer[] inputs = new Integer[m];
            Arrays.stream(br.readLine().split("")).map(Integer::parseInt).toList().toArray(inputs);
            maps[i] = inputs;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 공간0, 벽1
                if(maps[i][j] == 0 && !visited[i][j]) {
                    dfs(maps, i, j, visited);
                    result++;
                    System.out.println("");
                }
             }
        }
        System.out.println("result = " + result);
    }

    private static void dfs(Integer[][] maps, int y, int x, boolean[][] visited) {
        if(visited[y][x]) return;

        visited[y][x] = true;
        System.out.printf(String.format("(%d, %d)", y, x));
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && ny >= 0 && ny < maps.length && nx < maps[0].length
                    && maps[ny][nx] == 0 && !visited[ny][nx]) {
                dfs(maps, ny, nx, visited);
            }
        }
    }
}
