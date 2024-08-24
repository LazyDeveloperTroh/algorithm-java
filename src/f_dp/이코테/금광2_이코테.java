package f_dp.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 금광2_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int k = 0; k < t; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][m];
            Integer[] array = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList().stream().toArray(Integer[]::new);
            for(int i=0; i< array.length; i++) {
                int row = i/m;
                int col = i%m;
                map[row][col] = array[i];
            }


            int[][] dp = new int[n][m];
            for(int i=0; i< n; i++) {
                dp[i][0] = map[i][0];
            }
            for (int j = 0; j < m; j++) {
                for(int i = 0; i < n; i++) {
                    int max = 0;
                    if(i-1 >= 0 && j-1 >=0) {
                        max = Math.max(max, dp[i-1][j-1]);
                    }
                    if(j-1 >= 0) {
                        max =  Math.max(max, dp[i][j-1]);
                    }
                    if(i+1 < n && j-1 >= 0) {
                        max =  Math.max(max, dp[i+1][j-1]);
                    }
                    dp[i][j] = max+map[i][j];
                }
            }

            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, dp[i][m - 1]);
            }
            System.out.println("max = " + max);
        }
    }
}
