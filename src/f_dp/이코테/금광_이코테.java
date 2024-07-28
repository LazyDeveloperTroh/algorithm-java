package f_dp.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 금광_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 금광 초기화
            int[][] map = new int[n][m];
            List<Integer> numbers = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList();
            for (int i = 0; i < numbers.size(); i++) {
                int row = i / m;
                int column = i % m;
                map[row][column] = numbers.get(i);
            }

            // dp 초기화
            int[][] dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                dp[i][0] = map[i][0];
            }

            // dp 점화식
            for (int j = 1; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    if (i - 1 >= 0 && j - 1 >= 0 ) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
                    }
                    if (j - 1 >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                    }
                    if (i + 1 < n && j - 1 >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i+1][j - 1]);
                    }
                    dp[i][j] += map[i][j];
                }
            }

            int result = 0;
            for (int i = 0; i < n; i++) {
                result = Math.max(result, dp[i][m - 1]);
            }
            System.out.println("result = " + result);
        }
    }
}
