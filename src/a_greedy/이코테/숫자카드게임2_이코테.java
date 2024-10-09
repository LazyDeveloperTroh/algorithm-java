package a_greedy.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 숫자카드게임2_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // n 행, m 열
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> input = new java.util.ArrayList<>(Arrays.stream(br.readLine().split(" "))
                    .map(Integer::valueOf)
                    .toList());

            // input.get(0)은 입력받은 값중에 가장 작은값을 의미한다.
            input.sort(Comparator.naturalOrder());
            result = Math.max(result, input.get(0));
        }
        System.out.println("result = " + result);
    }
}
