package b_implement.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 시각_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        for (int h = 0; h <= n; h++) {
            for (int m = 0; m < 60; m++) {
                for (int s = 0; s < 60; s++) {
                    if(s == 3 || s == 13 || s == 23 || (30 <= s && s < 40) || s == 43 || s == 53
                        || m == 3 || m == 13 || m == 23 || (30 <= m && m < 40) || m == 43 || m == 53
                        || h == 3 || h == 13 || h == 23) {
                        result++;
                    }
                }
            }
        }

        System.out.println("result = " + result);
    }
}
