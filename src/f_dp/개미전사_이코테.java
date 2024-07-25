package f_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class 개미전사_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        
        List<Integer> array = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).toList();
        dp[0] = array.get(0);
        dp[1] = array.get(1);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + array.get(i), dp[i - 1]);
        }

        System.out.println("dp[n-1] = " + dp[n-1]);
    }
}
