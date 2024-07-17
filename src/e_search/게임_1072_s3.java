package e_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 게임_1072_s3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int ratio = getWinRatio(x, y);

        int answer = -1;
        int left = 0;
        int right = x;

        while (left <= right) {
            int mid = (left + right) / 2;

            int newRatio = getWinRatio(x + mid, y + mid);
            if(ratio < newRatio) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }


    private static int getWinRatio(int x, int y) {
        return (int) ((long) y * 100 / x);
    }
}
