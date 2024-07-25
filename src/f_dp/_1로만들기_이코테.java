package f_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1로만들기_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int[] dp = new int[x + 1];
        for(int i=2; i<=x; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[1] = 0;

        for (int i = 2; i <= x; i++) {
            if(i == 2 || i == 3 || i == 5) {
                dp[i] = 1;
                continue;
            }

            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }

            if(i % 5 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 5] + 1);
            }

            dp[i] = Math.min(dp[i], dp[i-1] + 1);
        }
        System.out.println(dp[x]);
    }
}
