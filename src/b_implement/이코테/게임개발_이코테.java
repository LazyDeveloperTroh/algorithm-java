package b_implement.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 게임개발_이코테 {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Integer[][] map = new Integer[n][m];
        boolean[][] visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine(), " ");
        int y = Integer.parseInt(st.nextToken()) ;
        int x = Integer.parseInt(st.nextToken()) ;
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            Integer[] arrays = new Integer[m];
            Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList().toArray(arrays);
            map[i] = arrays;
        }

        visited[y][x] = true;
        int result = 1;
        while (true) {
            boolean moveable = false;
            for (int k = 0; k < 4; k++) {
                int nd = ((d - 1) + 4)%4;

                int nx = x + dx[nd];
                int ny = y + dy[nd];

                // 방문하지 않음 & 육지임 & 맵을 벗어나지 않음
                if(nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[ny][nx] && map[ny][nx] == 0) {
                    d = nd;
                    x = nx;
                    y = ny;
                    result++;
                    visited[ny][nx] = true;
                    moveable = true;
                    break;
                } else {
                    d = nd;
                }
            }

            if(!moveable) {
                int ny = y;
                int nx = x;
                if(d == 0) ny += 1;
                else if(d == 1) nx -= 1;
                else if(d == 2) ny -= 1;
                else if(d == 3) nx += 1;

                if(nx < 0 || ny < 0 || nx > m || ny > n) {
                    break;
                } else {
                    x = nx;
                    y = ny;
                }
            }
        }
        System.out.println("result = " + result);
    }
}
