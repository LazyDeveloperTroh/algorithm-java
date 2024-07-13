package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 단지번호붙이기_2667_s1 {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static List<Integer> results = new ArrayList<>();
    private static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = br.readLine().toCharArray();
        }

        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1' && !visited[i][j]) {
                    cnt = 0;
                    dfs(i, j, matrix, visited);
                    results.add(cnt);
                }
            }
        }

        results.sort(Comparator.naturalOrder());
        System.out.println(results.size());
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }

    private static void dfs(int y, int x, char[][] matrix, boolean[][] visited) {
        if(visited[y][x]) return;

        visited[y][x] = true;
        cnt++;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx >= 0 && ny >= 0 && nx < matrix.length && ny < matrix.length) {
                if(!visited[ny][nx] && matrix[ny][nx] == '1') {
                    dfs(ny, nx, matrix, visited);
                }
            }
        }
    }
}
