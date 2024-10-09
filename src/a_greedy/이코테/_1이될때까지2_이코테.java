package a_greedy.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1이될때까지2_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int result = 0;
        while (n > 1) {
            if (n % k == 0) {
                n /= k;
            } else {
                n -= 1;
            }
            result++;
        }

        System.out.println("result = " + result);
    }
}
