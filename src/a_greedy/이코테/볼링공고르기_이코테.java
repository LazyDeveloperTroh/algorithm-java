package a_greedy.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 볼링공고르기_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] balls = new int[11];
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            int ball = Integer.parseInt(st.nextToken());
            balls[ball] += 1;
        }

        int result = 0;
        for (int i = 0; i < balls.length; i++) {
            int sum = 0;
            for (int j = i + 1; j < balls.length; j++) {
                sum += balls[j];
            }
            result += (balls[i] * sum);
        }

        System.out.println("result = " + result);
    }
}
