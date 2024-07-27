package f_dp.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1로만들기_1463_s3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        int result = getDp(n, dp);
        System.out.println(result);
    }

    private static int getDp(int n, int[] dp) {
        if(n == 1) return 0;
        if(n == 2 || n == 3) return 1;
        if(dp[n] != 0) return dp[n];

        int count = Integer.MAX_VALUE;
        if(n % 2 == 0) {
            dp[n / 2] = dp[n / 2] == 0 ? getDp(n / 2, dp) : dp[n / 2];
            count = Math.min(count, dp[n / 2]);
        }

        if(n % 3 == 0) {
            dp[n / 3] = dp[n / 3] == 0 ? getDp(n / 3, dp) : dp[n / 3];
            count = Math.min(count, dp[n / 3]);
        }

        dp[n - 1] = dp[n - 1] == 0 ? getDp(n - 1, dp) : dp[n - 1];
        count = Math.min(count, dp[n - 1]);

        dp[n] = count + 1;
        return dp[n];
    }


}
