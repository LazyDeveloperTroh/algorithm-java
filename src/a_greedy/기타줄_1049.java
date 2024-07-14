package a_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타줄_1049 {
    private static final int MAX_PRICE = 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int minTotalPrice = MAX_PRICE;
        int minUnitPrice = MAX_PRICE;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            minTotalPrice = Math.min(minTotalPrice, Integer.parseInt(st.nextToken()));
            minUnitPrice = Math.min(minUnitPrice, Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        if(n >= 6) {
            result = Math.min(minTotalPrice, 6 * minUnitPrice) * (n / 6) + Math.min(minTotalPrice, (n % 6) * minUnitPrice);
        } else {
            result = Math.min(minTotalPrice,  (n % 6) * minUnitPrice);
        }
        System.out.println(result);
    }
}
