package f_dp.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치함수_1003_s3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Result[] dp = new Result[n + 1];

            Result result = getResult(n, dp);
            System.out.println(result.r1+" "+ result.r2);
        }
    }

    private static Result getResult(int n, Result[] dp) {
        if(n == 0) return new Result(1, 0);
        if(n == 1) return new Result(0, 1);

        dp[n - 1] = dp[n - 1] == null ? getResult(n - 1, dp) : dp[n - 1];
        dp[n - 2] = dp[n - 2] == null ? getResult(n - 2, dp) : dp[n - 2];

        Result r1 = dp[n - 1];
        Result r2 = dp[n - 2];

        dp[n] = new Result(r1.r1 + r2.r1, r1.r2 + r2.r2);
        return dp[n];
    }

    static class Result {
        private int r1;
        private int r2;

        public Result(int r1, int r2) {
            this.r1 = r1;
            this.r2 = r2;
        }
    }
}
