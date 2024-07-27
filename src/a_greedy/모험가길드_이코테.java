package a_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 모험가길드_이코테  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> fears = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.naturalOrder())
                .toList();

        int cnt = 0;
        int result = 0;
        int fear = 0;
        for (int i = 0; i < fears.size(); i++) {
            cnt++;
            if(cnt >= fears.get(i)) {
                result++;
                cnt = 0;
            }
        }

        System.out.println("result = " + result);
    }
}
