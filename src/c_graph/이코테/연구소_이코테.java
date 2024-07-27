package c_graph.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 벽을 3개 세운다. -> dfs
 * 2. 바이러스를 퍼트린다. -> dfs/bfs
 * 3. 영역을 계산한다.
 */
public class 연구소_이코테 {
    private static Integer[][] map;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int result = 0;
    public static void main(String[] args) throws IOException {
        // 0 빈칸, 1 벽, 2 바이러스
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new Integer[n][m];
        for (int i = 0; i < n; i++) {
            Integer[] inputs = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt).toArray(Integer[]::new);
            map[i] = inputs;
        }

        dfs(0);
        System.out.println("result = " + result);
    }

    private static void dfs(int count) {
        if(count == 3) {
            Integer[][] temp = new Integer[map.length][map[0].length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = map[i].clone();
            }
            // 바이러스 전파
            virus(temp);
            // 안전영역취득
            int safeArea = getArea(temp);
            result = Math.max(result, safeArea);
        } else {
            for(int i=0; i<map.length; i++) {
                for(int j=0; j<map[0].length; j++) {
                    if(map[i][j] == 0) {
                        map[i][j] = 1;
                        dfs(count + 1);
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    private static void virus(Integer[][] map) {
        int row = map.length;
        int column = map[0].length;

        Queue<int[]> q = new LinkedList();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(map[i][j] == 2) {
                    q.add(new int[]{i, j});

                    while(!q.isEmpty()) {
                        int[] poll = q.poll();
                        int y = poll[0];
                        int x = poll[1];

                        for (int k = 0; k < 4; k++) {
                            int ny = y + dy[k];
                            int nx = x + dx[k];

                            if(nx >= 0 && ny >= 0 && nx < column && ny < row
                                && map[ny][nx] == 0) {
                                q.add(new int[]{ny, nx});
                                map[ny][nx] = 2;
                            }
                        }

                    }
                }
            }
        }
    }

    private static int getArea(Integer[][] map) {
        int result = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    result++;
                }
            }
        }

        return result;
    }


}
