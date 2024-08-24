package f_dp.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class 정수삼각형2_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            List<Integer> inputs = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList();
            for (int j = 0; j < inputs.size(); j++) {
                map[i][j] = inputs.get(j);
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = map[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int max = 0;
                if(i-1 >=0 && j-1 >= 0) {
                    max = Math.max(max, dp[i-1][j-1]);
                }
                if(i-1 >=0) {
                    max = Math.max(max, dp[i-1][j]);
                }
                dp[i][j] = max + map[i][j];
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[n-1][i]);
        }
        System.out.println("max = " + max);
    }
}
