package a_greedy.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 숫자카드게임_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> numbers = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::valueOf)
                    .sorted(Comparator.naturalOrder())
                    .toList();

            result = Math.max(result, numbers.get(0));
        }
        System.out.println("result = " + result);
    }
}
