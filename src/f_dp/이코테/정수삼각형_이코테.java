package f_dp.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * 1. 점화식 dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + map[i][j]
 * 2. 맨 바닥에서 최대값 탐색
 */
public class 정수삼각형_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            List<Integer> numbers = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList();
            for (int j = 0; j < numbers.size(); j++) {
                triangle[i][j] = numbers.get(j);
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i-1 >= 0 && j-1 >= 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
                }
                if (i - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                dp[i][j] += triangle[i][j];
            }
        }
        int result = 0;
        for (int j = 0; j < n; j++) {
            result = Math.max(result, dp[n - 1][j]);
        }
        System.out.println("result = " + result);
    }
}
