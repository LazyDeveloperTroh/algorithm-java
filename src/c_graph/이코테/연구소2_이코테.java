package c_graph.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소2_이코테 {
    private static String WALL = "1";
    private static String VIRUS = "2";
    private static String EMPTY = "0";
    private static String[][] map = null;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 데이터 입력
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] inputArray = br.readLine().split(" ");
            map[i] = inputArray;
        }

        // 풀이
        copyAndWall(0);
        System.out.println("max = " + max);
    }

    private static void copyAndWall(int wallCnt) {
        if(wallCnt == 3) {
            String[][] newMap = new String[map.length][map[0].length];

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    newMap[i][j] = map[i][j];
                }
            }

            // 2. 바이러스 퍼트리기
            virus(newMap);

            // 3. 안전구역 최대값 구하기
            int safeArea = getSafeArea(newMap);
            max = Math.max(max, safeArea);
        } else {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    // 1. 벽 3개 세우기
                    if(map[i][j].equals(EMPTY)) {
                        map[i][j] = WALL;
                        copyAndWall(wallCnt + 1);
                        map[i][j] = EMPTY;
                    }
                }
            }
        }
    }

    private static void virus(String[][] map) {
        int row = map.length;
        int column = map[0].length;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        boolean[][] visited = new boolean[row][column];
        for(int i=0; i<row; i++) {
            for(int j=0; j<column; j++) {
                if(map[i][j].equals(VIRUS) && !visited[i][j]) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    while(!q.isEmpty()) {
                        int[] poll = q.poll();
                        int x = poll[1];
                        int y = poll[0];

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if(nx >= 0 && ny >= 0 && nx < column && ny < row &&
                                    !visited[ny][nx] && map[ny][nx].equals(EMPTY)) {
                                q.add(new int[]{ny, nx});
                                visited[ny][nx] = true;
                                map[ny][nx] = VIRUS;
                            }
                        }
                    }
                }
            }
        }
    }

    private static int getSafeArea(String[][] map) {
        int cnt = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j].equals(EMPTY)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
