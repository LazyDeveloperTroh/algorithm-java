package b_implement.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 게임개발2_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // n 세로, ,m 가로
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        // h 세로위치, w 가로위치, d 방향( 0 북, 1 동, 2 남, 3 서)
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        // 지도, 방문처리 초기화
        Integer[][] map = new Integer[n + 1][m + 1];
        boolean[][] visited = new boolean[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::valueOf).toArray(Integer[]::new);
        }

        // 현재위치 방문처리
        visited[h][w] = true;
        int cnt = 1;

        /*
        1. 왼쪽 방향으로 전환
        2. 방향 전환 후 갈 수 있다면 이동, 갈 수 없다면 다시 왼쪽 방향으로 전환
        3. 모든 방향에 대해서 이동할 수 없다면 뒤로 1칸이동
        4. 뒤로도 이동할 수 없다면 stop
         */
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while (true) {
            boolean moveable = false;
            for (int k = 0; k < 4; k++) {
                int nd = (d + (4 - k - 1)) % 4;
                int nx = w + dx[nd];
                int ny = h + dy[nd];

                // map 을 벗어나는 경우
                if(nx < 1 || nx > m || ny < 1 || ny > n) {
                    continue;
                }

                // 해당 방향이 육지인 경우 & 방문하지 않은 경우
                if(map[ny][nx] == 0 && !visited[ny][nx]) {
                    d = nd; // 방향전환
                    visited[ny][nx] = true; // 방문처리
                    h = ny; // y 좌표이동
                    w = nx; // x 좌표이동
                    cnt++;
                    moveable = true;
                    break;
                }
            }

            // 4방향으로 이동할 수 없는 경우
            if(!moveable) {
                int nd = (d + 2) % 4;
                int nx = w + dx[nd];
                int ny = h + dy[nd];
                // 뒤가 바다인 경우 stop
                if(map[ny][nx] == 1 || nx < 1 || nx > m || ny < 1 || ny > n) {
                    break;
                }
                // 뒤로 이동
                else {
                    w = nx;
                    h = ny;
                }
            }
        }
        System.out.println("cnt = " + cnt);
    }
}
