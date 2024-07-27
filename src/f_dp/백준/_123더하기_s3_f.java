package f_dp.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _123더하기_s3_f {
    private static int[] dp = new int[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int result = calculate(n);

            System.out.println(result);
        }
    }

    private static int calculate(int n) {
        if(n == 1 || n == 2 || n == 3) return dp[n];

        if(dp[n] == 0) {
            dp[n - 1] = dp[n - 1] == 0 ? calculate(n - 1) : dp[n - 1];
            dp[n - 2] = dp[n - 2] == 0 ? calculate(n - 2) : dp[n - 2];
            dp[n - 3] = dp[n - 3] == 0 ? calculate(n - 3) : dp[n - 3];
            dp[n] = dp[n - 1] + dp[n - 2] + dp[n - 3];
        }
        return dp[n];
    }
}
