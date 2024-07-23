package a_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class 큰수의법칙_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> numbers = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
                .sorted(Comparator.reverseOrder()).toList();

        int max1 = numbers.get(0);
        int max2 = numbers.get(1);

        int result = 0;
        result += (m / k) * k * max1;
        m = m % k;
        result += m * max2;

        System.out.println("result = " + result);
    }
}
