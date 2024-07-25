package f_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 효율적인화폐구성 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dp = new int[10001];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins.add(coin);
            dp[coin] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for(int c : coins) {
                if(i-c > 0 && dp[i-c] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }

        System.out.println("dp[m] = " + dp[m]);
    }
}
