package b_implement.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연구소_g4 {
    private static int maxAreaSize = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        // 데이터 입력
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        
        // 벽세우기
        setWall(0, 0, map);
        
        System.out.println(maxAreaSize);
    }

    /**
     * 백트래킹
     * @param start
     * @param depth
     * @param map map[y][x] == 0 공간, map[y][x] == 1 벽, map[y][x] == 2 바이러스
     */
    private static void setWall(int start, int depth, int[][] map) {
        int rows = map.length;
        int columns = map[0].length;
        
        // 벽을 3개 세웠으면 바이러스를 퍼트리고 안전구역 계산
        if(depth == 3) {
            int[][] spreadedMap = getSpreadMap(map);
            int safeArea = getSafeArea(spreadedMap);
            maxAreaSize = Math.max(safeArea, maxAreaSize);
            return;
        }

        for (int i = start; i < rows * columns; i++) {
            int y = i / columns;
            int x = i % columns;

            if(map[y][x] == 0) {
                map[y][x] = 1;
                setWall(i, depth+1, map);
                map[y][x] = 0;
            }
        }
    }

    private static int[][] getSpreadMap(int[][] map) {
        int rows = map.length;
        int columns = map[0].length;

        // 맵 복사
        int[][] cloneMap = new int[rows][columns];
        for(int i=0; i<rows; i++) {
            System.arraycopy(map[i], 0, cloneMap[i], 0, columns);
        }

        // dfs
        boolean[][] visited = new boolean[rows][columns];
        for(int i=0; i<cloneMap.length; i++) {
            for(int j = 0; j< cloneMap[0].length; j++) {
                if(cloneMap[i][j] == 2 && !visited[i][j]) {
                    dfs(i, j, cloneMap, visited);
                }
            }
        }

        return cloneMap;
    }

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    private static void dfs(int y, int x, int[][] map, boolean[][] visited) {
        if(visited[y][x]) return;

        visited[y][x] = true;
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && nx >= 0 && ny < map.length && nx < map[0].length) {
                if(!visited[ny][nx] && map[ny][nx] == 0) {
                    map[ny][nx] = 2;
                    dfs(ny, nx, map, visited);
                }
            }
        }
    }

    private static int getSafeArea(int[][] map) {
        int safeArea = 0;

        int rows = map.length;
        int columns = map[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(map[i][j] == 0) safeArea ++;
            }
        }
        return safeArea;
    }
}
